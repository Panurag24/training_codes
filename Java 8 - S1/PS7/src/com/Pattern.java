package com;

import java.util.function.Function;

class Burger {
    private String burgerType;

    public Burger(String burgerType) {
        this.burgerType = burgerType;
    }

    public String getBurgerType() {
        return burgerType;
    }

    public Burger addVeggies() {
        System.out.println("Adding veggies to the burger");
        return new Burger(this.burgerType + " Veggie");
    }

    public Burger addCheese() {
        System.out.println("Adding cheese to the burger");
        return new Burger(this.burgerType + " Cheese");
    }

    @Override
    public String toString() {
        return burgerType + " burger";
    }
}

class BurgerShop {
    Function<Burger, Burger> decoration;

    public BurgerShop(Function<Burger, Burger> decoration) {
        this.decoration = decoration;
    }

    public Burger use(Burger baseBurger) {
        System.out.println("Base Burger: " + baseBurger);
        return decoration.apply(baseBurger);
    }
}

public class Pattern {
    public static void main(String[] args) {
        // Create a base burger
        Burger baseBurger = new Burger("burger");

        // Create a BurgerShop with decoration functions
        BurgerShop burgerShop = new BurgerShop(Burger::addVeggies);

        // Use the BurgerShop to add veggies to the base burger
        Burger veggieBurger = burgerShop.use(baseBurger);

        // Update decoration function to add cheese
        burgerShop = new BurgerShop(Burger::addCheese);

        // Use the updated BurgerShop to add cheese to the veggie burger
        Burger deluxeBurger = burgerShop.use(veggieBurger);

        // Print the final burger details
        System.out.println("Final Burger: " + deluxeBurger.getBurgerType());
    }
}

