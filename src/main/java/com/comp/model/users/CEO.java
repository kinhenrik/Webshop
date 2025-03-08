package com.comp.model.users;

import com.comp.controller.OrderListener;
import com.comp.view.Order;

public class CEO implements OrderListener {

    @Override
    public void update(Order order) {
        System.out.println("CEO confirms a new order has arrived!");
    }

}
