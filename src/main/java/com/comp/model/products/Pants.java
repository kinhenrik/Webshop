package com.comp.model.products;

public class Pants extends Product {

    private String fit;
    private int length;

    public Pants() {
        super(1, "Pants", 49.5);
    }
    public Pants(String fit, int length) {
        super(1, "Pants", 49.5);
        this.fit = fit;
        this.length = length;
    }

    public String getFit() {
        return fit;
    } public void setFit(String fit) {
        this.fit = fit;
    }

    public double getLength() {
        return length;
    } public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "- " + super.getName() + " -" +
                "\nSize: " + super.getSize() +
                "\nMaterial: " + super.getMaterial() + " (" + super.getColor() + ")" +
                "\nFit: " + fit + " (" + length + "\" length) " +
                "\nPrice: $" + super.getPrice();
    }
}
