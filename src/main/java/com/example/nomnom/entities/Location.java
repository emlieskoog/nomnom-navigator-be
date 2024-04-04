package com.example.nomnom.entities;
import jakarta.persistence.*;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private double latitude;
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    public Location() {
    }

    public Location(String address, double latitude, double longitude, District district) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.district = district;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

}