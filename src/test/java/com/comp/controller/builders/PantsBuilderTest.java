package com.comp.controller.builders;

import com.comp.model.products.Pants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PantsBuilderTest {

    private PantsBuilder pantsBuilder;

    @BeforeEach
    void setUp() {
        pantsBuilder = new PantsBuilder();
    }

    @Test
    void pantsWithInvalidSizeShouldThrow() {
        String invalidSize = "XXXL";
        assertThrows(RuntimeException.class, () -> pantsBuilder.addSize(invalidSize));
    }

    @Test
    void pantsWithInvalidMaterialShouldThrow() {
        String invalidMaterial = "Plastic";
        assertThrows(RuntimeException.class, () -> pantsBuilder.addMaterial(invalidMaterial));
    }

    @Test
    void pantsWithInvalidColorShouldThrow() {
        String invalidColor = "Yellow";
        assertThrows(RuntimeException.class, () -> pantsBuilder.addColor(invalidColor));
    }

    @Test
    void buildShouldWork() {
        pantsBuilder.addSize("S").addMaterial("Jeans").addColor("Black");
        Pants testPants = pantsBuilder.build();
        assertEquals("S", testPants.getSize());
        assertEquals("Jeans", testPants.getMaterial());
        assertEquals("Black", testPants.getColor());
    }

    @Test
    void buildWithoutMaterialShouldThrow() {
        pantsBuilder.addSize("M").addColor("Black");
        assertThrows(RuntimeException.class, () -> pantsBuilder.build());
    }

    @Test
    void buildWithoutSizeShouldThrow() {
        pantsBuilder.addMaterial("Jeans").addColor("Navy");
        assertThrows(RuntimeException.class, () -> pantsBuilder.build());
    }

    @Test
    void buildWithoutColorShouldThrow() {
        pantsBuilder.addSize("M").addMaterial("Cotton");
        assertThrows(RuntimeException.class, () -> pantsBuilder.build());
    }
}