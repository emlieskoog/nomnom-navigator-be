package com.example.nomnom;

import com.example.nomnom.entities.District;
import com.example.nomnom.service.DistrictService;
import com.example.nomnom.controller.DistrictController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;


import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DistrictController.class)
public class DistrictControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DistrictService districtService;

    @Test
    public void testGetAllDistricts() throws Exception {
        District district1 = new District("District1");
        District district2 = new District("District2");
        List<District> districts = Arrays.asList(district1, district2);
        
        Mockito.when(districtService.getAllDistricts()).thenReturn(districts);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/districts")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedResponse = "[{\"id\":null,\"name\":\"District1\"},{\"id\":null,\"name\":\"District2\"}]";
        String actualResponse = result.getResponse().getContentAsString();
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testCreateDistrict() throws Exception {
        District district = new District("ExampleDistrict");
        
        Mockito.when(districtService.saveDistricts(Mockito.any(District.class))).thenReturn(district);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/districts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"ExampleDistrict\"}");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedResponse = "{\"id\":null,\"name\":\"ExampleDistrict\"}";
        String actualResponse = result.getResponse().getContentAsString();
        assertEquals(expectedResponse, actualResponse);
    }
}
