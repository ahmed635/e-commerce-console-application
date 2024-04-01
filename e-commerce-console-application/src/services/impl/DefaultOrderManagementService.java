package services.impl;

import entities.Order;
import services.OrderManagementService;

import java.util.Arrays;

public class DefaultOrderManagementService implements OrderManagementService {
    private static final int DEFAULT_ORDER_CAPACITY = 10;

    private static DefaultOrderManagementService instance;

    private Order[] orders;
    private int lastIndex;

    {
        orders = new Order[DEFAULT_ORDER_CAPACITY];
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
            if (orders.length <= lastIndex) {
                orders = Arrays.copyOf(orders, orders.length << 1);
            }
            orders[lastIndex] = order;
            lastIndex++;
        }
    }

    @Override
    public Order[] getOrdersByUserId(int userId) {
        int amountOfUserOrder = 0;
        for (Order order : orders) {
            if ((order != null) && (order.getCustomerId() == userId))
                amountOfUserOrder++;
        }
        Order[] userOrder = new Order[amountOfUserOrder];
        int index = 0;
        for (Order order : orders) {
            if ((order != null) && (order.getCustomerId() == userId))
                userOrder[index++] = order;
        }
        return userOrder;
    }

    @Override
    public Order[] getOrders() {
        int nonNullOrdersAmount = 0;
        for (Order order : orders) {
            if (order != null)
                nonNullOrdersAmount++;
        }

        Order[] nonNullOrders = new Order[nonNullOrdersAmount];
        int index = 0;
        for (Order order : orders) {
            if (order != null)
                nonNullOrders[index++] = order;
        }
        return nonNullOrders;
    }

    void clearServiceState() {
        lastIndex = 0;
        orders = new Order[DEFAULT_ORDER_CAPACITY];
    }
}
