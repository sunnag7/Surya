package com.sun.surya;

/**
 * Created by Sanny on 4/13/2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Header {

    @SerializedName("title")
    @Expose
    private String title = "Property";
    @SerializedName("count")
    @Expose
    private Integer count;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}