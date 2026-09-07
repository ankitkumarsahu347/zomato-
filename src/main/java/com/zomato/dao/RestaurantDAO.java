package com.zomato.dao;

import com.zomato.model.Restaurant;
import com.zomato.util.DBConnection;
import java.sql.*;
import java.util.*;

public class RestaurantDAO {
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> list = new ArrayList<>();
        String sql = "SELECT * FROM restaurants ORDER BY rating DESC";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Restaurant r = new Restaurant();
                r.setRestaurantId(rs.getInt("restaurant_id"));
                r.setName(rs.getString("name"));
                r.setCity(rs.getString("city"));
                r.setCuisine(rs.getString("cuisine"));
                r.setRating(rs.getDouble("rating"));
                list.add(r);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public Restaurant findById(int id) {
        String sql = "SELECT * FROM restaurants WHERE restaurant_id=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Restaurant r = new Restaurant();
                r.setRestaurantId(rs.getInt("restaurant_id"));
                r.setName(rs.getString("name"));
                r.setCity(rs.getString("city"));
                r.setCuisine(rs.getString("cuisine"));
                r.setRating(rs.getDouble("rating"));
                return r;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}