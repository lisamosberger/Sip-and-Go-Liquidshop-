package com.onlineshop;

import java.lang.reflect.Member;

public class Shop {
    private Drink [] drinks = new Drink[10];
    private Customer [] customers = new Customer[10];

    private int drinkCounter = 0;
    private int customerCounter = 0;

    private double totalSales = 0;



    public void addDrink() {

        String Name = IO.readln("What drink do you want to add? ");
        int quantity = Integer.parseInt(IO.readln("How many of them? "));
        double price = Double.parseDouble(IO.readln("What should be the price? "));
        int ageLimit = Integer.parseInt(IO.readln("Whats the age limit? "));

        Drink drink = new Drink(Name, price, ageLimit, quantity);

        if (drinkCounter >= drinks.length) {
            IO.println("There is no more space for drinks!");
            return;
        }

        drinks[drinkCounter] = drink;
        drinkCounter++;

        IO.println("Drink added successfully!");


    }

    public void addCustomer() {
        if (customerCounter >= customers.length) {
            IO.println("There is no more space for customers!");
            return;
        }
        else {

            String username = IO.readln("Choose a Username: ");
            int age = Integer.parseInt(IO.readln("How old are you? "));
            String password = IO.readln("Choose a Password: ");
            String admin = IO.readln("Are you an admin yes or no? (y/n)");

            boolean a;

            if  (admin.equals("y")) {
                a = true;
            }
            else
                a = false;

            Customer customer = new Customer(username, age, password, a);

            customers[customerCounter] = customer;
            customerCounter++;

            ShopSystem.main();


        }
    }

    public void showCustomers() {

        IO.println("Customers:");
        IO.println("--------------");

        for (int i = 0; i < customerCounter; i++) {

            Customer customer = customers[i];

            if (customerCounter > 0 ) {
                IO.println("Username:" + customer.getName()
                + "\n Age: " + customer.getAge()
                + "\n Password: " + customer.getPassword());
            }
        }
    }

    public void showDrinks(){
        sortDrinkbyPrice();

        IO.println("`\nDrinks:");
        IO.println("--------------");

        for (int i = 0; i < drinkCounter; i++) {

            Drink drink = drinks[i];

            if (drink.quantity() > 0) {
                IO.println(
                        drink.dName()
                        + "\tPrice" + drink.price()
                        + "\tAge limit" + drink.ageLimit()
                        + "Quantity" + drink.quantity()
                );
            }
        }

    }

    public Customer findCustomer(String customerName) {
        for (int i = 0; i < customerCounter; i++) {
            if (customers[i].getName().equalsIgnoreCase(customerName)) {
                return customers[i];
            }
        }
        return null;
    }

    public Drink findDrink() {
        showDrinks();
        String drinkName = IO.readln("Choose a Drink: ");
        for (int i = 0; i < drinkCounter; i++) {

            if(drinks[i].dName().equalsIgnoreCase(drinkName)) {
                return drinks[i];
            }
        }
        IO.println("Drink not found!");
        return null;
    }

    public void sortDrinkbyPrice() {
        for (int i = 0; i < drinkCounter; i++) {
            for (int j = 0; j < drinkCounter - 1; j++) {
                if (drinks[i].price() < drinks[j].price()) {
                    Drink temp = drinks[j];

                    drinks[j] = drinks[i + 1];
                    drinks[i + 1] = temp;
                }
            }
        }
    }

    public void buyDrink(Customer customer) {

        Drink drink = findDrink();

        if (drink == null) {
            return;
        }

        if (drink.quantity() <= 0) {
            IO.println("Drink is not avaiable!");
            return;
        }

        if (customer.getAge() < drink.ageLimit()) {
            IO.println("You are not old enough!");
            return;
        }

        IO.println("Drink is avaiable");
        IO.println("Price " + drink.price());

        totalSales = totalSales + drink.price();

        drinks[index(drink)] = new Drink(
                drink.dName(),
                drink.price(),
                drink.ageLimit(),
                drink.quantity() - 1
        );

        IO.println(drink + " has been bought successfully!");

    }

    public Customer login(){
        String username = IO.readln("Username: ");
        String password = IO.readln("Password: ");

        for (int i = 0; i < customerCounter; i++) {
            if(customers[i].getName().equals(username) && customers[i].checkPassword(password)) {
                Customer loggedInCustomer = customers[i];
                IO.println("You are now logged in!");
                if (customers[i].getAdmin() == true) {
                    ShopSystem.adminMenu(loggedInCustomer);
                }
                else {
                    ShopSystem.userMenu(loggedInCustomer);
                }

                return loggedInCustomer;

            }
            else  {
                IO.println("Invalid username or password!");
            }
        }
        return null;
    }

    private int index(Drink drink) {

        for (int i = 0; i < drinkCounter; i++) {
            if (drinks[i] == drink) {
                return i;
            }
        }

        return -1;
    }

    public double getTotalSales() {
        return totalSales;
    }
}
