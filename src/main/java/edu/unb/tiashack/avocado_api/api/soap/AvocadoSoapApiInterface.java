package edu.unb.tiashack.avocado_api.api.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.WebParam;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@WebService
public interface AvocadoSoapApiInterface {
    @WebMethod
    List<AvocadoSale> getAllAvocadoSales();

    @WebMethod
    AvocadoSale getAvocadoSaleById(@WebParam(name="id") Long id);

    @WebMethod
    List<AvocadoSale> getAvocadoSalesByPriceRange(@WebParam(name="minPrice") double minPrice, @WebParam(name="maxPrice") double maxPrice);

    @WebMethod
    AvocadoSale createAvocadoSale(@WebParam(name="avocadoSale") AvocadoSale avocadoSale);

    @WebMethod
    AvocadoSale updateAvocadoSale(@WebParam(name="id") Long id, @WebParam(name="avocadoSale") AvocadoSale avocadoSale);

    @WebMethod
    void deleteAvocadoSale(@WebParam(name="id") Long id);
}
