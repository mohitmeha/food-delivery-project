package com.telusko.food_delivery;

import com.telusko.food_delivery.model.MenuItem;
import com.telusko.food_delivery.model.Restaurant;
import com.telusko.food_delivery.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {

    private final RestaurantRepository repo;

    public DataLoader(RestaurantRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {

        // Avoid duplicate insert
        if (repo.count() == 0) {

            MenuItem m1 = new MenuItem();
            m1.setId(UUID.randomUUID().toString());
            m1.setName("Paneer Butter Masala");
            m1.setPrice(200);
            m1.setDescription("Delicious paneer");

            MenuItem m2 = new MenuItem();
            m2.setId(UUID.randomUUID().toString());
            m2.setName("Veg Biryani");
            m2.setPrice(150);
            m2.setDescription("Flavourful biryani");

            Restaurant r = new Restaurant();
            r.setName("Tasty Veg");
            r.setAddress("MG Road, Jaipur");
            r.setMenu(Arrays.asList(m1, m2));

            repo.save(r);

            System.out.println("✔ Sample Restaurant Data Loaded Successfully!");
        }
    }
}
