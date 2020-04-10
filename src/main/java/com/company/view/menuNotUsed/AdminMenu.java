package com.company.view.menuNotUsed;


//import database.SqlConnector;
//import database.basket.BasketDAO;
//import database.order.OrderDAO;
//import database.user.UserDAO;


public class AdminMenu {
    public static void displayDeleteMode() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *              EDIT  MODE              *");
        System.out.println("     ****************************************");
        System.out.println("     What do you want to do ?");
        System.out.println("     (1) Delete product - WIP");
        System.out.println("     (2) Delete category - WIP");
        System.out.println("     (3) Delete order - WIP");
        System.out.println("     (4) Delete user - WIP\n");
        System.out.println("     (0) Back to main menu");
    }


    public static void displayAddMode() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *               ADD  MODE              *");
        System.out.println("     ****************************************");
        System.out.println("     What do you want to do ?");
        System.out.println("     (1) Add product");
        System.out.println("     (2) Add category");
        System.out.println("     (3) Add order - WIP");
        System.out.println("     (4) Add new user - WIP\n");
        System.out.println("     (0) Back to main menu");
    }

    public static void displayEditMode() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *              EDIT  MODE              *");
        System.out.println("     ****************************************");
        System.out.println("     What do you want to do ?");
        System.out.println("     (1) Edit product - WIP");
        System.out.println("     (2) Edit category");
        System.out.println("     (3) Edit order - WIP, edit status DONE!");
        System.out.println("     (4) Edit user - WIP\n");
        System.out.println("     (0) Back to main menu");
    }

    public static void displayMenu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *               ADMIN  MENU            *");
        System.out.println("     ****************************************");
        System.out.println("     What do you want to do ?");
        System.out.println("     (1) Display products");
        System.out.println("     (2) Display categories");
        System.out.println("     (3) Display orders");
        System.out.println("     (4) Display users\n");
        System.out.println("     (5) Delete methods"); // user, products, categories,
        System.out.println("     (6) Edit methods"); // user, products, categories
        System.out.println("     (7) Add methods\n"); // user, products, categories
        System.out.println("     (8) STATS");
        System.out.println("     (9) ");
        System.out.println("     (0) Log out");
    }
}

