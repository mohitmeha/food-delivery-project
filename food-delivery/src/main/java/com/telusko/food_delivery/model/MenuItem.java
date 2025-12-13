package com.telusko.food_delivery.model;

import lombok.Data;

@Data
public class MenuItem {
    private String id;        // <-- IMPORTANT FIELD
    private String name;
    private String description;
    private double price;
}
