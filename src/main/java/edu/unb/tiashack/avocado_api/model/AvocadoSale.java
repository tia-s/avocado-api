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

    @Column(name = "date")
    private String date; // date of the sales observation

    @Column(name = "averageprice")
    private double averagePrice; // average price of the avocados

    @Column(name = "totalvolume")
    private double totalVolume; // total number of avocados sold

    // Getters and setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "AvocadoSale{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", averagePrice=" + averagePrice +
                ", totalVolume=" + totalVolume +
                '}';
    }
}
