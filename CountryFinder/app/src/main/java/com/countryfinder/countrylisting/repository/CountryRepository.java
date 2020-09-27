package com.countryfinder.countrylisting.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.countryfinder.countrylisting.model.Locations;
import com.countryfinder.server.ICountryAPIServices;
import com.countryfinder.server.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryRepository {

    private Application application;

    private List<Locations> countryList = new ArrayList<>();

    private MutableLiveData<List<Locations>> countryListData = new MutableLiveData<>();

    ICountryAPIServices iCountryAPIServices;

    public CountryRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Locations>> getCountryListData() {

        iCountryAPIServices = RestClient.getRetrofit().create(ICountryAPIServices.class);
        Call<List<Locations>> locationApiCall = iCountryAPIServices.getAllLocations();
        locationApiCall.enqueue(new Callback<List<Locations>>() {
            @Override
            public void onResponse(Call<List<Locations>> call, Response<List<Locations>> response) {
                countryList = response.body();
                countryListData.setValue(countryList);
            }

            @Override
            public void onFailure(Call<List<Locations>> call, Throwable t) {

            }
        });
       return countryListData;
    }

}
