
package com.sun.surya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeedData {

    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;
    @SerializedName("estate_estimate")
    @Expose
    private List<EstateEstimate> estateEstimate = null;
    @SerializedName("estate_for_sale")
    @Expose
    private List<EstateForSale> estateForSale = null;
    @SerializedName("estate_sold")
    @Expose
    private List<EstateForSale> estateSold = null;
    @SerializedName("estate_considered_sold")
    @Expose
    private List<EstateForSale> estateConsideredSold= null;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<EstateEstimate> getEstateEstimate() {
        return estateEstimate;
    }

    public void setEstateEstimate(List<EstateEstimate> estateEstimate) {
        this.estateEstimate = estateEstimate;
    }

    public List<EstateForSale> getEstateForSale() {
        return estateForSale;
    }

    public void setEstateForSale(List<EstateForSale> estateForSale) {
        this.estateForSale = estateForSale;
    }

    public List<EstateForSale> getEstateSold() {
        return estateSold;
    }

    public void setEstateSold(List<EstateForSale> estateSold) {
        this.estateSold = estateSold;
    }

    public List<EstateForSale> getEstateConsideredSold() {
        return estateConsideredSold;
    }

    public void setEstateConsideredSold(List<EstateForSale> estateConsideredSold) {
        this.estateConsideredSold = estateConsideredSold;
    }
}
