package com.comp.view;

import com.comp.controller.OrderManager;
import com.comp.model.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private OrderManager orderManager;
    protected List<Product> productList = new ArrayList<>();

    protected Order() {
        orderManager = OrderManager.getInstance();
    }

    protected void notifyCEO() {
        orderManager.notifyListeners(this);
    }
}
