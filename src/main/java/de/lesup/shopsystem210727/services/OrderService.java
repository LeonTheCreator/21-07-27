package de.lesup.shopsystem210727.services;

import de.lesup.shopsystem210727.model.Order;
import de.lesup.shopsystem210727.model.Product;
import de.lesup.shopsystem210727.repo.OrderDB;
import de.lesup.shopsystem210727.repo.ProductDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
