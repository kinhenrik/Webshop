package com.comp.controller.commands.skirt;

import com.comp.controller.commands.CustomizeCommand;
import com.comp.controller.commands.CustomizePipeline;
import com.comp.model.products.Product;
import com.comp.model.products.Skirt;
import com.comp.view.UserInterface;

import java.util.Scanner;

public class SkirtWaistCommand implements CustomizeCommand {

    private UserInterface ui = UserInterface.getInstance();
    private CustomizePipeline pipeline = CustomizePipeline.getInstance();

    @Override
    public Product process(Product product) {
        Scanner scanner = new Scanner(System.in);
        Skirt skirt = convert(product);
        System.out.println("\n- Customize skirt waistline size -");
        System.out.print("\nChoose a size between 16\"-27\": ");
        int waistSize = scanner.nextInt();
        if (waistSize < 16 || waistSize > 27) {
            System.out.println("Invalid size.");
            pipeline.clearPipeline();
            ui.createMenu();
        } else {
            skirt.setWaistline(waistSize);
        }
        return skirt;
    }

    private Skirt convert(Product product) {
        return (Skirt) product;
    }

}
