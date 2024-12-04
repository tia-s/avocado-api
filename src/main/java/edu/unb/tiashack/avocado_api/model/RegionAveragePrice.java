/**
 * Class representing the average price of avocados for a specific region.
 * Used to encapsulate the result of custom queries that calculate the average price of avocados by region.
 *
 * This class is not mapped to a database table directly but serves as a lightweight object 
 * that explicitly defines the expected schema of the result returned by the calculateAveragePriceByRegion() method.
 * 
 * Note: This level of explicitness is crucial for the GraphQL API, given its strongly typed nature.
 */


package edu.unb.tiashack.avocado_api.model;

public class RegionAveragePrice {
    private String region;
    private Double averagePrice;

    public RegionAveragePrice(String region, Double averagePrice) {
        this.region = region;
        this.averagePrice = averagePrice;
    }

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
