package de.lesup.shopsystem210727.repo;

import de.lesup.shopsystem210727.model.Order;
import de.lesup.shopsystem210727.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
@Repository
public class OrderDB {
    private List<Order> orderList;

    public Order addOrder(List<Product> productList){
        String id = UUID.randomUUID().toString();
        Order newOrder = new Order(id, productList);
        orderList.add(newOrder);
        return newOrder;

    }
}
