package com.onlineshop;

public class Main {
    public static void main (){

        Shop shop = new Shop();

        //test
        Drink cola = new Drink("Cola", 20, 0, 50);
        Drink juice = new Drink("Juice", 10, 0, 49);
        Drink energydrink = new Drink("Energy drink", 10, 15, 29);

        shop.showDrinks();


        Customer customer = new Customer("First user", 18, "1234", false);

        shop.addCustomer();

        if (shop.findCustomer("First user") == null) {
            IO.println("Customer not found");
        }
        else  {
            IO.println("Customer found");
        }


        shop.showDrinks();

    }
}
