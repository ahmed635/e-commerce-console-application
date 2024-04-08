package services.impl;

import entities.Order;
import services.OrderManagementService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultOrderManagementService implements OrderManagementService {
    private static DefaultOrderManagementService instance;

    private List<Order> orders;
 ;

    {
        orders = new ArrayList<>();
    }

    public static OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public void addOrder(Order order) {
        if (order != null) {
            this.orders.add(order);
        }
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> userOrder = new ArrayList<>();
        for (Order order : orders) {
            if ((order != null) && (order.getCustomerId() == userId))
                userOrder.add(order);
        }
        return userOrder;
    }

    @Override
    public List<Order> getOrders() {
        return this.orders;
    }

    void clearServiceState() {
        orders = new ArrayList<>();
    }
}
