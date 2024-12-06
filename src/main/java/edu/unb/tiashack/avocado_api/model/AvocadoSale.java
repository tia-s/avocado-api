/**
 * Entity class representing an avocado sale record.
 * 
 * Maps to the "avocado_sales" table in the database and defines the structure of 
 * the table's columns as fields in the class.
*/
package edu.unb.tiashack.avocado_api.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "avocado_sales")
public class AvocadoSale {
    @Id
    private Long id; 

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date; 

    @Column(name = "averageprice")
    private double averagePrice; 

    @Column(name = "totalvolume")
    private double totalVolume; 

    @Column(name = "plu4046")
    private double plu4046;

    @Column(name = "plu4225")
    private double plu4225;

    @Column(name = "plu4770")
    private double plu4770;

    @Column(name = "totalbags")
    private double totalBags;

    @Column(name = "smallbags")
    private double smallBags;

    @Column(name = "largebags")
    private double largeBags;

    @Column(name = "xlargebags")
    private double xLargeBags;

    @Column(name = "type")
    private String type;

    @Column(name = "year")
    private Long year;

    @Column(name = "region")
    private String region;

    public AvocadoSale() {}

    public AvocadoSale(Long id, Date date, double averagePrice, double totalVolume,
                           double plu4046, double plu4225, double plu4770, double totalBags,
                           double smallBags, double largeBags, double xLargeBags, String type,
                           Long year, String region) {
        this.id = id;
        this.date = date;
        this.averagePrice = averagePrice;
        this.totalVolume = totalVolume;
        this.plu4046 = plu4046;
        this.plu4225 = plu4225;
        this.plu4770 = plu4770;
        this.totalBags = totalBags;
        this.smallBags = smallBags;
        this.largeBags = largeBags;
        this.xLargeBags = xLargeBags;
        this.type = type;
        this.year = year;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public double getPlu4046() {
        return plu4046;
    }

    public void setPlu4046(double plu4046) {
        this.plu4046 = plu4046;
    }

    public double getPlu4225() {
        return plu4225;
    }

    public void setPlu4225(double plu4225) {
        this.plu4225 = plu4225;
    }

    public double getPlu4770() {
        return plu4770;
    }

    public void setPlu4770(double plu4770) {
        this.plu4770 = plu4770;
    }

    public double getTotalBags() {
        return totalBags;
    }

    public void setTotalBags(double totalBags) {
        this.totalBags = totalBags;
    }

    public double getSmallBags() {
        return smallBags;
    }

    public void setSmallBags(double smallBags) {
        this.smallBags = smallBags;
    }

    public double getLargeBags() {
        return largeBags;
    }

    public void setLargeBags(double largeBags) {
        this.largeBags = largeBags;
    }

    public double getXLargeBags() {
        return xLargeBags;
    }

    public void setXLargeBags(double xLargeBags) {
        this.xLargeBags = xLargeBags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "AvocadoSale{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", averagePrice=" + averagePrice +
                ", totalVolume=" + totalVolume +
                ", plu4046=" + plu4046 +
                ", plu4225=" + plu4225 +
                ", plu4770=" + plu4770 +
                ", totalBags=" + totalBags +
                ", smallBags=" + smallBags +
                ", largeBags=" + largeBags +
                ", xLargeBags=" + xLargeBags +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", region='" + region + '\'' +
                '}';
    }
}
