package com.comp.controller.builders;

import com.comp.model.products.TShirt;

public class TShirtBuilder {

    private TShirt tShirt = new TShirt();

    public TShirtBuilder addSize(String size) {
        tShirt.setSize(size);
        return this;
    }

    public TShirtBuilder addMaterial(String material) {
        tShirt.setMaterial(material);
        return this;
    }

    public TShirtBuilder addColor(String color) {
        tShirt.setColor(color);
        return this;
    }

    public TShirt build() {
        if (tShirt.getSize() == null || tShirt.getMaterial() == null || tShirt.getColor() == null) {
            throw new RuntimeException("Something wrong with build progress");
        }
        return tShirt;
    }

}
