
package com.sun.surya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EstateEstimate {

    @SerializedName("topHeading")
    @Expose
    private String topHeading;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("ingress")
    @Expose
    private String ingress;
    @SerializedName("estimatePrice")
    @Expose
    private Double estimatePrice;
    @SerializedName("estimateDelta")
    @Expose
    private Double estimateDelta;
    @SerializedName("estimateChangePercent")
    @Expose
    private Double estimateChangePercent;
    @SerializedName("estimateDate")
    @Expose
    private String estimateDate;
    @SerializedName("estateId")
    @Expose
    private Integer estateId;
    @SerializedName("dateOrder")
    @Expose
    private String dateOrder;
    @SerializedName("latitude")
    @Expose
    private Double estimateLat;
    @SerializedName("longitude")
    @Expose
    private Double estimateLon;
    @SerializedName("dateOrderFormatted")
    @Expose
    private String dateOrderFormatted;
    public Double getEstimateLat() {
        return estimateLat;
    }

    public void setEstimateLat(Double estimateLat) {
        this.estimateLat = estimateLat;
    }

    public Double getEstimateLon() {
        return estimateLon;
    }

    public void setEstimateLon(Double estimateLon) {
        this.estimateLon = estimateLon;
    }

    public String getTopHeading() {
        return topHeading;
    }

    public void setTopHeading(String topHeading) {
        this.topHeading = topHeading;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIngress() {
        return ingress;
    }

    public void setIngress(String ingress) {
        this.ingress = ingress;
    }

    public Double getEstimatePrice() {
        return estimatePrice;
    }

    public void setEstimatePrice(Double estimatePrice) {
        this.estimatePrice = estimatePrice;
    }

    public Double getEstimateDelta() {
        return estimateDelta;
    }

    public void setEstimateDelta(Double estimateDelta) {
        this.estimateDelta = estimateDelta;
    }

    public Double getEstimateChangePercent() {
        return estimateChangePercent;
    }

    public void setEstimateChangePercent(Double estimateChangePercent) {
        this.estimateChangePercent = estimateChangePercent;
    }

    public String getEstimateDate() {
        return estimateDate;
    }

    public void setEstimateDate(String estimateDate) {
        this.estimateDate = estimateDate;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getDateOrderFormatted() {
        return dateOrderFormatted;
    }

    public void setDateOrderFormatted(String dateOrderFormatted) {
        this.dateOrderFormatted = dateOrderFormatted;
    }
}
