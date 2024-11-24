//package edu.unb.tiashack.avocado_api.api.graphql;
//
//import edu.unb.tiashack.avocado_api.model.AvocadoSale;
//import edu.unb.tiashack.avocado_api.service.AvocadoSaleService;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//public class AvocadoGraphQLApi {
//
//    private final AvocadoSaleService avocadoSaleService;
//
//    @Autowired
//    public AvocadoGraphQLApi(AvocadoSaleService avocadoSaleService) {
//        this.avocadoSaleService = avocadoSaleService;
//    }
//
//    @QueryMapping
//    public List<AvocadoSale> getAllAvocadoSales() {
//        return avocadoSaleService.getAllAvocadoSales();
//    }
//
//    @QueryMapping
//    public AvocadoSale getAvocadoSaleById(@Argument Long id) {
//        Optional<AvocadoSale> avocadoSale = avocadoSaleService.getAvocadoSaleById(id);
//        return avocadoSale.orElse(null);
//    }
//
//    @QueryMapping
//    public List<AvocadoSale> getAvocadoSalesByPriceRange(@Argument double minPrice, @Argument double maxPrice) {
//        return avocadoSaleService.getSalesWithinPriceRange(minPrice, maxPrice);
//    }
//
//    @MutationMapping
//    public AvocadoSale createAvocadoSale(
//            @Argument Long id,
//            @Argument String date,
//            @Argument double averagePrice,
//            @Argument double totalVolume,
//            @Argument double plu4046,
//            @Argument double plu4225,
//            @Argument double plu4770,
//            @Argument double totalBags,
//            @Argument double smallBags,
//            @Argument double largeBags,
//            @Argument double xLargeBags,
//            @Argument String type,
//            @Argument Long year,
//            @Argument String region) {
//
//        AvocadoSale avocadoSale = new AvocadoSale(id, date, averagePrice, totalVolume, plu4046, plu4225, plu4770, totalBags, smallBags, largeBags, xLargeBags, type, year, region);
//        return avocadoSaleService.createAvocadoSale(avocadoSale);
//    }
//
////    @MutationMapping
////    public AvocadoSale updateAvocadoSale(
////            @Argument Long id,
////            @Argument String date,
////            @Argument double averagePrice,
////            @Argument double totalVolume,
////            @Argument double plu4046,
////            @Argument double plu4225,
////            @Argument double plu4770,
////            @Argument double totalBags,
////            @Argument double smallBags,
////            @Argument double largeBags,
////            @Argument double xLargeBags,
////            @Argument String type,
////            @Argument Long year,
////            @Argument String region) {
////
////        AvocadoSale avocadoSale = new AvocadoSale(id, date, averagePrice, totalVolume, plu4046, plu4225, plu4770, totalBags, smallBags, largeBags, xLargeBags, type, year, region);
////        return avocadoSaleService.createAvocadoSale(avocadoSale);
////    }
//
//    @MutationMapping
//    public boolean deleteAvocadoSale(@Argument Long id) {
//        avocadoSaleService.deleteAvocadoSale(id);
//        return true;
//    }
//
//
//}
