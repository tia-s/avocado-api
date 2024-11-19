package edu.unb.tiashack.avocado_api.api.graphql;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.service.AvocadoSaleService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class AvocadoGraphQLApi {

    private final AvocadoSaleService avocadoSaleService;

    @Autowired
    public AvocadoGraphQLApi(AvocadoSaleService avocadoSaleService) {
        this.avocadoSaleService = avocadoSaleService;
    }

    @QueryMapping
    public List<AvocadoSale> getAllAvocadoSales() {
        List<AvocadoSale> sales = avocadoSaleService.getAllAvocadoSales();
        System.out.println(sales);
        return sales;
    }

    @QueryMapping
    public AvocadoSale getAvocadoSaleById(@Argument Long id) {
        Optional<AvocadoSale> avocadoSale = avocadoSaleService.getAvocadoSaleById(id);
        return avocadoSale.orElse(null);
    }

    @QueryMapping
    public List<AvocadoSale> getAvocadoSalesByPriceRange(@Argument double minPrice, @Argument double maxPrice) {
        return avocadoSaleService.getSalesWithinPriceRange(minPrice, maxPrice);
    }
}
