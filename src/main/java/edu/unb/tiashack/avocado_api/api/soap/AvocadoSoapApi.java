/**
 * SOAP Web Service for managing Avocado Sales data.
 * 
 * This service provides SOAP endpoints to interact with the AvocadoSaleService.
 * 
 * Interface Implementation:
 * - Implements the `AvocadoSoapApiInterface` to define contract-based SOAP operations.
 * 
 * Endpoint Base Path: `/soap`
 * 
 * Annotations:
 * - @WebService: Marks this class as a SOAP Web Service and specifies the endpoint interface.
 * - @Service: Indicates this is a Spring-managed service bean.
 * - @Autowired: Injects the `AvocadoSaleService` dependency.
 */

package edu.unb.tiashack.avocado_api.api.soap;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.model.AvocadoSaleDTO;
import edu.unb.tiashack.avocado_api.model.RegionAveragePrice;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.unb.tiashack.avocado_api.service.AvocadoSaleService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@WebService(endpointInterface = "edu.unb.tiashack.avocado_api.api.soap.AvocadoSoapApiInterface")
@Service
public class AvocadoSoapApi implements AvocadoSoapApiInterface {
    private final AvocadoSaleService avocadoSaleService;

    @Autowired
    public AvocadoSoapApi(AvocadoSaleService avocadoSaleService) {
        this.avocadoSaleService = avocadoSaleService;
    }

    // Retrieve all avocado sales records
    @Override
    public List<AvocadoSaleDTO> getAllAvocadoSales(){
        return avocadoSaleService.getAllAvocadoSales()
                             .stream()
                             .map(AvocadoSaleDTO::new)
                             .collect(Collectors.toList());
    }

    // Retrieve avocado sales record by ID
    @Override
    public AvocadoSaleDTO getAvocadoSaleById(Long id) {
        Optional<AvocadoSale> avocadoSale = avocadoSaleService.getAvocadoSaleById(id);
        return avocadoSale.map(AvocadoSaleDTO::new).orElse(null);
    }

    // Retrieve avocado sales records by type
    @Override
    public List<AvocadoSaleDTO> getAvocadoSalesByType(String type){
        return avocadoSaleService.getAvocadoSalesByType(type)
                                .stream()
                                .map(AvocadoSaleDTO::new)
                                .collect(Collectors.toList());
    }

    // Retrieve avocado sales within price range
    @Override
    public List<AvocadoSaleDTO> getAvocadoSalesByPriceRange(double minPrice, double maxPrice) {
        return avocadoSaleService.getAvocadoSalesWithinPriceRange(minPrice, maxPrice)
                                .stream()
                                .map(AvocadoSaleDTO::new)
                                .collect(Collectors.toList());
    }

    // Create a new avocado sales record
    @Override
    public AvocadoSaleDTO createAvocadoSale(AvocadoSale avocadoSale) {
        AvocadoSale createdSale = avocadoSaleService.createAvocadoSale(avocadoSale);
        return new AvocadoSaleDTO(createdSale);
    }

    // Update an existing avocado sales record by ID
    @Override
    public AvocadoSaleDTO updateAvocadoSale(Long id, Map<String, Object> updates) {
        AvocadoSale updatedSale = avocadoSaleService.updateAvocadoSale(id, updates);
        return new AvocadoSaleDTO(updatedSale);
    }

    // Calculate average price by region
    @Override
    public List<RegionAveragePrice> calculateAveragePriceByRegion(){
        return avocadoSaleService.calculateAveragePriceByRegion();
    }

    // Delete an existing avocado sales record by ID
    @Override
    public void deleteAvocadoSale(Long id) {
        avocadoSaleService.deleteAvocadoSale(id);
    }
}