package com.comp.model.products;

public class Skirt extends Product {

    private int waistline;
    private String pattern;

    public Skirt() {
        super(2, "Skirt", 34.5);
    }
    public Skirt(int waistline, String pattern) {
        super(2, "Skirt", 34.5);
        this.waistline = waistline;
        this.pattern = pattern;
    }

    public double getWaistline() {
        return waistline;
    } public void setWaistline(int waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    } public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "- " + super.getName() + " -" +
                "\nSize: " + super.getSize() + " (" + waistline + "\" waist)" +
                "\nMaterial: " + super.getMaterial() + " (" + super.getColor() + ")" +
                "\nPattern: " + pattern +
                "\nPrice: $" + super.getPrice();
    }
}
