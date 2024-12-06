/**
 * GraphQL Controller for managing Avocado Sales data.
 * 
 * This controller provides Query and Mutation mappings to enable interaction with the AvocadoSaleService 
 * using GraphQL queries and mutations.
 * 
 * Functionalities provided include fetching avocado sales data, creating new sales records,
 * updating existing sales, and calculating regional averages.
 * 
 * Note: This controller relies on DTO transformations (AvocadoSaleDTO) for GraphQL responses.
 * 
 * Endpoint Base Path: `/graphql`
 * 
 * Annotations:
 * @Controller: Marks this class as a Spring GraphQL controller.
 * @QueryMapping: Annotation for GraphQL queries.
 * @MutationMapping: Annotation for GraphQL mutations.
 * @Argument: Used to map GraphQL query/mutation arguments to method parameters.
*/

package edu.unb.tiashack.avocado_api.api.graphql;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.model.AvocadoSaleDTO;
import edu.unb.tiashack.avocado_api.model.RegionAveragePrice;
import edu.unb.tiashack.avocado_api.service.AvocadoSaleService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Map;

@Controller
public class AvocadoGraphQLApi {

    private final AvocadoSaleService avocadoSaleService;

    @Autowired
    public AvocadoGraphQLApi(AvocadoSaleService avocadoSaleService) {
        this.avocadoSaleService = avocadoSaleService;
    }

    // Retrieve all avocado sales records
    @QueryMapping
    public List<AvocadoSaleDTO> getAllAvocadoSales() {
        return avocadoSaleService.getAllAvocadoSales()
                             .stream()
                             .map(AvocadoSaleDTO::new)
                             .collect(Collectors.toList());

    }

    // Retrieve avocado sales record by ID
    @QueryMapping
    public AvocadoSaleDTO getAvocadoSaleById(@Argument Long id) {
        Optional<AvocadoSale> avocadoSale = avocadoSaleService.getAvocadoSaleById(id);
        return avocadoSale.map(AvocadoSaleDTO::new).orElse(null);
    }

    // Retrieve avocado sales records by type
    @QueryMapping
    public List<AvocadoSaleDTO> getAvocadoSalesByType(@Argument String type) {
  
        return avocadoSaleService.getAvocadoSalesByType(type)
                             .stream()
                             .map(AvocadoSaleDTO::new)
                             .collect(Collectors.toList());
    }

    // Retrieve avocado sales within price range
    @QueryMapping
    public List<AvocadoSaleDTO> getAvocadoSalesByPriceRange(@Argument double minPrice, @Argument double maxPrice) {
        return avocadoSaleService.getAvocadoSalesWithinPriceRange(minPrice, maxPrice)
                                .stream()
                                .map(AvocadoSaleDTO::new)
                                .collect(Collectors.toList());

    }

    // Create a new avocado sales record
    @MutationMapping
    public AvocadoSaleDTO createAvocadoSale(
            @Argument Long id,
            @Argument String date,
            @Argument double averagePrice,
            @Argument double totalVolume,
            @Argument double plu4046,
            @Argument double plu4225,
            @Argument double plu4770,
            @Argument double totalBags,
            @Argument double smallBags,
            @Argument double largeBags,
            @Argument double xLargeBags,
            @Argument String type,
            @Argument Long year,
            @Argument String region) {
        Date dateConvertedToDate = null;
        
        try {
            dateConvertedToDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        AvocadoSale avocadoSale = new AvocadoSale(id, dateConvertedToDate, averagePrice, totalVolume, plu4046, plu4225, plu4770, totalBags, smallBags, largeBags, xLargeBags, type, year, region);

    AvocadoSale savedSale = avocadoSaleService.createAvocadoSale(avocadoSale);
        return savedSale != null ? new AvocadoSaleDTO(savedSale) : null;
    }

    // Update an existing avocado sales record by ID
    @MutationMapping
    public AvocadoSaleDTO updateAvocadoSale(@Argument Long id, @Argument Map<String, Object> updates) {
        AvocadoSale updatedSale = avocadoSaleService.updateAvocadoSale(id, updates);
        return new AvocadoSaleDTO(updatedSale);
        
    }

    // Calculate average price by region
    @QueryMapping
    public List<RegionAveragePrice> calculateAveragePriceByRegion() {
        return avocadoSaleService.calculateAveragePriceByRegion();
    }

    // Delete an existing avocado sales record by ID
    @MutationMapping
    public boolean deleteAvocadoSale(@Argument Long id) {
        try {
            avocadoSaleService.deleteAvocadoSale(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
