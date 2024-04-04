package com.example.nomnom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.nomnom.entities.Kitchen;
import com.example.nomnom.service.KitchenService;

import java.util.*;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {
    @Autowired
    private KitchenService kitchenService;

    @PostMapping
    public Kitchen createKitchen(@RequestBody Kitchen kitchen) {
        return kitchenService.saveKitchen(kitchen);
    }

    @GetMapping
    public List<Kitchen> getAllKitchens() {
        return kitchenService.getAllKitchens();
    }
}
