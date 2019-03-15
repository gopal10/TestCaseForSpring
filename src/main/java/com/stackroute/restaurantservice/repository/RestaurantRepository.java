package com.stackroute.restaurantservice.repository;

import com.stackroute.restaurantservice.domain.Restaurant;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {


}
