package com.example.nomnom;

import com.example.nomnom.entities.Kitchen;
import com.example.nomnom.service.KitchenService;
import com.example.nomnom.controller.KitchenController;
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
@WebMvcTest(KitchenController.class)
public class KitchenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KitchenService kitchenService;

    @Test
    public void testGetAllKitchens() throws Exception {
        Kitchen kitchen1 = new Kitchen("Kitchen1");
        Kitchen kitchen2 = new Kitchen("Kitchen2");
        List<Kitchen> kitchens = Arrays.asList(kitchen1, kitchen2);
        
        Mockito.when(kitchenService.getAllKitchens()).thenReturn(kitchens);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/kitchens")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedResponse = "[{\"id\":null,\"name\":\"Kitchen1\"},{\"id\":null,\"name\":\"Kitchen2\"}]";
        String actualResponse = result.getResponse().getContentAsString();
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testCreateKitchen() throws Exception {
        Kitchen kitchen = new Kitchen("ExampleKitchen");
        
        Mockito.when(kitchenService.saveKitchen(Mockito.any(Kitchen.class))).thenReturn(kitchen);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/kitchens")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"ExampleKitchen\"}");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedResponse = "{\"id\":null,\"name\":\"ExampleKitchen\"}";
        String actualResponse = result.getResponse().getContentAsString();
        assertEquals(expectedResponse, actualResponse);
    }
}
