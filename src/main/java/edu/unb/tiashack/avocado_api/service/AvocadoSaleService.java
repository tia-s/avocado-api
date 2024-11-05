package edu.unb.tiashack.avocado_api.service;

import edu.unb.tiashack.avocado_api.model.AvocadoSale;
import edu.unb.tiashack.avocado_api.repository.AvocadoSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<AvocadoSale> getSalesWithinPriceRange(double minPrice, double maxPrice) {
        return avocadoSaleRepository.findByAveragePriceBetween(minPrice, maxPrice);
    }

    public AvocadoSale createAvocadoSale(AvocadoSale avocadoSale) {
        return avocadoSaleRepository.save(avocadoSale);
    }

    public AvocadoSale updateAvocadoSale(Long id, AvocadoSale avocadoSale) {
        avocadoSale.setId(id);
        return avocadoSaleRepository.save(avocadoSale);
    }

    public void deleteAvocadoSale(Long id) {
        avocadoSaleRepository.deleteById(id);
    }

}
