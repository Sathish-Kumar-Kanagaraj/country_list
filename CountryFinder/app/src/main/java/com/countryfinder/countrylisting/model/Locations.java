package com.countryfinder.countrylisting.model;

import com.google.gson.annotations.SerializedName;

public class Locations {

    @SerializedName("name")
    private String countryName;

    @SerializedName("flag")
    private String countryFlagImage;

    public String getCountryName() {
        return countryName;
    }

    public String getCountryFlagImage() {
        return countryFlagImage;
    }
}
