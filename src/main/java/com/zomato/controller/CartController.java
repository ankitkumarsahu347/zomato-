package com.zomato.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class CartController {
    @PostMapping("/cart/add")
    public String add(@RequestParam int foodId, @RequestParam int restaurantId, @RequestParam String name, @RequestParam double price, HttpSession session) {
        List<Map<String,Object>> cart = getCart(session);
        Map<String,Object> item = cart.stream().filter(x -> (int)x.get("foodId") == foodId).findFirst().orElse(null);
        if (item == null) { Map<String,Object> x = new HashMap<>(); x.put("foodId",foodId); x.put("restaurantId",restaurantId); x.put("name",name); x.put("price",price); x.put("quantity",1); cart.add(x); }
        else item.put("quantity", (int)item.get("quantity") + 1);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cart(HttpSession session, Model model) {
        List<Map<String,Object>> cart = getCart(session); double total=0;
        for (Map<String,Object> x: cart) total += (double)x.get("price") * (int)x.get("quantity");
        model.addAttribute("cart",cart); model.addAttribute("total",total); return "cart";
    }

    @PostMapping("/cart/clear")
    public String clear(HttpSession session) { session.removeAttribute("cart"); return "redirect:/cart"; }

    @SuppressWarnings("unchecked")
    private List<Map<String,Object>> getCart(HttpSession session) {
        List<Map<String,Object>> cart=(List<Map<String,Object>>)session.getAttribute("cart");
        if(cart==null){cart=new ArrayList<>();session.setAttribute("cart",cart);} return cart;
    }
}