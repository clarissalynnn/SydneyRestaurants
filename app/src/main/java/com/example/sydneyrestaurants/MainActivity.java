package com.example.sydneyrestaurants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
//Most of the code were adpated from the CryptoBag tutorial and sample code by Julian Prester as seen on https://github.com/INFS-3634/CryptoBag
public class MainActivity extends AppCompatActivity {
private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.detailContainer) != null){
            mTwoPane = true;
        }

        RecyclerView mRecyclerView = findViewById(R.id.revyclerViewList);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter mAdapter = new RestaurantAdapter(this, Restaurants.getRestaurants(), mTwoPane);
        mRecyclerView.setAdapter(mAdapter);

        }

}
