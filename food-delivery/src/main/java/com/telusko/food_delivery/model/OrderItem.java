package com.telusko.food_delivery.model;

import lombok.Data;

@Data
public class OrderItem {
    private String menuItemId;
    private String name;
    private int qty;
    private double price;
}
