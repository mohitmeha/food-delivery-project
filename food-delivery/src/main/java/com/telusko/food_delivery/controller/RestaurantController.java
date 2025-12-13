package com.telusko.food_delivery.controller;

import com.telusko.food_delivery.model.Restaurant;
import com.telusko.food_delivery.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/restaurants")
@Slf4j
@CrossOrigin // allow requests from frontend
public class RestaurantController {
    private final com.telusko.food_delivery.service.RestaurantService service;
    public RestaurantController(com.telusko.food_delivery.service.RestaurantService service) { this.service = service; }

    @GetMapping("/list")
    public List<com.telusko.food_delivery.model.Restaurant> all() {
        log.info("get list of restaurant");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public com.telusko.food_delivery.model.Restaurant get(@PathVariable String id) { return service.getById(id); }

    @PostMapping
    public com.telusko.food_delivery.model.Restaurant create(@RequestBody com.telusko.food_delivery.model.Restaurant r) { return service.save(r); }
}