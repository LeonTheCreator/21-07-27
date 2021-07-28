package de.lesup.shopsystem210727.controller;

import de.lesup.shopsystem210727.model.Order;
import de.lesup.shopsystem210727.model.Product;
import de.lesup.shopsystem210727.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
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
    public List<Product> getProductList() {
        return orderService.listAllProducts();
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.listAllOrders();
    }

    @PostMapping("/order")
    public Order createNewOrder() {
        return orderService.order(new ArrayList<>());
    }

    @GetMapping("{orderId}")
    public Order getOrderById(@PathVariable String orderId){
        return orderService.getOrderById(orderId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{orderId}")
    public Order addProductToOrder(@PathVariable String orderId, @RequestBody Product product) {
        Order order = orderService.checkOrder(orderId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        order.getProductList().add(product);
        return order;
    }

    @GetMapping("{name}")
    public Product searchProduct(@PathVariable String name){
        return orderService.getProductByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
