package com.zomato.controller;

import com.zomato.dao.FoodDAO;
import com.zomato.dao.RestaurantDAO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final RestaurantDAO restaurantDAO = new RestaurantDAO();
    private final FoodDAO foodDAO = new FoodDAO();

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("restaurants", restaurantDAO.getAllRestaurants());
        return "index";
    }

    @GetMapping("/restaurant")
    public String restaurant(@RequestParam int id, Model model) {
        model.addAttribute("restaurant", restaurantDAO.findById(id));
        model.addAttribute("foods", foodDAO.getByRestaurant(id));
        return "restaurant";
    }

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @GetMapping("/logout")
    public String logout(HttpSession session) { session.invalidate(); return "redirect:/"; }
}