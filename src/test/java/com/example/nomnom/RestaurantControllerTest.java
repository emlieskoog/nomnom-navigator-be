package com.example.nomnom;

import com.example.nomnom.controller.RestaurantController;
import com.example.nomnom.entities.District;
import com.example.nomnom.entities.Kitchen;
import com.example.nomnom.entities.Location;
import com.example.nomnom.entities.Restaurant;
import com.example.nomnom.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    public void testCreateRestaurant() throws Exception {
        District district = new District("DistrictName");
        Location location = new Location("LocationName", 123.456, 789.123, district);
        Kitchen kitchen = new Kitchen("KitchenName");
        Restaurant restaurant = new Restaurant("RestaurantName", location, kitchen, "ImageURL");

        when(restaurantService.saveRestaurant(restaurant)).thenReturn(restaurant);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"RestaurantName\", \"location\": {\"address\":\"LocationName\", \"latitude\":123.456, \"longitude\":789.123, \"district\": {\"name\":\"DistrictName\"}}, \"kitchen\": {\"name\":\"KitchenName\"}, \"image\":\"ImageURL\"}");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testGetAllRestaurants() throws Exception {
        District district1 = new District("District1");
        District district2 = new District("District2");
        Location location1 = new Location("Location1", 123.456, 789.123, district1);
        Location location2 = new Location("Location2", 456.789, 321.654, district2);
        Kitchen kitchen1 = new Kitchen("Kitchen1");
        Kitchen kitchen2 = new Kitchen("Kitchen2");

        Restaurant restaurant1 = new Restaurant("Restaurant1", location1, kitchen1, "ImageURL1");
        Restaurant restaurant2 = new Restaurant("Restaurant2", location2, kitchen2, "ImageURL2");
        List<Restaurant> restaurants = Arrays.asList(restaurant1, restaurant2);

        when(restaurantService.getAllRestaurants()).thenReturn(restaurants);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/restaurants")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }
}
