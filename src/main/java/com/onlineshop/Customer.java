package com.onlineshop;

public class Customer {
    private String name;
    private int age;
    private String password;

    public Customer(String name, int age, String password){
        this.name = name;
        this.age = age;
        this.password = password;
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
