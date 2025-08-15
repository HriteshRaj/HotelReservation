package model;

import commandline.AdminMenu;
import commandline.MainMenu;



public class Driver {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu();

        //AdminMenu adminMenu= new AdminMenu();
       // adminMenu.displayAdminMenu();
    }
}
