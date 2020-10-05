package com.countryfinder.countrylisting.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.countryfinder.GridSpaceItemDecoration;
import com.countryfinder.R;
import com.countryfinder.countrylisting.model.Locations;
import com.countryfinder.countrylisting.viewmodel.CountryViewModel;

import java.util.List;

public class CountryActivity extends AppCompatActivity {

    RecyclerView countryRecycler;

    SearchView searchView;

    private CountryViewModel mCountryViewModel;

    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        countryRecycler = findViewById(R.id.recycler_country);
        searchView = findViewById(R.id.search_view);
        countryAdapter = new CountryAdapter(this);

        GridLayoutManager countryGridLayout = new GridLayoutManager(this, 2);
        countryRecycler.addItemDecoration(new GridSpaceItemDecoration
                (2, 10, true, 0));
        countryRecycler.setLayoutManager(countryGridLayout);
        countryRecycler.setAdapter(countryAdapter);

        mCountryViewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
        mCountryViewModel.getLocationList().observe(this, new Observer<List<Locations>>() {
            @Override
            public void onChanged(List<Locations> locations) {
                countryAdapter.setCountryList((List<Locations>) locations);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
              //  Toast.makeText(CountryActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                countryAdapter.setFilter(newText);
                Toast.makeText(CountryActivity.this, "new text:" + newText, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}