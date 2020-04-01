package com.example.sydneyrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//Most of the code were adpated from the CryptoBag tutorial and sample code by Julian Prester as seen on https://github.com/INFS-3634/CryptoBag
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(savedInstanceState == null){
            Bundle arguments = new Bundle();
            arguments.putString(DetailFragment.ARG_ITEM_ID, getIntent().getStringExtra(DetailFragment.ARG_ITEM_ID));
            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.detailContainer, fragment).commit();
        }
    }
}
