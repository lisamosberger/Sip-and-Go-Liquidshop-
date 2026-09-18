package com.onlineshop;

public class ShopSystem {
    static void main () {

        Shop shop = new Shop();

        IO.println("\tWelcome to Sip and Go!" +
                "\n ====================================================" +
                "\n 1. Log in " +
                "\n 2. Log in as admin" +
                "\n 3. Sign Up " +
                "\n 4. Drinks and quantity" +
                "\n e. to Exit");
        String a = IO.readln("Choose an Option: ");

        switch (a) {
            case "1" -> Login();
            case "2" -> LoginAdmin();
            case "3" -> shop.addCustomer();
            case "4" -> Drinks();
            case "e" -> Exit();
        }







    }

    private static void Exit() {
        IO.println("Thank you for using Sip and Go!");
        System.exit(0);
    }
}
