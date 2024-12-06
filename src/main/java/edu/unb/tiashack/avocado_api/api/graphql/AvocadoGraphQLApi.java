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
import java.time.LocalDate;
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

    @QueryMapping
    public List<AvocadoSaleDTO> getAllAvocadoSales() {
       System.out.println(avocadoSaleService.getAllAvocadoSales());
        return avocadoSaleService.getAllAvocadoSales()
                             .stream()
                             .map(AvocadoSaleDTO::new)
                             .collect(Collectors.toList());

    }

    @QueryMapping
    public AvocadoSaleDTO getAvocadoSaleById(@Argument Long id) {
        Optional<AvocadoSale> avocadoSale = avocadoSaleService.getAvocadoSaleById(id);
        return avocadoSale.map(AvocadoSaleDTO::new).orElse(null);
    }

    @QueryMapping
    public List<AvocadoSaleDTO> getAvocadoSalesByType(@Argument String type) {
  
        return avocadoSaleService.getAvocadoSalesByType(type)
                             .stream()
                             .map(AvocadoSaleDTO::new)
                             .collect(Collectors.toList());
    }

    @QueryMapping
    public List<AvocadoSaleDTO> getAvocadoSalesByPriceRange(@Argument double minPrice, @Argument double maxPrice) {
        return avocadoSaleService.getAvocadoSalesWithinPriceRange(minPrice, maxPrice)
                                .stream()
                                .map(AvocadoSaleDTO::new)
                                .collect(Collectors.toList());

    }

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
            // Handle the exception as needed
        }
        AvocadoSale avocadoSale = new AvocadoSale(id, dateConvertedToDate, averagePrice, totalVolume, plu4046, plu4225, plu4770, totalBags, smallBags, largeBags, xLargeBags, type, year, region);
    System.out.println("AvocadoSale object created: " + avocadoSale);

    AvocadoSale savedSale = avocadoSaleService.createAvocadoSale(avocadoSale);
    System.out.println("AvocadoSale saved: " + savedSale);
        return savedSale != null ? new AvocadoSaleDTO(savedSale) : null;
    }

    @MutationMapping
    public AvocadoSaleDTO updateAvocadoSale(@Argument Long id, @Argument Map<String, Object> updates) {
        AvocadoSale updatedSale = avocadoSaleService.updateAvocadoSale(id, updates);
        return new AvocadoSaleDTO(updatedSale);
        
    }

    @QueryMapping
    public List<RegionAveragePrice> calculateAveragePriceByRegion() {
        return avocadoSaleService.calculateAveragePriceByRegion();
    }

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
