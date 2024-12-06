package edu.unb.tiashack.avocado_api.model;

import java.text.SimpleDateFormat;

public class AvocadoSaleDTO {
    private Long id;
    private String date; // Use String for GraphQL compatibility
    private Double averagePrice;
    private Double totalVolume;
    private Double plu4046;
    private Double plu4225;
    private Double plu4770;
    private Double totalBags;
    private Double smallBags;
    private Double largeBags;
    private Double xLargeBags;
    private String type;
    private Long year;
    private String region;

    public AvocadoSaleDTO(AvocadoSale sale) {
        this.id = sale.getId();
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(sale.getDate());
        this.averagePrice = sale.getAveragePrice();
        this.totalVolume = sale.getTotalVolume();
        this.plu4046 = sale.getPlu4046();
        this.plu4225 = sale.getPlu4225();
        this.plu4770 = sale.getPlu4770();
        this.totalBags = sale.getTotalBags();
        this.smallBags = sale.getSmallBags();
        this.largeBags = sale.getLargeBags();
        this.xLargeBags = sale.getXLargeBags();
        this.type = sale.getType();
        this.year = sale.getYear();
        this.region = sale.getRegion();
    }

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

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public Double getPlu4046() {
        return plu4046;
    }

    public void setPlu4046(Double plu4046) {
        this.plu4046 = plu4046;
    }

    public Double getPlu4225() {
        return plu4225;
    }

    public void setPlu4225(Double plu4225) {
        this.plu4225 = plu4225;
    }

    public Double getPlu4770() {
        return plu4770;
    }

    public void setPlu4770(Double plu4770) {
        this.plu4770 = plu4770;
    }

    public Double getTotalBags() {
        return totalBags;
    }

    public void setTotalBags(Double totalBags) {
        this.totalBags = totalBags;
    }

    public Double getSmallBags() {
        return smallBags;
    }

    public void setSmallBags(Double smallBags) {
        this.smallBags = smallBags;
    }

    public Double getLargeBags() {
        return largeBags;
    }

    public void setLargeBags(Double largeBags) {
        this.largeBags = largeBags;
    }

    public Double getXLargeBags() {
        return xLargeBags;
    }

    public void setXLargeBags(Double xLargeBags) {
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
}