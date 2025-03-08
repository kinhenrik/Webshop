package com.comp.controller;

import com.comp.view.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private static OrderManager instance;

    private OrderManager() {}

    private List<OrderListener> orderListeners = new ArrayList<>();

    public void subscribe(OrderListener listener) {
        orderListeners.add(listener);
    }

    public void unsubscribe(OrderListener listener) {
        orderListeners.remove(listener);
    }

    public void notifyListeners(Order order) {
        System.out.println("\nNotifying CEO about new order...");
        for (OrderListener listeners : orderListeners) {
            listeners.update(order);
        }
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

}
