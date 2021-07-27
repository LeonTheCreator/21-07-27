package de.lesup.shopsystem210727.controller;

import de.lesup.shopsystem210727.model.Product;
import de.lesup.shopsystem210727.repo.OrderDB;
import de.lesup.shopsystem210727.repo.ProductDB;
import de.lesup.shopsystem210727.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderController {
    private OrderService orderService;
    @GetMapping("/products")
    public List<Product> getProductMapping(){

        return orderService.listAllProducts();
    }
}
