package com.countryfinder.server;

import com.countryfinder.countrylisting.model.Locations;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ICountryAPIServices {

    @GET(ServerUrls.ALL_LOCATION)
    Call<List<Locations>> getAllLocations();

}
