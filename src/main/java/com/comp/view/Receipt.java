package com.comp.view;

import com.comp.model.products.Product;
import com.comp.model.users.Customer;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private Order order;
    private Customer customer;
    private List<Product> receiptList = new ArrayList<>();

    public Receipt() {}
    public Receipt(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
        saveOrder(order);
    }

    private void saveOrder(Order order) {
        receiptList.addAll(order.productList);
        order.productList.clear();
    }

    protected void printReceipt() {
        double totalPrice = 0;
        for (int i = 0; i < receiptList.size(); i++) {
            totalPrice += receiptList.get(i).getPrice();
        }
        System.out.println("\n- Receipt -");
        System.out.println("Buyer name: " + customer.getName() + "(ID: " + customer.getId() + ")");
        System.out.println("Buyer e-mail: " + customer.getMail());
        System.out.println("Shipping address: " + customer.getAddress());
        System.out.println("\nProducts ordered:");
        for (Product product : receiptList) {
            System.out.println(product);
            System.out.println("");
        }
        System.out.println("Total price: $" + totalPrice);
    }

    public Order getOrder() {
        return order;
    } public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    } public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
