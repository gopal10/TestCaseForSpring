package com.stackroute.restaurantservice.repository;

import com.stackroute.restaurantservice.domain.Restaurant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataMongoTest
public class RestaurantRepositoryTest {

    @Autowired
    private RestaurantRepository restaurantRepository;
    private Restaurant restaurant;

    @Before
    public void setUp()
    {
        restaurant= new Restaurant();
        restaurant.setRestaurantId("101");
        restaurant.setRestaurantName("corner");
        restaurant.setRestaurantLocation("raigad");
        restaurant.setRestaurantImage("image");

    }

    @After
    public void tearDown(){

        restaurantRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        restaurantRepository.save(restaurant);
        Restaurant fetchUser = restaurantRepository.findById(restaurant.getRestaurantId()).get();
        Assert.assertEquals("101",fetchUser.getRestaurantId());

    }

      @Test
    public void testSaveUserFailure(){
        Restaurant testUser = new Restaurant("201","corner2","raigad","img url");
        restaurantRepository.save(restaurant);
        Restaurant fetchUser = restaurantRepository.findById(restaurant.getRestaurantId()).get();
        Assert.assertNotSame(testUser,restaurant);
    }

    @Test
    public void testGetAllUser(){
        Restaurant restaurant1 = new Restaurant("102","marriot","beed","img");
        Restaurant restaurant2 = new Restaurant("103","xyz","parli","img");
        restaurantRepository.save(restaurant1);
        restaurantRepository.save(restaurant2);

        List<Restaurant> list = restaurantRepository.findAll();
        Assert.assertEquals("marriot",list.get(0).getRestaurantName());




    }


}
