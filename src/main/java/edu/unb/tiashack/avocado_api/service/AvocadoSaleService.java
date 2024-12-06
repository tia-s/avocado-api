/**
 * Service class for managing business logic related to AvocadoSale entities.
 * This class interacts with the AvocadoSaleRepository to retrieve, update, and manage 
 * avocado sale data while implementing necessary validations and transaction management.
 *
 * 
 * Annotations:
 * This class uses Spring's @Service annotation to mark it as a service component 
 * and @Transactional annotations to ensure transactional integrity during database operations.
**/

package edu.unb.tiashack.avocado_api.service;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.model.RegionAveragePrice;
import edu.unb.tiashack.avocado_api.repository.AvocadoSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class AvocadoSaleService {
    private final AvocadoSaleRepository avocadoSaleRepository;

    @Autowired
    public AvocadoSaleService(AvocadoSaleRepository avocadoSaleRepository) {
        this.avocadoSaleRepository = avocadoSaleRepository;
    }

    /*
     * Get all avocado sales
     * @return List of all avocado sales
     */
    @Transactional(readOnly = true)
    public List<AvocadoSale> getAllAvocadoSales() {
        return avocadoSaleRepository.findAll();
    }

    /*
     * Get avocado sale by ID
     * @param id The ID of the avocado sale
     * @return The avocado sale with the specified ID
     */
    @Transactional(readOnly = true)
    public Optional<AvocadoSale> getAvocadoSaleById(Long id) {
        return avocadoSaleRepository.findById(id);
    }

    /*
     * Get avocado sales by type
     * @param type The type of avocado
     * @return List of avocado sales of the specified type
     */
    @Transactional(readOnly = true)
    public List<AvocadoSale> getAvocadoSalesByType(String type) {
        return avocadoSaleRepository.findByType(type);
    }

    /*
     * Get avocado sales within a specified price range
     * @param minPrice The minimum price
     * @param maxPrice The maximum price
     * @return List of avocado sales within the specified price range
     */
    @Transactional(readOnly = true)
    public List<AvocadoSale> getAvocadoSalesWithinPriceRange(double minPrice, double maxPrice) {
        return avocadoSaleRepository.findByAveragePriceBetween(minPrice, maxPrice);
    }

    /*
     * Create a new avocado sale
     * @param avocadoSale The avocado sale to create
     * @return The created avocado sale
     */
    @Transactional
    public AvocadoSale createAvocadoSale(AvocadoSale avocadoSale) {
        // return null;
        return avocadoSaleRepository.save(avocadoSale);
    }

    /*
     * Update an existing avocado sale
     * @param id The ID of the avocado sale to update
     * @param updates to be apply to the avocado sale
     * @return The updated avocado sale
     */
    @Transactional
   public AvocadoSale updateAvocadoSale(Long id, Map<String, Object> updates) {
    
    // Get the existing sale by ID
    Optional<AvocadoSale> existingSaleOpt = avocadoSaleRepository.findById(id);

    // If the sale exists, update the fields
    if (existingSaleOpt.isPresent()) {
        AvocadoSale existingSale = existingSaleOpt.get();

        // For each key in the updates map, update the corresponding field in the existing sale
        updates.forEach((key, value) -> {
            switch (key) {
                case "date":
                    if (value instanceof String) {
                        try {
                            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) value);
                            existingSale.setDate(date);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException("Invalid date format", e);
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid type for date");
                    }
                    break;
                case "averagePrice":
                    if (value instanceof Double) {
                        existingSale.setAveragePrice((Double) value);
                    } else {
                        throw new IllegalArgumentException("Invalid type for averagePrice");
                    }
                    break;
                case "totalVolume":
                    if (value instanceof Double) {
                        existingSale.setTotalVolume((Double) value);
                    } else {
                        throw new IllegalArgumentException("Invalid type for totalVolume");
                    }
                    break;
                case "plu4046":
                    if (value instanceof Double) {
                        existingSale.setPlu4046((Double) value);
                    } else {
                        throw new IllegalArgumentException("Invalid type for plu4046");
                    }
                    break;
                case "plu4225":
                    if (value instanceof Double) {
                        existingSale.setPlu4225((Double) value);
                    } else {
                        throw new IllegalArgumentException("Invalid type for plu4225");
                    }
                    break;
                case "plu4770":
                    if (value instanceof Double) {
                        existingSale.setPlu4770((Double) value);
                    } else {
                        throw new IllegalArgumentException("Invalid type for plu4770");
                    }
                    break;
                case "totalBags":
                    if (value instanceof Double) {
                        existingSale.setTotalBags((Double) value);
                    } else {
                        throw new IllegalArgumentException("Invalid type for totalBags");
                    }
                    break;
                case "smallBags":
                    if (value instanceof Double) {
                        existingSale.setSmallBags((Double) value);
                    } else {
                        throw new IllegalArgumentException("Invalid type for smallBags");
                    }
                    break;
                case "largeBags":
                    if (value instanceof Double) {
                        existingSale.setLargeBags((Double) value);
                    } else {
                        throw new IllegalArgumentException("Invalid type for largeBags");
                    }
                    break;
                case "xLargeBags":
                    if (value instanceof Double) {
                        existingSale.setXLargeBags((Double) value);
                    } else {
                        throw new IllegalArgumentException("Invalid type for xLargeBags");
                    }
                    break;
                case "type":
                    if (value instanceof String) {
                        existingSale.setType((String) value);
                    } else {
                        throw new IllegalArgumentException("Invalid type for type");
                    }
                    break;
                case "year":
                    if (value instanceof Long) {
                        existingSale.setYear((Long) value);
                    } else {
                        throw new IllegalArgumentException("Invalid type for year");
                    }
                    break;
                case "region":
                    if (value instanceof String) {
                        existingSale.setRegion((String) value);
                    } else {
                        throw new IllegalArgumentException("Invalid type for region");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + key);
            }
        });

        AvocadoSale updatedSale = avocadoSaleRepository.save(existingSale);
        return updatedSale;
    } else {
        throw new NoSuchElementException("No sale found with ID: " + id);
    }
}

    /*
     * Calculate the average price of avocados by region
     * @return List of region average prices
     */
    @Transactional(readOnly = true)
    public List<RegionAveragePrice> calculateAveragePriceByRegion() {
        return avocadoSaleRepository.calculateAveragePriceByRegion();
    }

    /*
     * Delete an existing avocado sale
     * @param id The ID of the avocado sale to delete
     */
    @Transactional
    public void deleteAvocadoSale(Long id) {
        avocadoSaleRepository.deleteById(id);
    }
}
