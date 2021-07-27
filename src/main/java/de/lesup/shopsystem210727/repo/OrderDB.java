package de.lesup.shopsystem210727.repo;

import de.lesup.shopsystem210727.model.Order;
import de.lesup.shopsystem210727.model.Product;

import java.util.List;
import java.util.UUID;

public class OrderDB {
    private List<Order> orderList;

    public void addOrder(List<Product> productList){
        String id = UUID.randomUUID().toString();
        Order newOrder = new Order(id, productList);
        orderList.add(newOrder);

    }
}
