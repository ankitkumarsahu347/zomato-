package com.zomato.model;

public class Restaurant {
    private int restaurantId;
    private String name;
    private String city;
    private String cuisine;
    private double rating;

    public int getRestaurantId() { return restaurantId; }
    public void setRestaurantId(int restaurantId) { this.restaurantId = restaurantId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getCuisine() { return cuisine; }
    public void setCuisine(String cuisine) { this.cuisine = cuisine; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
}