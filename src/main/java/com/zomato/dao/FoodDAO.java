package com.zomato.dao;

import com.zomato.model.FoodItem;
import com.zomato.util.DBConnection;
import java.sql.*;
import java.util.*;

public class FoodDAO {
    public List<FoodItem> getByRestaurant(int restaurantId) {
        List<FoodItem> list = new ArrayList<>();
        String sql = "SELECT f.*, r.name AS restaurant_name FROM food_items f JOIN restaurants r ON f.restaurant_id=r.restaurant_id WHERE f.restaurant_id=? ORDER BY f.category, f.name";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FoodItem f = new FoodItem();
                f.setFoodId(rs.getInt("food_id")); f.setRestaurantId(rs.getInt("restaurant_id"));
                f.setRestaurantName(rs.getString("restaurant_name")); f.setName(rs.getString("name"));
                f.setDescription(rs.getString("description")); f.setPrice(rs.getDouble("price"));
                f.setCategory(rs.getString("category")); list.add(f);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}