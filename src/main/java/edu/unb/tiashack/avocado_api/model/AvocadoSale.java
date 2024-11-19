package edu.unb.tiashack.avocado_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "avocado_sales")
public class AvocadoSale {
    @Id
    private Long id; // unique identifier for the avocado sales record

    @Column(name = "averageprice")
    private double averagePrice; // average price of the avocados

    @Column(name = "totalvolume")
    private double totalVolume; // total number of avocados sold

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public AvocadoSale() {}

    public AvocadoSale(Long id, double averagePrice, double totalVolume) {
        this.id = id;
        this.averagePrice = averagePrice;
        this.totalVolume = totalVolume;
    }

    @Override
    public String toString() {
        return "AvocadoSale{" +
                "id=" + id +
                ", averagePrice=" + averagePrice +
                ", totalVolume=" + totalVolume +
                '}';
    }
}
