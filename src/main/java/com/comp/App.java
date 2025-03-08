package com.comp;

import com.comp.controller.OrderManager;
import com.comp.model.users.CEO;
import com.comp.view.UserInterface;

public class App
{
    public static void main( String[] args )
    {
        CEO ceo = new CEO();
        OrderManager manager = OrderManager.getInstance();
        manager.subscribe(ceo);

        UserInterface ui = UserInterface.getInstance();
        ui.loginMenu();
        ui.createMenu();
    }
}
