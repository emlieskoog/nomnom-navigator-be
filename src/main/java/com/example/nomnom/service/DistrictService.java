package com.example.nomnom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nomnom.entities.District;
import com.example.nomnom.repository.DistrictRepository;

import java.util.*;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    public District saveDistricts(District district) {
        return districtRepository.save(district);
    }

    public List<District> getAllDistricts() {
        List<District> districts = districtRepository.findAll();
        if (districts.isEmpty()) {
            throw new RuntimeException("No districts found");
        }
        return districts;
    }
}
