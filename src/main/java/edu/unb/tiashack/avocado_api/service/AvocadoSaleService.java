package edu.unb.tiashack.avocado_api.service;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.model.RegionAveragePrice;
import edu.unb.tiashack.avocado_api.repository.AvocadoSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.stream.Collectors;

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
            AvocadoSale existingSale = existingSaleOpt.get();// Get the existing sale

            //for each key in the updates map, update the corresponding field in the existing sale
            updates.forEach((key, value) -> {
                switch (key) {
                    case "date"://if the key is date update the date field in the existing sale with the value if the value is of type string else throw an exception
                        if (value instanceof String) {
                            existingSale.setDate((String) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for date");
                        }
                        break;
                    case "averagePrice"://if the key is averagePrice update the averagePrice field in the existing sale with the value if the value is of type double else throw an exception
                        if (value instanceof Double) {
                            existingSale.setAveragePrice((Double) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for averagePrice");
                        }
                        break;
                    case "totalVolume"://if the key is totalVolume update the totalVolume field in the existing sale with the value if the value is of type double else throw an exception
                        if (value instanceof Double) {
                            existingSale.setTotalVolume((Double) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for totalVolume");
                        }
                        break;
                    case "plu4046"://if the key is plu4046 update the plu4046 field in the existing sale with the value if the value is of type double else throw an exception
                        if (value instanceof Double) {
                            existingSale.setPlu4046((Double) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for plu4046");
                        }
                        break;
                    case "plu4225"://if the key is plu4225 update the plu4225 field in the existing sale with the value if the value is of type double else throw an exception
                        if (value instanceof Double) {
                            existingSale.setPlu4225((Double) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for plu4225");
                        }
                        break;
                    case "plu4770"://if the key is plu4770 update the plu4770 field in the existing sale with the value if the value is of type double else throw an exception
                        if (value instanceof Double) {
                            existingSale.setPlu4770((Double) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for plu4770");
                        }
                        break;
                    case "totalBags"://if the key is totalBags update the totalBags field in the existing sale with the value if the value is of type double else throw an exception
                        if (value instanceof Double) {
                            existingSale.setTotalBags((Double) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for totalBags");
                        }
                        break;
                    case "smallBags"://if the key is smallBags update the smallBags field in the existing sale with the value if the value is of type double else throw an exception
                        if (value instanceof Double) {
                            existingSale.setSmallBags((Double) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for smallBags");
                        }
                        break;
                    case "largeBags"://if the key is largeBags update the largeBags field in the existing sale with the value if the value is of type double else throw an exception
                        if (value instanceof Double) {
                            existingSale.setLargeBags((Double) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for largeBags");
                        }
                        break;
                    case "xLargeBags"://if the key is xLargeBags update the xLargeBags field in the existing sale with the value if the value is of type double else throw an exception
                        if (value instanceof Double) {
                            existingSale.setXLargeBags((Double) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for xLargeBags");
                        }
                        break;
                    case "type"://if the key is type update the type field in the existing sale with the value if the value is of type string else throw an exception
                        if (value instanceof String) {
                            existingSale.setType((String) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for type");
                        }
                        break;
                    case "year"://if the key is year update the year field in the existing sale with the value if the value is of type long else throw an exception
                        if (value instanceof Long) {
                            existingSale.setYear((Long) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for year");
                        }
                        break;
                    case "region"://if the key is region update the region field in the existing sale with the value if the value is of type string else throw an exception
                        if (value instanceof String) {
                            existingSale.setRegion((String) value);
                        } else {
                            throw new IllegalArgumentException("Invalid type for region");
                        }
                        break;
                    default://if the key is not any of the above throw an exception
                        throw new IllegalArgumentException("Invalid field: " + key); // Handle invalid fields
                }
            });

            return avocadoSaleRepository.save(existingSale);//save the updated sale
        } else {//if the sale does not exist return null
            return null;
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
