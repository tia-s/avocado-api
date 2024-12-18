/**
 * SOAP API Interface for Avocado Sales operations.
 * 
 * Defines the contract for the SOAP web service.
 * 
 * Annotations:
 * - @WebService: Marks this as a SOAP web service interface.
 * - @WebMethod: Exposes methods as SOAP operations.
 * - @WebParam: Specifies parameter names for SOAP operations.
 */


package edu.unb.tiashack.avocado_api.api.soap;

import edu.unb.tiashack.avocado_api.model.RegionAveragePrice;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.WebParam;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.model.AvocadoSaleDTO;

import java.util.List;
import java.util.Map;

@WebService
public interface AvocadoSoapApiInterface {
    @WebMethod
    List<AvocadoSaleDTO> getAllAvocadoSales();

    @WebMethod
    AvocadoSaleDTO getAvocadoSaleById(@WebParam(name="id") Long id);

    @WebMethod
    List<AvocadoSaleDTO> getAvocadoSalesByType(@WebParam(name="type") String type);

    @WebMethod
    List<AvocadoSaleDTO> getAvocadoSalesByPriceRange(@WebParam(name="minPrice") double minPrice, @WebParam(name="maxPrice") double maxPrice);

    @WebMethod
    AvocadoSaleDTO createAvocadoSale(@WebParam(name="avocadoSale") AvocadoSale avocadoSale);

    @WebMethod
    AvocadoSaleDTO updateAvocadoSale(@WebParam(name="id") Long id, @WebParam(name="updates") Map<String, Object> updates);

    @WebMethod
    List<RegionAveragePrice> calculateAveragePriceByRegion();

    @WebMethod
    void deleteAvocadoSale(@WebParam(name="id") Long id);
}
