package com.example.nomnom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nomnom.entities.Kitchen;
import com.example.nomnom.repository.KitchenRepository;

import java.util.*;

@Service
public class KitchenService {
    @Autowired
    private KitchenRepository kitchenRepository;

    public Kitchen saveKitchen(Kitchen kitchen) {
        return kitchenRepository.save(kitchen);
    }

    public List<Kitchen> getAllKitchens() {
        List<Kitchen> kitchens = kitchenRepository.findAll();
        if (kitchens.isEmpty()) {
            throw new RuntimeException("No kitchens found");
        }
        return kitchens;
    }
}
