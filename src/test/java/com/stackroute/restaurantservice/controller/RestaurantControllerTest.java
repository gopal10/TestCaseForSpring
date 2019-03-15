package com.stackroute.restaurantservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.restaurantservice.domain.Restaurant;
import com.stackroute.restaurantservice.exception.RestaurantAlreadyException;
import com.stackroute.restaurantservice.service.RestaurantService;
import com.stackroute.restaurantservice.service.RestaurantServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class RestaurantControllerTest {


    @Autowired
    private MockMvc mockMvc;
    private Restaurant restaurant;
    @MockBean
    private RestaurantServiceImpl restaurantService;
    @InjectMocks
    private RestaurantController restaurantController;

    private List<Restaurant> list =null;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
        restaurant = new Restaurant();
        restaurant.setRestaurantId("26");
        restaurant.setRestaurantName("Jonny");
        restaurant.setRestaurantLocation("101");

        list = new ArrayList();
        list.add(restaurant);
    }

    @Test
    public void saveUser() throws Exception {
        when(restaurantService.savedata(any())).thenReturn(restaurant);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/restaurant")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(restaurant)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }
   // @Test
//    public void saveUserFailure() throws Exception {
//        when(restaurantService.savedata(any())).thenThrow(RestaurantAlreadyException.class);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/restaurant")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(restaurant)))
//                .andExpect(MockMvcResultMatchers.status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
    @Test
    public void getAllUser() throws Exception {
        when(restaurantService.getAllUsers()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/restaurants")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(restaurant)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }


    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }





}