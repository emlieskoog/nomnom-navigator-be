package com.example.nomnom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.nomnom.entities.Kitchen;

public interface KitchenRepository extends JpaRepository <Kitchen, Long>{

}
