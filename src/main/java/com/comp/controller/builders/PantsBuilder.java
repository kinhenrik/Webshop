package com.comp.controller.builders;

import com.comp.model.products.Pants;

import java.util.Arrays;

public class PantsBuilder {

    private Pants pants = new Pants();

    public PantsBuilder addSize(String size) {
        String[] validSizes = new String[]{
          "S", "M", "L" };
        if (Arrays.asList(validSizes).contains(size)) {
            pants.setSize(size);
        } else {
            throw new RuntimeException("Invalid size used");
        }
        return this;
    }

    public PantsBuilder addMaterial(String material) {
        String[] validMaterials = new String[]{
                "Jeans", "Cotton", "Polyester" };
        if (Arrays.asList(validMaterials).contains(material)) {
        pants.setMaterial(material);
        } else {
            throw new RuntimeException("Invalid material used");
        }
        return this;
    }

    public PantsBuilder addColor(String color) {
        String[] validColors = new String[]{
                "Navy", "Black", "Grey", "Khaki" };
        if (Arrays.asList(validColors).contains(color)) {
            pants.setColor(color);
        } else {
            throw new RuntimeException("Invalid color used");
        }
        return this;
    }

    public Pants build() {
        if (pants.getSize() == null || pants.getMaterial() == null || pants.getColor() == null) {
            throw new RuntimeException("Something wrong with build progress");
        }
        return pants;
    }

}
