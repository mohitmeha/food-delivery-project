package com.telusko.food_delivery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Document(collection = "orders")
@Data
public class Order {
    @Id
    private String id;
    private String customerName;
    private String customerPhone;
    private String restaurantId;
    private List<OrderItem> items;
    private double total;
    private String status; // e.g., RECEIVED, PREPARING, ON_THE_WAY, DELIVERED
}
