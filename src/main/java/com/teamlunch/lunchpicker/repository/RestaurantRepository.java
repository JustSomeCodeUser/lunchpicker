package com.teamlunch.lunchpicker.repository;

import com.teamlunch.lunchpicker.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}