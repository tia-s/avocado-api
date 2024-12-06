package edu.unb.tiashack.avocado_api.api.soap;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.model.AvocadoSaleDTO;
import edu.unb.tiashack.avocado_api.model.RegionAveragePrice;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import edu.unb.tiashack.avocado_api.service.AvocadoSaleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Override
    public List<AvocadoSaleDTO> getAllAvocadoSales(){
        // return avocadoSaleService.getAllAvocadoSales();
        return avocadoSaleService.getAllAvocadoSales()
                             .stream()
                             .map(AvocadoSaleDTO::new)
                             .collect(Collectors.toList());
    }

    @Override
    public AvocadoSaleDTO getAvocadoSaleById(Long id) {
        Optional<AvocadoSale> avocadoSale = avocadoSaleService.getAvocadoSaleById(id);
        return avocadoSale.map(AvocadoSaleDTO::new).orElse(null);
    }

    @Override
    public List<AvocadoSaleDTO> getAvocadoSalesByType(String type){
        return avocadoSaleService.getAvocadoSalesByType(type)
                                .stream()
                                .map(AvocadoSaleDTO::new)
                                .collect(Collectors.toList());
    }

    @Override
    public List<AvocadoSaleDTO> getAvocadoSalesByPriceRange(double minPrice, double maxPrice) {
        return avocadoSaleService.getAvocadoSalesWithinPriceRange(minPrice, maxPrice)
                                .stream()
                                .map(AvocadoSaleDTO::new)
                                .collect(Collectors.toList());
    }

    @Override
    public AvocadoSaleDTO createAvocadoSale(AvocadoSale avocadoSale) {
        AvocadoSale createdSale = avocadoSaleService.createAvocadoSale(avocadoSale);
        return new AvocadoSaleDTO(createdSale);
    }

    @Override
    public AvocadoSaleDTO updateAvocadoSale(Long id, Map<String, Object> updates) {
        AvocadoSale updatedSale = avocadoSaleService.updateAvocadoSale(id, updates);
        return new AvocadoSaleDTO(updatedSale);
    }

    @Override
    public List<RegionAveragePrice> calculateAveragePriceByRegion(){
        return avocadoSaleService.calculateAveragePriceByRegion();
    }

    @Override
    public void deleteAvocadoSale(Long id) {
        avocadoSaleService.deleteAvocadoSale(id);
    }
}