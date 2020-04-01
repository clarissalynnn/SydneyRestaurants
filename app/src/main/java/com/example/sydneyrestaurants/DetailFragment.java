package com.example.sydneyrestaurants;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.NumberFormat;
import java.util.zip.Inflater;

//Most of the code were adpated from the CryptoBag tutorial and sample code by Julian Prester as seen on https://github.com/INFS-3634/CryptoBag
public class DetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    public Restaurants mRestaurants;
    public ImageView imageView;
    //String name = mRestaurants.getName();

    public DetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mRestaurants = Restaurants.getRestaurants(getArguments().getString(ARG_ITEM_ID));
        }
    }

    //This sets the fragment and adds the information of the restaurants into the TextView and ImageView fields
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        if (mRestaurants != null) {
                ((TextView) rootView.findViewById(R.id.restaurantName)).setText(mRestaurants.getName());
                ((TextView) rootView.findViewById(R.id.cuisineField)).setText(mRestaurants.getCuisine());
                ((TextView) rootView.findViewById(R.id.locationField)).setText(mRestaurants.getLocation());
                ((TextView) rootView.findViewById(R.id.ratingsField)).setText(String.valueOf(mRestaurants.getRatings()));
                ((ImageView) rootView.findViewById(R.id.search)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchRestaurants(mRestaurants.getName());
                    }
                });
                //Inserts images of the restaurants based on the images saved under Drawable
                ImageView mImages = (ImageView) rootView.findViewById(R.id.images);
                if(mRestaurants.getName().contains("Bella")){
                    mImages.setImageResource(R.drawable.image_bellabrutta); //image source: goodfood.com.au
                } else if (mRestaurants.getName().contains("Hubert")){
                    mImages.setImageResource(R.drawable.image_hubert); //image source: goodfood.com.au
                } else if (mRestaurants.getName().contains("Bentley")){
                    mImages.setImageResource(R.drawable.image_bentley); //image source: goodfood.com.au
                } else if (mRestaurants.getName().contains("Quay")){
                    mImages.setImageResource(R.drawable.image_quay); //image source: timeout.com
                } else if (mRestaurants.getName().contains("Yellow")){
                    mImages.setImageResource(R.drawable.image_yellow); //image source: timeout.com
                } else if (mRestaurants.getName().contains("Lankan")){
                    mImages.setImageResource(R.drawable.image_lankanfillingstation); //image source: goodfood.com.au
                } else if (mRestaurants.getName().contains("Momofuku")){
                    mImages.setImageResource(R.drawable.image_momofukuseiobo); //image source: broadsheet.com.au
                } else if (mRestaurants.getName().contains("Sixpenny")){
                    mImages.setImageResource(R.drawable.image_sixpenny); //image source: timeout.com
                } else if (mRestaurants.getName().contains("Saint")){
                    mImages.setImageResource(R.drawable.image_saintpeter); //image source: timeout.com
                }else {
                    mImages.setImageResource(R.drawable.image_ester); //image source: tripadvisor.com.au
                }
            }
            return rootView;
        }



        private void searchRestaurants (String name){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
            startActivity(intent);
        }
    }


