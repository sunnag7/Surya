
package com.sun.surya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("estateId")
    @Expose
    private Object estateId;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("estimate")
    @Expose
    private Integer estimate;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("area")
    @Expose
    private Integer area;
    @SerializedName("typeText")
    @Expose
    private String typeText;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("municipality")
    @Expose
    private Integer municipality;
    @SerializedName("ingress")
    @Expose
    private String ingress;
    @SerializedName("published")
    @Expose
    private String published;
    @SerializedName("publishedFormatted")
    @Expose
    private String publishedFormatted;
    @SerializedName("score")
    @Expose
    private Score score;

    public Object getEstateId() {
        return estateId;
    }

    public void setEstateId(Object estateId) {
        this.estateId = estateId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEstimate() {
        return estimate;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Integer municipality) {
        this.municipality = municipality;
    }

    public String getIngress() {
        return ingress;
    }

    public void setIngress(String ingress) {
        this.ingress = ingress;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getPublishedFormatted() {
        return publishedFormatted;
    }

    public void setPublishedFormatted(String publishedFormatted) {
        this.publishedFormatted = publishedFormatted;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

}