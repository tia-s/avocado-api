package edu.unb.tiashack.avocado_api.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RegionAveragePrice")
public class RegionAveragePrice {
    private String region;
    private Double averagePrice;

    // Default constructor is required for JAXB
    public RegionAveragePrice() {
    }

    public RegionAveragePrice(String region, Double averagePrice) {
        this.region = region;
        this.averagePrice = averagePrice;
    }

    //get Region
    public String getRegion() {
        return region;
    }

    //set Region
    public void setRegion(String region) {
        this.region = region;
    }

    //get AveragePrice
    public Double getAveragePrice() {
        return averagePrice;
    }

    //set AveragePrice
    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }
}
