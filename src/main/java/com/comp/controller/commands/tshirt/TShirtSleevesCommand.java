package com.comp.controller.commands.tshirt;

import com.comp.controller.commands.CustomizeCommand;
import com.comp.controller.commands.CustomizePipeline;
import com.comp.model.products.Product;
import com.comp.model.products.TShirt;
import com.comp.view.UserInterface;

import java.util.Scanner;

public class TShirtSleevesCommand implements CustomizeCommand {

    private UserInterface ui = UserInterface.getInstance();
    private CustomizePipeline pipeline = CustomizePipeline.getInstance();

    @Override
    public Product process(Product product) {
        Scanner scanner = new Scanner(System.in);
        TShirt shirt = convert(product);
        System.out.println("\n- Customize shirt-sleeves -");
        System.out.println("\n1. Long");
        System.out.println("2. Short");
        System.out.println("3. Return to menu");
        System.out.print("\nChoose a sleeve type: ");
        switch (scanner.nextInt()) {
            case 1:
                shirt.setSleeves("Long");
                break;
            case 2:
                shirt.setSleeves("Short");
                break;
            case 3:
                pipeline.clearPipeline();
                ui.createMenu();
                break;
            default:
                System.out.println("Invalid option... ");
                pipeline.clearPipeline();
                ui.createMenu();
        }
        return shirt;
    }

    private TShirt convert(Product product) {
        return (TShirt) product;
    }

}
