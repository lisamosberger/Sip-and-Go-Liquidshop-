package com.onlineshop;

public class Customer {
    private String name;
    private int age;
    private String password;
    private boolean admin;

    public Customer(String name, int age, String password, boolean admin) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

   public boolean checkPassword(String password){
        return this.password.equals(password);
   }
}
