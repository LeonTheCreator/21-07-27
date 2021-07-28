package de.lesup.shopsystem210727.services;

import de.lesup.shopsystem210727.model.Order;
import de.lesup.shopsystem210727.model.Product;
import de.lesup.shopsystem210727.repo.OrderDB;
import de.lesup.shopsystem210727.repo.ProductDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final ProductDB productDB;
    private final OrderDB orderDB;

    @Autowired
    public OrderService(ProductDB productDB, OrderDB orderDB) {
        this.productDB = productDB;
        this.orderDB = orderDB;
    }

    public Order order(List<Product> orderedProducts){
        return orderDB.addOrder(orderedProducts);
    }

    public List<Product> listAllProducts() {
        return productDB.getListOfProducts();
    }

    public Optional<Order> checkOrder(String orderId) {
        return orderDB.getOrderById(orderId);
    }

    public Optional<Order> getOrderById(String id){
        for (Order order: orderDB.listOrders()) {
            if (order.getOrderId().equals(id)){
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    public List<Order> listAllOrders() {
        return orderDB.listOrders();
    }

    public Optional<Product> getProductByName(String name) {
        return productDB.getProductByName(name);
    }
}
