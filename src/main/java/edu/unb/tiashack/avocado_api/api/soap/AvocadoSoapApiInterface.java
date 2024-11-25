package edu.unb.tiashack.avocado_api.api.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.WebParam;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@WebService
public interface AvocadoSoapApiInterface {
    @WebMethod
    List<AvocadoSale> getAllAvocadoSales();

    @WebMethod
    AvocadoSale getAvocadoSaleById(@WebParam(name="id") Long id);

    @WebMethod
    List<AvocadoSale> getAvocadoSalesByType(@WebParam(name="type") String type);

    @WebMethod
    List<AvocadoSale> getAvocadoSalesByPriceRange(@WebParam(name="minPrice") double minPrice, @WebParam(name="maxPrice") double maxPrice);

//    @WebMethod
//    AvocadoSale createAvocadoSale(@WebParam(name="avocadoSale") AvocadoSale avocadoSale);
//
//    @WebMethod
//    AvocadoSale updateAvocadoSale(@WebParam(name="id") Long id, @WebParam(name="updates") Map<String, Object> updates);
//
//    @WebMethod
//    void deleteAvocadoSale(@WebParam(name="id") Long id);
}
