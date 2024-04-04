package com.example.nomnom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.nomnom.entities.District;
import com.example.nomnom.service.DistrictService;

import java.util.*;

@RestController
@RequestMapping("/districts")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @PostMapping
    public District createDistrict(@RequestBody District district) {
        return districtService.saveDistricts(district);
    }

    @GetMapping
    public List<District> getAllDistricts() {
        return districtService.getAllDistricts();
    }
}
