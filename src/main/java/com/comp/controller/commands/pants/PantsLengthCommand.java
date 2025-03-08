package com.comp.controller.commands.pants;

import com.comp.controller.commands.CustomizeCommand;
import com.comp.controller.commands.CustomizePipeline;
import com.comp.model.products.Pants;
import com.comp.model.products.Product;
import com.comp.view.UserInterface;

import java.util.Scanner;

public class PantsLengthCommand implements CustomizeCommand {

    private UserInterface ui = UserInterface.getInstance();
    private CustomizePipeline pipeline = CustomizePipeline.getInstance();

    @Override
    public Product process(Product product) {
        Scanner scanner = new Scanner(System.in);
        Pants pants = convert(product);
        System.out.println("\n- Customize pants length -");
        System.out.print("\nChoose a length between 26\"-34\": ");
        int length = scanner.nextInt();
        if (length < 26 || length > 34) {
            System.out.println("Invalid length.");
            pipeline.clearPipeline();
            ui.createMenu();
        } else {
            pants.setLength(length);
        }
        return pants;
    }

    private Pants convert(Product product) {
        return (Pants) product;
    }

}
