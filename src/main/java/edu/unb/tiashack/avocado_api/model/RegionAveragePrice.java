package edu.unb.tiashack.avocado_api.model;

public class RegionAveragePrice {
    private String region;
    private Double averagePrice;

    public RegionAveragePrice(String region, Double averagePrice) {
        this.region = region;
        this.averagePrice = averagePrice;
    }

    // Getters and Setters
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }
}
