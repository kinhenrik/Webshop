package com.comp.model.products;

public class TShirt extends Product {

    private String sleeves;
    private String neck;

    public TShirt() {
        super(3, "T-Shirt", 25.0);
    }
    public TShirt(String sleeves, String neck) {
        super(3, "T-Shirt", 25.0);
        this.sleeves = sleeves;
        this.neck = neck;
    }

    public String getSleeves() {
        return sleeves;
    } public void setSleeves(String sleeves) {
        this.sleeves = sleeves;
    }

    public String getNeck() {
        return neck;
    } public void setNeck(String neck) {
        this.neck = neck;
    }

    @Override
    public String toString() {
        return "- " + super.getName() + " -" +
                "\nSize: " + super.getSize() +
                "\nMaterial: " + super.getMaterial() + " (" + super.getColor() + ")" +
                "\nSleeves: " + sleeves +
                "\nNeck: " + neck +
                "\nPrice: $" + super.getPrice();
    }
}
