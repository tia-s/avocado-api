package edu.unb.tiashack.avocado_api.api.rest;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.service.AvocadoSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Map;


@RestController
@RequestMapping("/rest")
public class AvocadoRestApi {

    private final AvocadoSaleService avocadoSaleService;

    @Autowired
    public AvocadoRestApi(AvocadoSaleService avocadoSaleService) {
        this.avocadoSaleService = avocadoSaleService;
    }

    // Retrieve all avocado sales records
    @GetMapping
    public List<AvocadoSale> getAllAvocadoSales() {
        return avocadoSaleService.getAllAvocadoSales();
    }

    // Retrieve avocado sales record by ID
    @GetMapping("/{id}")
    public ResponseEntity<AvocadoSale> getAvocadoSaleById(@PathVariable Long id) {
        Optional<AvocadoSale> avocadoSale = avocadoSaleService.getAvocadoSaleById(id);
        return avocadoSale.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Retrieve avocado sales records by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<AvocadoSale>> getAvocadoSalesByType(@PathVariable String type) {
        List<AvocadoSale> avocadoSales = avocadoSaleService.getAvocadoSalesByType(type);
        return avocadoSales.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(avocadoSales);
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<AvocadoSale>> getAvocadoSalesByPriceRange(
            @RequestParam double minPrice,
            @RequestParam double maxPrice) {
        List<AvocadoSale> avocadoSales = avocadoSaleService.getAvocadoSalesWithinPriceRange(minPrice, maxPrice);
        return avocadoSales.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(avocadoSales);
    }

    // Create a new avocado sales record
    @PostMapping
    public ResponseEntity<AvocadoSale> createAvocadoSale(@RequestBody AvocadoSale avocadoSale) {
        AvocadoSale createdAvocadoSale = avocadoSaleService.createAvocadoSale(avocadoSale);
        return new ResponseEntity<>(createdAvocadoSale, HttpStatus.CREATED);
    }

    // Update an existing avocado sales record by ID
    @PutMapping("/{id}")
    public ResponseEntity<AvocadoSale> updateAvocadoSale(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        try {
            AvocadoSale updatedAvocadoSale = avocadoSaleService.updateAvocadoSale(id, updates);

            if (updatedAvocadoSale != null) {
                // Return the updated avocado sale with a 200 OK status
                return ResponseEntity.ok(updatedAvocadoSale);
            } else {
                // Return a 404 Not Found if the avocado sale with the given ID does not exist
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            // Return a 400 Bad Request for invalid input
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Calculate average price by region
//    @GetMapping("/average-price-by-region")
//    public ResponseEntity<List<Object[]>> getAveragePriceByRegion() {
//        List<Map<String, Object>> averagePriceByRegion = avocadoSaleService.calculateAveragePriceByRegion();
//
//        if (averagePriceByRegion != null && !averagePriceByRegion.isEmpty()) {
//            return ResponseEntity.ok(averagePriceByRegion);
//        } else {
//            return ResponseEntity.noContent().build();  // 204 No Content if no results
//        }
//    }

//    // Delete an existing avocado sales record by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<boolean> deleteAvocadoSale(@PathVariable Long id) {
//        avocadoSaleService.deleteAvocadoSale(id);
//        return ResponseEntity.noContent().build();
//    }
}

