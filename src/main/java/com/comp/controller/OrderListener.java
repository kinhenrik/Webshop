package com.comp.controller;

import com.comp.view.Order;

public interface OrderListener {

    void updateOrderPending(Order order);
    void updateOrderDone(Order order);

}
