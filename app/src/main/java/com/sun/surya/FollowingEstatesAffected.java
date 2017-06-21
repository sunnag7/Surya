package com.sun.surya;

/**
 * Created by Sanny on 3/2/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FollowingEstatesAffected {

    @SerializedName("userEstateId")
    @Expose
    private Integer userEstateId;
    @SerializedName("forecastUrl")
    @Expose
    private String forecastUrl;

    public Integer getUserEstateId() {
        return userEstateId;
    }

    public void setUserEstateId(Integer userEstateId) {
        this.userEstateId = userEstateId;
    }

    public String getForecastUrl() {
        return forecastUrl;
    }

    public void setForecastUrl(String forecastUrl) {
        this.forecastUrl = forecastUrl;
    }

}