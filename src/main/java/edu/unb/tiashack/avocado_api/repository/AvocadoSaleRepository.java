package edu.unb.tiashack.avocado_api.repository;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.model.RegionAveragePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvocadoSaleRepository extends JpaRepository<AvocadoSale, Long> {
    // Find avocado sales within a specified price range
    List<AvocadoSale> findByAveragePriceBetween(double minPrice, double maxPrice);

//    @Query("SELECT a.region, AVG(a.averagePrice) FROM AvocadoSale a GROUP BY a.region")
    @Query("SELECT new edu.unb.tiashack.avocado_api.model.RegionAveragePrice(region, AVG(averagePrice)) " +
            "FROM AvocadoSale WHERE region IS NOT NULL GROUP BY region")
    List<RegionAveragePrice> calculateAveragePriceByRegion();

    List<AvocadoSale> findByType(String type);
}
