package org.example.Head06_SpringOverview.example2;

import org.example.Head06_SpringOverview.example2.MenuService;
import org.example.Head06_SpringOverview.example2.MenuServiceStub;

import java.awt.*;

public class DIExampleUsingInterface {
    public static void main(String[] args) {
        MenuService realService = new MenuServiceImpl();
        MenuController controller = new MenuController(realService);
        controller.printMenu();

        MenuService stubService = new MenuServiceStub();
        MenuController testController = new MenuController(stubService);
        testController.printMenu();
    }
}
