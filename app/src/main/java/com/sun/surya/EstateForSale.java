
package com.sun.surya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EstateForSale {

    @SerializedName("topHeading")
    @Expose
    private String topHeading;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("dateOrder")
    @Expose
    private String dateOrder;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getTopHeading() {
        return topHeading;
    }

    public void setTopHeading(String topHeading) {
        this.topHeading = topHeading;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
