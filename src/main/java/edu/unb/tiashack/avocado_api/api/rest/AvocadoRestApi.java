package edu.unb.tiashack.avocado_api.api.rest;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.service.AvocadoSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/rest")
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

    // Retrieve avocado sales records within a specified price range
    @GetMapping("/price-range")
    public List<AvocadoSale> getAvocadoSalesByPriceRange(@RequestParam double minPrice,
                                                         @RequestParam double maxPrice) {
        return avocadoSaleService.getSalesWithinPriceRange(minPrice, maxPrice);
    }

    // Create a new avocado sales record
    @PostMapping
    public ResponseEntity<AvocadoSale> createAvocadoSale(@RequestBody AvocadoSale avocadoSale) {
        AvocadoSale createdAvocadoSale = avocadoSaleService.createAvocadoSale(avocadoSale);
        return new ResponseEntity<>(createdAvocadoSale, HttpStatus.CREATED);
    }

    // Update an existing avocado sales record
    @PutMapping("/{id}")
    public ResponseEntity<AvocadoSale> updateAvocadoSale(@PathVariable Long id,
                                                         @RequestBody AvocadoSale avocadoSale) {
        AvocadoSale updatedAvocadoSale = avocadoSaleService.updateAvocadoSale(id, avocadoSale);
        return ResponseEntity.ok(updatedAvocadoSale);
    }

    // Delete an existing avocado sales record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvocadoSale(@PathVariable Long id) {
        avocadoSaleService.deleteAvocadoSale(id);
        return ResponseEntity.noContent().build();
    }
}

