package edu.unb.tiashack.avocado_api.api.graphql;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.service.AvocadoSaleService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AvocadoGraphQLApi {

    private final AvocadoSaleService avocadoSaleService;

    @Autowired
    public AvocadoGraphQLApi(AvocadoSaleService avocadoSaleService) {
        this.avocadoSaleService = avocadoSaleService;
    }

    @QueryMapping
    public List<AvocadoSale> getAllAvocadoSales() {
        AvocadoSale sale1 = new AvocadoSale(2L, "2016-01-10", 1.45, 52345.45, 1085.32, 56432.14, 39.75, 7600.45, 7456.23, 144.22, 40, "d", 2L, "d");
        List<AvocadoSale> fakeSales = List.of(
                sale1,
                new AvocadoSale(5L, "2016-01-10", 1.45, 52345.45, 1085.32, 56432.14, 39.75, 7600.45, 7456.23, 144.22, 40, "d", 2L, "d")
        );
        System.out.println(sale1);
//        return avocadoSaleService.getAllAvocadoSales();
        return fakeSales;
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

    @MutationMapping
    public AvocadoSale createAvocadoSale(@Argument double price, @Argument int quantity, @Argument String date) {
        AvocadoSale avocadoSale = new AvocadoSale(); // You may need to adjust this constructor based on your model
        return avocadoSaleService.createAvocadoSale(avocadoSale);
    }

    @MutationMapping
    public AvocadoSale updateAvocadoSale(@Argument Long id, @Argument Double price, @Argument Integer quantity, @Argument String date) {
        AvocadoSale avocadoSale = new AvocadoSale(); // Adjust constructor if needed
        return avocadoSaleService.updateAvocadoSale(id, avocadoSale);
    }

    @MutationMapping
    public boolean deleteAvocadoSale(@Argument Long id) {
        avocadoSaleService.deleteAvocadoSale(id);
        return true;
    }
}
