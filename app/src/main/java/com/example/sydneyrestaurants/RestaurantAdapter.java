package com.example.sydneyrestaurants;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;

// Most of the code for the Adapter class were taken from the CryptoBag tutorial and sample code by Julian Prester as seen on https://github.com/INFS-3634/CryptoBag

//This class sets the app to display either recyclerView from detailActivity or use the fragment depending on the size of the screen
public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private MainActivity mParentActivity;
    private ArrayList<Restaurants> mRestaurants;
    private boolean mTwoPane;
    private View.OnClickListener mOnClickListener = new View.OnClickListener()

    {
        @Override
        public void onClick(View v) {
            Restaurants restaurants = (Restaurants) v.getTag();
            if (mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(DetailFragment.ARG_ITEM_ID, restaurants.getName());
                DetailFragment fragment = new DetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer, fragment).commit();
            } else {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailFragment.ARG_ITEM_ID, restaurants.getName());
                context.startActivity(intent);
            }
        }

    };

    // This displays the list of restaurants in the RecylerView by calling the attributes from the ArrayList from the Restaurants class
    public RestaurantAdapter(MainActivity parent, ArrayList<Restaurants> restaurants, boolean twoPane){
    mParentActivity = parent;
    mRestaurants = restaurants;
    mTwoPane = twoPane;
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
    public TextView name, ratings;
    public ImageView mImages;
    public RestaurantViewHolder(View v){
        super(v);
        name = v.findViewById(R.id.restaurantName);
        ratings = v.findViewById(R.id.restaurantRatings);
        mImages = v.findViewById(R.id.images);
        if(name.equals("Lankan Filling Station")){
            mImages.setImageResource(R.drawable.image_lankanfillingstation); //image source: goodfood.com.au
        } else if (name.equals("Hubert")){
            mImages.setImageResource(R.drawable.image_hubert); //image source: goodfood.com.au
        } else if (name.equals("Bentley Restaurant")){
            mImages.setImageResource(R.drawable.image_bentley); //image source: goodfood.com.au
        } else if (name.equals("Quay")){
            mImages.setImageResource(R.drawable.image_quay); //image source: timeout.com
        } else if (name.equals("Yellow")){
            mImages.setImageResource(R.drawable.image_yellow); //image source: timeout.com
        } else if (name.equals("Bella Brutta")){
            mImages.setImageResource(R.drawable.image_bellabrutta); //image source: goodfood.com.au
        } else if (name.equals("Momofuku Seiobo")){
            mImages.setImageResource(R.drawable.image_momofukuseiobo); //image source: broadsheet.com.au
        } else if (name.equals("Sixpenny")){
            mImages.setImageResource(R.drawable.image_sixpenny); //image source: timeout.com
        } else if (name.equals("Saint Peter")){
            mImages.setImageResource(R.drawable.image_saintpeter); //image source: timeout.com
        }else{
            mImages.setImageResource(R.drawable.image_ester); //image source: tripadvisor.com.au
        }
    }
    }

    @Override
    public RestaurantAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurantlist_item, parent, false);
        return new RestaurantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position){
        Restaurants restaurants = mRestaurants.get(position);
        holder.name.setText(restaurants.getName());
        holder.ratings.setText(NumberFormat.getInstance().format(restaurants.getRatings()));
        holder.itemView.setTag(restaurants);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount(){
        return mRestaurants.size();
    }

}