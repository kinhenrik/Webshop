package com.comp.controller.commands;

import com.comp.model.products.Product;

import java.util.ArrayList;
import java.util.List;

public class CustomizePipeline {

    private static CustomizePipeline instance;
    private CustomizePipeline() {};

    private List<CustomizeCommand> pipeline = new ArrayList<>();

    public void addCommand(CustomizeCommand command) {
        pipeline.add(command);
    }

    public Product execute(Product product) {
        Product result = product;
        for (CustomizeCommand command : pipeline) {
            result = command.process(result);
        }
        return result;
    }

    public void clearPipeline() {
        pipeline.clear();
    }

    public static CustomizePipeline getInstance() {
        if (instance == null) {
            instance = new CustomizePipeline();
        }
        return instance;
    }

}
