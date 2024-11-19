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
        Optional<AvocadoSale> existingSaleOpt = avocadoSaleRepository.findById(id);

        if (existingSaleOpt.isPresent()) {
            AvocadoSale existingSale = existingSaleOpt.get();

            // Update the fields of the existing AvocadoSale with the new values
            existingSale.setDate(avocadoSale.getDate());
            existingSale.setAveragePrice(avocadoSale.getAveragePrice());
            existingSale.setTotalVolume(avocadoSale.getTotalVolume());
            existingSale.setPlu4046(avocadoSale.getPlu4046());
            existingSale.setPlu4225(avocadoSale.getPlu4225());
            existingSale.setPlu4770(avocadoSale.getPlu4770());
            existingSale.setTotalBags(avocadoSale.getTotalBags());
            existingSale.setSmallBags(avocadoSale.getSmallBags());
            existingSale.setLargeBags(avocadoSale.getLargeBags());
            existingSale.setXLargeBags(avocadoSale.getXLargeBags());
            existingSale.setType(avocadoSale.getType());
            existingSale.setYear(avocadoSale.getYear());
            existingSale.setRegion(avocadoSale.getRegion());

            return avocadoSaleRepository.save(existingSale);
        } else {
            return null;
        }
    }

    public void deleteAvocadoSale(Long id) {
        avocadoSaleRepository.deleteById(id);
    }

}
