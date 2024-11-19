package edu.unb.tiashack.avocado_api.api.soap;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.unb.tiashack.avocado_api.service.AvocadoSaleService;

import java.util.List;

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
}