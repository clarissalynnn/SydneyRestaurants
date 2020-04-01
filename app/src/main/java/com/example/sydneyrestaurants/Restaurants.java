package com.example.sydneyrestaurants;
import java.util.ArrayList;
public class Restaurants {
    private String name;
    private String location;
    private String cuisine;
    private double ratings;

    public Restaurants(){

    }

    public Restaurants(String name, String location, String cuisine, double ratings){
        this.name = name;
        this.location = location;
        this.cuisine = cuisine;
        this.ratings = ratings;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(){
        this.location = location;
    }

    public String getCuisine(){
        return cuisine;
    }

    public void setCuisine(){
        this.cuisine = cuisine;
    }

    public double getRatings(){
        return ratings;
    }

    public void setRatings(){
        this.ratings = ratings;
    }

    public static Restaurants getRestaurants(String id){
        for(Restaurants restaurants : getRestaurants()){
            if(restaurants.getName().equals(id)){
                return restaurants;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return name;
    }

//This arrayList stores information about the top 10 restaurants
    public static ArrayList<Restaurants> getRestaurants(){
    ArrayList<Restaurants> restaurants = new ArrayList<>();
    restaurants.add(new Restaurants("Lankan Filling Station", "58 Riley St, Darlinghurst", "Sri Lankan", 5.0));
    restaurants.add(new Restaurants("Hubert", "15 Bligh St, Sydney", "French", 4.9));
    restaurants.add(new Restaurants("Ester", "46-52 Meagher St, Chippendale", "Australian", 4.7));
    restaurants.add(new Restaurants("Bella Brutta", "135 King St, Newtown", "Italian", 4.7));
    restaurants.add(new Restaurants("Saint Peter", "362 Oxford St, Paddington", "Seafood", 4.6));
    restaurants.add(new Restaurants("Sixpenny", "83 Percival Rd, Stanmore", "Modern Australian", 4.6));
    restaurants.add(new Restaurants("Bentley Restaurant", "27 O'Connell St, Sydney", "Modern Australian", 4.5));
    restaurants.add(new Restaurants("Yellow", "57 MacLeay St, Potts Point", "Vegetarian", 4.5));
    restaurants.add(new Restaurants("Quay", "Upper Overseas Passenger, The Rocks", "Australian", 4.4));
    restaurants.add(new Restaurants("Momofuku Seiobo", "Level G/80 Pyrmont St, Pyrmont", "American", 4.2));
    return restaurants;
    }

    // code from RecyclerView in Fragment in Android Studio tutorial by Angga Risky on Youtube (https://www.youtube.com/watch?v=9I2jUY0mwYQ)
    public static int [] pictures = new int[] {
            R.drawable.image_lankanfillingstation,
            R.drawable.image_hubert,
            R.drawable.image_ester,
            R.drawable.image_bellabrutta,
            R.drawable.image_saintpeter,
            R.drawable.image_sixpenny,
            R.drawable.image_bentley,
            R.drawable.image_yellow,
            R.drawable.image_quay,
            R.drawable.image_momofukuseiobo
    };

}
