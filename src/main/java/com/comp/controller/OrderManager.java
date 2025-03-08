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

    public void notifyListenersNewOrder(Order order) {
        System.out.println("\nNotifying CEO about new order...");
        for (OrderListener listeners : orderListeners) {
            listeners.updateOrderPending(order);
        }
    }

    public void notifyListenersDone(Order order) {
        System.out.println("\nNotifying CEO that order is done...");
        for (OrderListener listeners : orderListeners) {
            listeners.updateOrderDone(order);
        }
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

}
