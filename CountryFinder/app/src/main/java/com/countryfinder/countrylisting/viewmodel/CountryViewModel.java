package com.countryfinder.countrylisting.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.countryfinder.countrylisting.model.Locations;
import com.countryfinder.countrylisting.repository.CountryRepository;

import java.util.List;

public class CountryViewModel extends AndroidViewModel {

    private CountryRepository mCountryRepository;

    public CountryViewModel(@NonNull Application application) {
        super(application);
        mCountryRepository = new CountryRepository();
    }

    public LiveData<List<Locations>> getLocationList(){
       return mCountryRepository.getCountryListData();
    }

}
