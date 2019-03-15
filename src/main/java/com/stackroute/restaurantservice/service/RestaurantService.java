package com.stackroute.restaurantservice.service;

import com.stackroute.restaurantservice.domain.Restaurant;
import com.stackroute.restaurantservice.exception.RestaurantAlreadyException;
import com.stackroute.restaurantservice.exception.RestaurantNotFound;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    public Restaurant savedata(Restaurant restaurant) throws RestaurantAlreadyException;
    public List<Restaurant> getAllUsers();
    public Optional<Restaurant> getById(String id);
    public Restaurant updataData(Restaurant restaurant) throws RestaurantNotFound;
    public void delete(String id);

}
