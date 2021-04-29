package com.example.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PlacesAdapter.OnRowClickListener {
    RecyclerView destinationsRecyclerView;
    RecyclerView placesRecyclerView;
    DestinationsAdapter destinationsAdapter;
    PlacesAdapter placesAdapter;
    List<Destinations> destinationsList = new ArrayList<>();
    List<Places> placesList = new ArrayList<>();

    Integer[] destinationsImageList ={R.drawable.auditorium, R.drawable.gate, R.drawable.playground, R.drawable.subway_station};
    Integer[] placesImageList = {R.drawable.auditorium, R.drawable.gate, R.drawable.playground, R.drawable.subway_station};
    String[] nameList = {"auditorium","gate","playground","subway station"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        destinationsRecyclerView = findViewById(R.id.destinationsRecyclerView);
        placesRecyclerView = findViewById(R.id.placesRecyclerView);

        destinationsAdapter =new DestinationsAdapter(destinationsList,this);
        placesAdapter = new PlacesAdapter(placesList, this,this);

        destinationsRecyclerView.setAdapter(destinationsAdapter);
        placesRecyclerView.setAdapter(placesAdapter);

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        destinationsRecyclerView.setLayoutManager(layoutManager1);
        placesRecyclerView.setLayoutManager(layoutManager2);

        for(int i=0; i<destinationsImageList.length; i++)
        {
            Destinations destinations =new Destinations(i,destinationsImageList[i]);
            destinationsList.add(destinations);
        }

        for(int i=0; i< nameList.length;i++)
        {
            Places places = new Places(i,placesImageList[i],nameList[i]);
            placesList.add(places);
        }
    }

    @Override
    public void onItemClick(int position){
        Fragment fragment;
        switch (position)
        {
            case 0:
                fragment = new auditoriumFragment();
                break;
            case 1:
                fragment = new gateFragment();
                break;
            case 2:
                fragment = new playgroundFragment();
                break;
            case 3:
                fragment = new SubwayStation1Fragment();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment).commit();

    }
}