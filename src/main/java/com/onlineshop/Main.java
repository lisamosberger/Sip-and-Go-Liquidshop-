package com.onlineshop;

public class Main {
    public static void main (){

        Shop shop = new Shop();

        //test
        Drink cola = new Drink("Cola", 20, 0, 50);
        Drink juice = new Drink("Juice", 10, 0, 49);
        Drink energydrink = new Drink("Energy drink", 10, 15, 29);

        shop.addDrink(cola);
        shop.addDrink(juice);
        shop.addDrink(energydrink);

        shop.showDrinks();


        Customer customer = new Customer("First user", 18, "1234");

        shop.addCustomer(customer);

        if (shop.findCustomer("First user") == null) {
            IO.println("Customer not found");
        }
        else  {
            IO.println("Customer found");
        }

        if (shop.findDrink("Energy drink") == null) {
            IO.println("Drink not found");
        }
        else {
            IO.println("Drink found");
        }

        shop.buyDrink(customer, "Cola");

        shop.showDrinks();

    }
}
