package edu.unb.tiashack.avocado_api.repository;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvocadoSaleRepository extends JpaRepository<AvocadoSale, Long> {
    // Find avocado sales within a specified price range
    List<AvocadoSale> findByAveragePriceBetween(double minPrice, double maxPrice);
}
