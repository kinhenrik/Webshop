package com.comp.controller.builders;

import com.comp.model.products.Skirt;

public class SkirtBuilder {

    private Skirt skirt = new Skirt();

    public SkirtBuilder addSize(String size) {
        skirt.setSize(size);
        return this;
    }

    public SkirtBuilder addMaterial(String material) {
        skirt.setMaterial(material);
        return this;
    }

    public SkirtBuilder addColor(String color) {
        skirt.setColor(color);
        return this;
    }

    public Skirt build() {
        if (skirt.getSize() == null || skirt.getMaterial() == null || skirt.getColor() == null) {
            throw new RuntimeException("Something wrong with build progress");
        }
        return skirt;
    }

}
