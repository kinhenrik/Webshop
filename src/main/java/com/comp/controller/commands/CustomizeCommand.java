package com.comp.controller.commands;

import com.comp.model.products.Product;

public interface CustomizeCommand {
    Product process(Product product);
}