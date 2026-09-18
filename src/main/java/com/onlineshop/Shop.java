package com.onlineshop;

public class Shop {
    private Drink [] drinks = new Drink[10];
    private Customer [] customers = new Customer[10];

    private int drinkCounter = 0;
    private int customerCounter = 0;

    private double totalSales = 0;



    public void addDrink(Drink drink) {
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


        }
    }

    public void showDrinks(){

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

    public Drink findDrink(String drinkName) {
        sortDrinkbyPrice();
        for (int i = 0; i < drinkCounter; i++) {

            if(drinks[i].dName().equalsIgnoreCase(drinkName)) {
                return drinks[i];
            }
        }
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

    public void buyDrink(Customer customer, String drinkName) {

        Drink drink = findDrink(drinkName);

        if (drink != null) {
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

        IO.println(drinkName + " has been bought successfully!");

    }

    private int index(Drink drink) {

        for (int i = 0; i < drinkCounter; i++) {
            if (drinks[i] == drink) {
                return i;
            }
        }

        return -1;
    }

}
