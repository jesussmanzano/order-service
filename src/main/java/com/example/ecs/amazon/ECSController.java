package com.example.ecs.amazon;


import com.example.ecs.amazon.entity.Order;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/ecs/")
public class ECSController {
    private final List<Order> ordersList = new ArrayList<>(Arrays.asList(
            new Order(1L, "Order 1", 23.0),
            new Order(2L, "Order 2", 2.0),
            new Order(3L, "Order 3", 3.0),
            new Order(5L, "Order 5", 6.0)
    ));
    @GetMapping("greeting/{name}")
    public String greeting(@PathVariable String name){
        return "Hello " + name + ", welcome to the jungle";
    }

    @GetMapping("orders")
    public List<Order> getOrdersList() {
        return ordersList;
    }


    @GetMapping("save")
    public Order saveOrder(@RequestBody Order order) {
        ordersList.add(order);
        return order;
    }
}
