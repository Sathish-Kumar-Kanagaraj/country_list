package com.countryfinder.countrylisting.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.countryfinder.GridSpaceItemDecoration;
import com.countryfinder.R;
import com.countryfinder.countrylisting.model.Locations;
import com.countryfinder.countrylisting.viewmodel.CountryViewModel;
import com.countryfinder.server.ICountryAPIServices;

import java.util.List;

public class CountryActivity extends AppCompatActivity {

    RecyclerView countryRecycler;

    ICountryAPIServices iCountryAPIServices;

    private CountryViewModel mCountryViewModel;

    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        countryRecycler = findViewById(R.id.recycler_country);
        countryAdapter = new CountryAdapter(this);

        GridLayoutManager countryGridLayout = new GridLayoutManager(this, 2);
        countryRecycler.addItemDecoration(new GridSpaceItemDecoration
                (2, 10, true, 0));
        countryRecycler.setLayoutManager(countryGridLayout);
        countryRecycler.setAdapter(countryAdapter);

        mCountryViewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
        mCountryViewModel.getCountryList().observe(this, new Observer<List<Locations>>() {
            @Override
            public void onChanged(List<Locations> locations) {
                countryAdapter.setCountryList((List<Locations>) locations);
            }
        });

    }
}