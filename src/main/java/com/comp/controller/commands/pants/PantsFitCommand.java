package com.comp.controller.commands.pants;

import com.comp.controller.commands.CustomizeCommand;
import com.comp.controller.commands.CustomizePipeline;
import com.comp.model.products.Pants;
import com.comp.model.products.Product;
import com.comp.view.UserInterface;

import java.util.Scanner;

public class PantsFitCommand implements CustomizeCommand {

    private UserInterface ui = UserInterface.getInstance();
    private CustomizePipeline pipeline = CustomizePipeline.getInstance();

    @Override
    public Product process(Product product) {
        Scanner scanner = new Scanner(System.in);
        Pants pants = convert(product);
        System.out.println("\n- Customize pants fit -");
        System.out.println("\n1. Slim");
        System.out.println("2. Straight");
        System.out.println("3. Regular");
        System.out.println("4. Return to menu");
        System.out.print("\nChoose a fit: ");
        switch (scanner.nextInt()) {
            case 1:
                pants.setFit("Slim");
                break;
            case 2:
                pants.setFit("Straight");
                break;
            case 3:
                pants.setFit("Regular");
                break;
            case 4:
                pipeline.clearPipeline();
                ui.createMenu();
                break;
            default:
                System.out.println("Invalid option... ");
                pipeline.clearPipeline();
                ui.createMenu();
        }
        return pants;
    }

    private Pants convert(Product product) {
        return (Pants) product;
    }
}
