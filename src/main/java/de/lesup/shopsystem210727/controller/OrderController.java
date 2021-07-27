package de.lesup.shopsystem210727.controller;

import de.lesup.shopsystem210727.model.Order;
import de.lesup.shopsystem210727.model.Product;
import de.lesup.shopsystem210727.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class OrderController {
    private final OrderService orderService;
@Autowired

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/products")
    public List<Product> getProductList(){

        return orderService.listAllProducts();
    }
    @PostMapping("/order")
    public Order createNewOrder() {
    return orderService.order(new ArrayList<>());
    }
    @PostMapping("/addorder")
    public Order addProductToOrder(@RequestBody Product product, Order order) {
        orderService.addProductToOrder(product, order);
        return order;
    }

}
