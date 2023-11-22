package com.teamlunch.lunchpicker.controller;

import com.teamlunch.lunchpicker.model.Restaurant;
import com.teamlunch.lunchpicker.repository.RestaurantRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/choices")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping
    public Restaurant addRestaurant(@Valid @RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/random")
    public Restaurant getRandomRestaurant() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.get(new Random().nextInt(restaurants.size()));
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurantDetails) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(); // Add exception handling
        restaurant.setName(restaurantDetails.getName());
        restaurant.setGoogleMapsUrl(restaurantDetails.getGoogleMapsUrl());
        restaurant.setCreatorName(restaurantDetails.getCreatorName());
        restaurant.setCaption(restaurantDetails.getCaption());
        return restaurantRepository.save(restaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantRepository.deleteById(id);
    }
}
