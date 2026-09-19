package com.onlineshop;

public class ShopSystem {

    static Shop shop = new Shop();
    static void main () {

        while(true) {
            IO.println("\tWelcome to Sip and Go!" +
                    "\n ====================================================" +
                    "\n 1. Log in " +
                    "\n 2. Sign Up " +
                    "\n 3. Drinks and quantity" +
                    "\n e. to Exit");
            String a = IO.readln("Choose an Option: ");

            switch (a) {
                case "1" -> shop.login();
                case "2" -> shop.addCustomer();
                case "3" -> shop.showDrinks();
                case "e" -> Exit();
                default -> IO.println("Invalid Option");
            }
        }
    }

    public static void userMenu(Customer loggedInCustomer) {

        while (true) {
            IO.println("Welcome to Sip and Go!" +
                    "\n =================================================" +
                    "\n 1. Buy drinks " +
                    "\n 2. Drinks and quantity" +
                    "\n e. Log out");

            switch (IO.readln("Choose an Option: ")) {
                case "1" -> shop.buyDrink(loggedInCustomer);
                case "2" -> shop.showDrinks();
                case "e" -> ShopSystem.main();
                default -> IO.println("Invalid Option");
            }
        }
    }

    public static void adminMenu(Customer loggedInCustomer) {

        while (true) {
            IO.println("Welcome to Sip and Go!" +
                    "\n======================================" +
                    "\n 1. Add drinks" +
                    "\n 2. Show all drinks " +
                    "\n 3. Delete drinks " +
                    "\n 4. Member list" +
                    "\n 5. Selling list and total profit " +
                    "\n e. Log out");

            switch (IO.readln("Choose an Option: ")) {
                case "1" -> shop.addDrink();
                case "2" -> shop.showDrinks();
                case "4" -> shop.showCustomers();
                case "5" -> shop.getTotalSales();
                case "e" -> ShopSystem.main();
                default -> IO.println("Invalid Option");

            }
        }
    }


    private static void Exit() {
        IO.println("Thank you for using Sip and Go!");
        System.exit(0);
    }
}
