package com.countryfinder.countrylisting.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.countryfinder.R;
import com.countryfinder.Utils;
import com.countryfinder.countrylisting.model.Locations;

import java.util.List;
import java.util.Locale;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    List<Locations> mCountryList;

    List<Locations> locationsSearchList;

    private Context mContext;

    public CountryAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.items_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Utils.glideLoadImage(mContext, locationsSearchList.get(position).getCountryFlagImage(), holder.countryImage);
        holder.countryTitleText.setText(locationsSearchList.get(position).getCountryName());
    }

    @Override
    public int getItemCount() {
        if (locationsSearchList != null) {
            return locationsSearchList.size();
        } else {
            return 0;
        }
    }

    public void setCountryList(List<Locations> countryList) {
        this.mCountryList = countryList;
        this.locationsSearchList=countryList;
        notifyDataSetChanged();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        private ImageView countryImage;

        private TextView countryTitleText;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryImage = itemView.findViewById(R.id.image_country);
            countryTitleText = itemView.findViewById(R.id.text_country_title);
        }
    }

    public void setFilter(String searchQuery) {

        locationsSearchList.clear();
        if (searchQuery.length() == 0) {
            locationsSearchList.addAll(mCountryList);
        } else {
            searchQuery = searchQuery.toLowerCase(Locale.getDefault());
            for (Locations locations : mCountryList) {
                if (locations.getCountryName().toLowerCase().contains(searchQuery)) {
                    locationsSearchList.add(locations);
                }
            }
        }
        notifyDataSetChanged();
    }

}
