package edu.unb.tiashack.avocado_api.api.soap;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
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

@WebService(endpointInterface = "edu.unb.tiashack.avocado_api.api.soap.AvocadoSoapApiInterface")
@Service
public class AvocadoSoapApi implements AvocadoSoapApiInterface {
    private final AvocadoSaleService avocadoSaleService;

    @Autowired
    public AvocadoSoapApi(AvocadoSaleService avocadoSaleService) {
        this.avocadoSaleService = avocadoSaleService;
    }

    @Override
    public List<AvocadoSale> getAllAvocadoSales(){
        return avocadoSaleService.getAllAvocadoSales();
    }

    @Override
    public AvocadoSale getAvocadoSaleById(Long id) {
        Optional<AvocadoSale> avocadoSale = avocadoSaleService.getAvocadoSaleById(id);
        return avocadoSale.orElse(null);
    }

    @Override
    public List<AvocadoSale> getAvocadoSalesByType(String type){
        return avocadoSaleService.getAvocadoSalesByType(type);
    }

    @Override
    public List<AvocadoSale> getAvocadoSalesByPriceRange(double minPrice, double maxPrice) {
        return avocadoSaleService.getAvocadoSalesWithinPriceRange(minPrice, maxPrice);
    }

    @Override
    public AvocadoSale createAvocadoSale(AvocadoSale avocadoSale) {
        return avocadoSaleService.createAvocadoSale(avocadoSale);
    }

    @Override
    public AvocadoSale updateAvocadoSale(Long id, Map<String, Object> updates) {
        return avocadoSaleService.updateAvocadoSale(id, updates);
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