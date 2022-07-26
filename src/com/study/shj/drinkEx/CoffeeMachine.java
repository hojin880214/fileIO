package com.study.shj.drinkEx;

public class CoffeeMachine extends DrinkMachine{

    @Override
    public Drink dispenseDrink() {
        return new Coffee();
    }
}
