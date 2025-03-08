package com.comp.controller.commands.skirt;

import com.comp.controller.commands.CustomizeCommand;
import com.comp.controller.commands.CustomizePipeline;
import com.comp.model.products.Product;
import com.comp.model.products.Skirt;
import com.comp.view.UserInterface;

import java.util.Scanner;

public class SkirtPatternCommand implements CustomizeCommand {

    private UserInterface ui = UserInterface.getInstance();
    private CustomizePipeline pipeline = CustomizePipeline.getInstance();

    @Override
    public Product process(Product product) {
        Scanner scanner = new Scanner(System.in);
        Skirt skirt = convert(product);
        System.out.println("\n- Customize skirt pattern -");
        System.out.println("\n1. Stripes");
        System.out.println("2. Polka dots");
        System.out.println("3. Floral");
        System.out.println("4. Checkered");
        System.out.println("5. Return to menu");
        System.out.print("\nChoose a pattern: ");
        switch (scanner.nextInt()) {
            case 1:
                skirt.setPattern("Stripes");
                break;
            case 2:
                skirt.setPattern("Polka dots");
                break;
            case 3:
                skirt.setPattern("Floral");
                break;
            case 4:
                skirt.setPattern("Checkered");
                break;
            case 5:
                pipeline.clearPipeline();
                ui.createMenu();
                break;
            default:
                System.out.println("Invalid option... ");
                pipeline.clearPipeline();
                ui.createMenu();
        }
        return skirt;
    }

    private Skirt convert(Product product) {
        return (Skirt) product;
    }

}
