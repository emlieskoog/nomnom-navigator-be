package com.example.nomnom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.nomnom.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository <Restaurant, Long>{

}
