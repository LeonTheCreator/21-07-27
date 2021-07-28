package de.lesup.shopsystem210727.repo;

import de.lesup.shopsystem210727.model.Order;
import de.lesup.shopsystem210727.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class OrderDB {

    private List<Order> orderList;

    @Autowired
    public OrderDB(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Order addOrder(List<Product> productList){
        String id = UUID.randomUUID().toString();
        Order newOrder = new Order(id, productList);
        orderList.add(newOrder);
        return newOrder;
    }
public Optional<Order> getOrderById(String orderId){
    for (Order order: orderList) {
        if (order.getOrderId().equals(orderId)){
            return Optional.of(order);
        }
    }
    return Optional.empty();
}

    public List<Order> listOrders() {
        return orderList;
    }
}
