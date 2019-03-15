package com.stackroute.restaurantservice.service;

import com.stackroute.restaurantservice.domain.Restaurant;
import com.stackroute.restaurantservice.exception.RestaurantAlreadyException;
import com.stackroute.restaurantservice.repository.RestaurantRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class RestaurantServiceImplTest {


    private Restaurant restaurant;
    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantServiceImpl restaurantService;
    List<Restaurant> list = null;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        restaurant = new Restaurant();
        restaurant.setRestaurantId("101");
        restaurant.setRestaurantName("corner");
        restaurant.setRestaurantLocation("raigad");
        restaurant.setRestaurantImage("image");
        list = new ArrayList<>();
        list.add(restaurant);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void savedatatest() throws RestaurantAlreadyException {
        when(restaurantRepository.save((Restaurant) any())).thenReturn(restaurant);
        Restaurant savedUser = restaurantService.savedata(restaurant);
        Assert.assertEquals(restaurant, savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(restaurantRepository, times(1)).save(restaurant);
    }

    @Test(expected = RestaurantAlreadyException.class)
    public void saveUserException() throws RestaurantAlreadyException {
        when(restaurantRepository.save((Restaurant) any())).thenReturn(null);
        Restaurant savedUser = restaurantService.savedata(restaurant);
        System.out.println("savedUser" + savedUser);
        Assert.assertEquals(restaurant, savedUser);
    }
       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


      @Test
        public void getAllUser(){

        restaurantRepository.save(restaurant);
        //stubbing the mock to return specific data
        when(restaurantRepository.findAll()).thenReturn(list);
        List<Restaurant> userlist = restaurantService.getAllUsers();
        Assert.assertEquals(list,userlist);
    }

}


