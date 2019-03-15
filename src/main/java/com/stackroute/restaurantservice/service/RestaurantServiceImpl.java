package com.stackroute.restaurantservice.service;

import com.stackroute.restaurantservice.domain.Restaurant;
import com.stackroute.restaurantservice.repository.RestaurantRepository;
import com.stackroute.restaurantservice.exception.RestaurantAlreadyException;
import com.stackroute.restaurantservice.exception.RestaurantNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurant_repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurant_repository) {
        this.restaurant_repository = restaurant_repository;
    }

    public RestaurantServiceImpl() {
    }

    /*
    This method will save restaurant data into the mysql database
     */

    @Override
    public Restaurant savedata(Restaurant restaurant) throws RestaurantAlreadyException  {
        Restaurant restaurant1;
        if (restaurant_repository.existsById(restaurant.getRestaurantId())) {
            throw new RestaurantAlreadyException("Restaurant Already present");
        }
        else{
             restaurant1 = (Restaurant) restaurant_repository.save(restaurant);
            if(restaurant1==null)
                throw new RestaurantAlreadyException("already");
        }
//        Restaurant restaurant1 = (Restaurant) restaurant_repository.save(restaurant);
        return restaurant1;

    }

    /*
    This method will upadte restaurant data into the mysql database
     */
    @Override
    public Restaurant updataData(Restaurant restaurant) throws RestaurantNotFound {
        if (!restaurant_repository.existsById(restaurant.getRestaurantId())) {
            throw new RestaurantNotFound("Restaurant Not Found");
        }
        Restaurant restaurant1 = (Restaurant) restaurant_repository.save(restaurant);
        return restaurant1;
    }

    /*
    This method will retrive all  restaurant data
     */
    @Override
    public List<Restaurant> getAllUsers() {
        return (List<Restaurant>) restaurant_repository.findAll();
    }

    /*
     This method will retrive all  restaurant data by id
     */
    @Override
    public Optional<Restaurant> getById(String id) {
        Optional<Restaurant> getUser = restaurant_repository.findById(id);
        return getUser;
    }

    /*
   This method will delete restaurant data by id
    */
    @Override
    public void delete(String id) {
        restaurant_repository.deleteById(id);
    }


}
