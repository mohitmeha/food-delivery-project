package com.telusko.food_delivery.service;

import com.telusko.food_delivery.model.Restaurant;
import com.telusko.food_delivery.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository repo;
    public RestaurantService(RestaurantRepository repo) {
        this.repo = repo;
    }

    public List<Restaurant> getAll() {
        return repo.findAll();
    }

    public Restaurant getById(String id) {
        Optional<Restaurant> r = repo.findById(id);
        return r.orElse(null);
    }

    public Restaurant save(Restaurant r) {
        return repo.save(r);
    }
}
