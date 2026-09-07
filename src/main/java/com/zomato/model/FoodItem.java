package com.zomato.model;

public class FoodItem {
    private int foodId;
    private int restaurantId;
    private String restaurantName;
    private String name;
    private String description;
    private double price;
    private String category;

    public int getFoodId() { return foodId; }
    public void setFoodId(int foodId) { this.foodId = foodId; }
    public int getRestaurantId() { return restaurantId; }
    public void setRestaurantId(int restaurantId) { this.restaurantId = restaurantId; }
    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}