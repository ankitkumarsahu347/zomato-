package com.zomato.controller;

import com.zomato.util.DBConnection;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.*;

@Controller
public class CustomerController {
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        String sql = "SELECT customer_id, name FROM customers WHERE email=? AND password=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email); ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                session.setAttribute("customerId", rs.getInt("customer_id"));
                session.setAttribute("customerName", rs.getString("name"));
                return "redirect:/";
            }
        } catch (Exception e) { e.printStackTrace(); }
        model.addAttribute("message", "Invalid email or password");
        return "login";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String email, @RequestParam String password, Model model) {
        String sql = "INSERT INTO customers(name,email,password) VALUES(?,?,?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name); ps.setString(2, email); ps.setString(3, password); ps.executeUpdate();
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("message", "Registration failed. Email may already exist.");
            return "login";
        }
    }
}