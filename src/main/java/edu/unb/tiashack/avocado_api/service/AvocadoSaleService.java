package edu.unb.tiashack.avocado_api.service;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.repository.AvocadoSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Map;

@Service
public class AvocadoSaleService {
    private final AvocadoSaleRepository avocadoSaleRepository;

    @Autowired
    public AvocadoSaleService(AvocadoSaleRepository avocadoSaleRepository) {
        this.avocadoSaleRepository = avocadoSaleRepository;
    }

    public List<AvocadoSale> getAllAvocadoSales() {
        return avocadoSaleRepository.findAll();
    }

    public Optional<AvocadoSale> getAvocadoSaleById(Long id) {
        return avocadoSaleRepository.findById(id);
    }

    public List<AvocadoSale> getAvocadoSalesByType(String type) {
        return avocadoSaleRepository.findByType(type);
    }

    public List<AvocadoSale> getAvocadoSalesWithinPriceRange(double minPrice, double maxPrice) {
        return avocadoSaleRepository.findByAveragePriceBetween(minPrice, maxPrice);
    }

    public AvocadoSale createAvocadoSale(AvocadoSale avocadoSale) {
        return avocadoSaleRepository.save(avocadoSale);
    }

    public AvocadoSale updateAvocadoSale(Long id, Map<String, Object> updates) {
        Optional<AvocadoSale> existingSaleOpt = avocadoSaleRepository.findById(id);

        if (existingSaleOpt.isPresent()) {
            AvocadoSale existingSale = existingSaleOpt.get();

            // Iterate over the map and update the corresponding fields
            updates.forEach((key, value) -> {
                switch (key) {
                    case "date":
                        if (value instanceof String) {
                            existingSale.setDate((String) value);
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
                        throw new IllegalArgumentException("Invalid field: " + key); // Handle invalid fields
                }
            });

            // Save the updated entity
            return avocadoSaleRepository.save(existingSale);
        } else {
            return null; // Return null if the sale with the given id doesn't exist
        }
    }

    public List<Object[]> calculateAveragePriceByRegion() {
        return avocadoSaleRepository.calculateAveragePriceByRegion();
    }

    public void deleteAvocadoSale(Long id) {
        avocadoSaleRepository.deleteById(id);
    }
}
