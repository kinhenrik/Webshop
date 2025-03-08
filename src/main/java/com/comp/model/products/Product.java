package com.comp.model.products;

public abstract class Product {

    private int id;
    private String name;
    private double price;
    private String size;
    private String material;
    private String color;

    public Product() {}
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Product(String name, double price, String size, String material, String color) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.material = material;
        this.color = color;
    }

    public int getId() {
        return id;
    } public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    } public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    } public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    } public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    } public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    } public void setColor(String color) {
        this.color = color;
    }
}
