package edu.unb.tiashack.avocado_api.api.soap;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import java.util.List;

@WebService
public interface AvocadoSoapApiInterface {
    @WebMethod
    List<AvocadoSale> getAllAvocadoSales();
}
