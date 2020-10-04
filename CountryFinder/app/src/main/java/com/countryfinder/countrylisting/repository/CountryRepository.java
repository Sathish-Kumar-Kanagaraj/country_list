package com.countryfinder.countrylisting.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.countryfinder.countrylisting.model.Locations;
import com.countryfinder.server.ICountryAPIServices;
import com.countryfinder.server.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryRepository {

    ICountryAPIServices iCountryAPIServices;

    public CountryRepository() {
        iCountryAPIServices = RestClient.getRetrofit().create(ICountryAPIServices.class);
    }

    public LiveData<List<Locations>> getCountryListData() {

        final MutableLiveData<List<Locations>> countryListData = new MutableLiveData<>();
        Call<List<Locations>> locationApiCall = iCountryAPIServices.getAllLocations();

        locationApiCall.enqueue(new Callback<List<Locations>>() {
            @Override
            public void onResponse(Call<List<Locations>> call, Response<List<Locations>> response) {
                countryListData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Locations>> call, Throwable t) {

            }
        });
        return countryListData;
    }

}
