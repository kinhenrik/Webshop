package com.comp.view;

import com.comp.controller.builders.PantsBuilder;
import com.comp.controller.builders.SkirtBuilder;
import com.comp.controller.builders.TShirtBuilder;
import com.comp.controller.commands.CustomizePipeline;
import com.comp.controller.commands.pants.PantsFitCommand;
import com.comp.controller.commands.pants.PantsLengthCommand;
import com.comp.controller.commands.skirt.SkirtPatternCommand;
import com.comp.controller.commands.skirt.SkirtWaistCommand;
import com.comp.controller.commands.tshirt.TShirtNeckCommand;
import com.comp.controller.commands.tshirt.TShirtSleevesCommand;
import com.comp.model.products.Pants;
import com.comp.model.products.Skirt;
import com.comp.model.products.TShirt;
import com.comp.model.users.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static UserInterface instance;

    private CustomizePipeline commandPipeline = CustomizePipeline.getInstance();

    private Scanner scanner = new Scanner(System.in);
    private List<Customer> customerList = new ArrayList<>();
    private Customer user;
    private Order order = new Order();
    private Receipt receipt;

    private UserInterface() {}

    public void createMenu() {
        boolean running = true;
        String cartSize = (order.productList.isEmpty() ? "" : "[" + order.productList.size() + "]");

        System.out.println("\n- Main menu -");
        System.out.println("\n1. Products");
        System.out.println("2. Shopping cart " + cartSize);
        System.out.println("3. User details");
        System.out.println("4. Quit");
        System.out.print("\nChoose an option: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    productMenu();
                break;
                case 2:
                    if (!order.productList.isEmpty()) {
                        orderMenu();
                    } else {
                        System.out.println("Shopping cart is empty.");
                        createMenu();
                    }
                break;
                case 3:
                    if (user != null) {
                        userMenu();
                    } else {
                        System.out.println("No user found.");
                        createMenu();
                    }
                break;
                case 4:
                    System.out.println("Quitting...");
                    running = false;
                    System.exit(0);
                break;
                default:
                    System.out.println("Invalid option... ");
                    createMenu();
            }
        }
    }

    public void loginMenu() {
        user = new Customer();
        customerList.add(user);
        for (int i = 0; i < customerList.size(); i++) {
            user.setId(i+1);
        }

        System.out.println("\n- Login -");
        System.out.print("Enter name: ");
        user.setName(scanner.nextLine());
        System.out.print("Enter address: ");
        user.setAddress(scanner.nextLine());
        System.out.print("Enter mail: ");
        user.setMail(scanner.nextLine());
    }

    private void userMenu() {
        boolean running = true;
        System.out.println("\n- User details -");
        System.out.println("Name: " + user.getName() + "(ID: " + user.getId() + ")");
        System.out.println("Address: " + user.getAddress());
        System.out.println("Mail: " + user.getMail());
        System.out.println("\n1. View receipt");
        System.out.println("2. Return to menu");
        System.out.print("\nChoose an option: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    if (receipt != null) {
                        receipt.printReceipt();
                        System.out.print("\nPress any button to return...");
                        try {
                            System.in.read();
                            userMenu();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("\nNo past orders found.");
                        userMenu();
                    }
                    break;
                case 2:
                    System.out.println("Returning to main menu...");
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    userMenu();
            }
        }
    }

    private void productMenu() {
        boolean running = true;

        System.out.println("\n- Products -");
        System.out.println("\n1. Pants");
        System.out.println("2. Skirts");
        System.out.println("3. T-Shirts");
        System.out.println("4. Return to menu");
        System.out.print("\nChoose an option: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    pantsMenu();
                    break;
                case 2:
                    skirtMenu();
                    break;
                case 3:
                    tShirtMenu();
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    productMenu();
            }
        }
    }

    private void pantsMenu() {
        boolean running = true;

        PantsBuilder builder = new PantsBuilder();

        System.out.println("\n- Customize pants size -");
        System.out.println("\n1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        System.out.println("4. Return to menu");
        System.out.print("\nChoose a size: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    builder.addSize("S");
                    running = false;
                    break;
                case 2:
                    builder.addSize("M");
                    running = false;
                    break;
                case 3:
                    builder.addSize("L");
                    running = false;
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    pantsMenu();
            }
        }

        running = true;
        System.out.println("\n- Customize pants material -");
        System.out.println("\n1. Jeans");
        System.out.println("2. Cotton");
        System.out.println("3. Polyester");
        System.out.println("4. Return to menu");
        System.out.print("\nChoose a material: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    builder.addMaterial("Jeans");
                    running = false;
                    break;
                case 2:
                    builder.addMaterial("Cotton");
                    running = false;
                    break;
                case 3:
                    builder.addMaterial("Polyester");
                    running = false;
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    pantsMenu();
            }
        }

        running = true;
        System.out.println("\n- Customize pants color -");
        System.out.println("\n1. Navy");
        System.out.println("2. Black");
        System.out.println("3. Grey");
        System.out.println("4. Khaki");
        System.out.println("5. Return to menu");
        System.out.print("\nChoose a color: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    builder.addColor("Navy");
                    running = false;
                    break;
                case 2:
                    builder.addColor("Black");
                    running = false;
                    break;
                case 3:
                    builder.addColor("Grey");
                    running = false;
                    break;
                case 4:
                    builder.addColor("Khaki");
                    running = false;
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    pantsMenu();
            }
        }

        Pants pants = builder.build();

        commandPipeline.addCommand(new PantsFitCommand());
        commandPipeline.addCommand(new PantsLengthCommand());
        pants = (Pants) commandPipeline.execute(pants);
        commandPipeline.clearPipeline();

        running = true;
        System.out.println("\n" + pants.toString());
        System.out.println("\n1. Add to cart");
        System.out.println("2. Discard");
        System.out.print("\nChoose an option: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    order.productList.add(pants);
                    System.out.println("Product added to cart!");
                    running = false;
                    createMenu();
                    break;
                case 2:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    pantsMenu();
            }
        }
    }

    private void skirtMenu() {
        boolean running = true;

        SkirtBuilder builder = new SkirtBuilder();

        System.out.println("\n- Customize skirt size -");
        System.out.println("\n1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        System.out.println("4. Return to menu");
        System.out.print("\nChoose a size: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    builder.addSize("S");
                    running = false;
                    break;
                case 2:
                    builder.addSize("M");
                    running = false;
                    break;
                case 3:
                    builder.addSize("L");
                    running = false;
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    skirtMenu();
            }
        }

        running = true;
        System.out.println("\n- Customize skirt material -");
        System.out.println("\n1. Linen");
        System.out.println("2. Cotton");
        System.out.println("3. Wool");
        System.out.println("4. Return to menu");
        System.out.print("\nChoose a material: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    builder.addMaterial("Linen");
                    running = false;
                    break;
                case 2:
                    builder.addMaterial("Cotton");
                    running = false;
                    break;
                case 3:
                    builder.addMaterial("Wool");
                    running = false;
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    skirtMenu();
            }
        }

        running = true;
        System.out.println("\n- Customize skirt color -");
        System.out.println("\n1. White");
        System.out.println("2. Black");
        System.out.println("3. Red");
        System.out.println("4. Green");
        System.out.println("5. Return to menu");
        System.out.print("\nChoose a color: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    builder.addColor("White");
                    running = false;
                    break;
                case 2:
                    builder.addColor("Black");
                    running = false;
                    break;
                case 3:
                    builder.addColor("Red");
                    running = false;
                    break;
                case 4:
                    builder.addColor("Green");
                    running = false;
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    skirtMenu();
            }
        }

        Skirt skirt = builder.build();

        commandPipeline.addCommand(new SkirtPatternCommand());
        commandPipeline.addCommand(new SkirtWaistCommand());
        skirt = (Skirt) commandPipeline.execute(skirt);
        commandPipeline.clearPipeline();

        running = true;
        System.out.println("\n" + skirt.toString());
        System.out.println("\n1. Add to cart");
        System.out.println("2. Discard");
        System.out.print("\nChoose an option: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    order.productList.add(skirt);
                    System.out.println("Product added to cart!");
                    running = false;
                    createMenu();
                    break;
                case 2:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    pantsMenu();
            }
        }
    }

    private void tShirtMenu() {
        boolean running = true;

        TShirtBuilder builder = new TShirtBuilder();

        System.out.println("\n- Customize shirt size -");
        System.out.println("\n1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        System.out.println("4. Return to menu");
        System.out.print("\nChoose a size: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    builder.addSize("S");
                    running = false;
                    break;
                case 2:
                    builder.addSize("M");
                    running = false;
                    break;
                case 3:
                    builder.addSize("L");
                    running = false;
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    tShirtMenu();
            }
        }

        running = true;
        System.out.println("\n- Customize shirt material -");
        System.out.println("\n1. Linen");
        System.out.println("2. Cotton");
        System.out.println("3. Polyester");
        System.out.println("4. Jersey");
        System.out.println("5. Return to menu");
        System.out.print("\nChoose a material: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    builder.addMaterial("Linen");
                    running = false;
                    break;
                case 2:
                    builder.addMaterial("Cotton");
                    running = false;
                    break;
                case 3:
                    builder.addMaterial("Polyester");
                    running = false;
                    break;
                case 4:
                    builder.addMaterial("Jersey");
                    running = false;
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    tShirtMenu();
            }
        }

        running = true;
        System.out.println("\n- Customize shirt color -");
        System.out.println("\n1. White");
        System.out.println("2. Black");
        System.out.println("3. Red");
        System.out.println("4. Blue");
        System.out.println("5. Pink");
        System.out.println("6. Orange");
        System.out.println("7. Return to menu");
        System.out.print("\nChoose a color: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    builder.addColor("White");
                    running = false;
                    break;
                case 2:
                    builder.addColor("Black");
                    running = false;
                    break;
                case 3:
                    builder.addColor("Red");
                    running = false;
                    break;
                case 4:
                    builder.addColor("Blue");
                    running = false;
                    break;
                case 5:
                    builder.addColor("Pink");
                    running = false;
                    break;
                case 6:
                    builder.addColor("Orange");
                    running = false;
                    break;
                case 7:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    skirtMenu();
            }
        }

        TShirt tShirt = builder.build();

        commandPipeline.addCommand(new TShirtSleevesCommand());
        commandPipeline.addCommand(new TShirtNeckCommand());
        tShirt = (TShirt) commandPipeline.execute(tShirt);
        commandPipeline.clearPipeline();

        running = true;
        System.out.println("\n" + tShirt.toString());
        System.out.println("\n1. Add to cart");
        System.out.println("2. Discard");
        System.out.print("\nChoose an option: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    order.productList.add(tShirt);
                    System.out.println("Product added to cart!");
                    running = false;
                    createMenu();
                    break;
                case 2:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    pantsMenu();
            }
        }
    }

    private void orderMenu() {
        boolean running = true;
        double totalPrice = 0;
        String cartSize = (order.productList.isEmpty() ? "" : "[" + order.productList.size() + "]");

        System.out.println("\n- Shopping cart " + cartSize + " -");
        for (int i = 0; i < order.productList.size(); i++) {
            System.out.println("\n" + order.productList.get(i));
            totalPrice += order.productList.get(i).getPrice();
        }
        System.out.println("\nShopping cart total: $" + totalPrice);
        System.out.println("\n1. Checkout");
        System.out.println("2. Return to menu");
        System.out.print("\nChoose an option: ");

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    order.notifyCEO();
                    receipt = new Receipt(user, order);
                    running = false;
                    createMenu();
                    break;
                case 2:
                    System.out.println("Returning to main menu...");
                    running = false;
                    createMenu();
                    break;
                default:
                    System.out.println("Invalid option... ");
                    orderMenu();
            }
        }
    }

    public static UserInterface getInstance() {
        if (instance == null) {
            instance = new UserInterface();
        }
        return instance;
    }
}
