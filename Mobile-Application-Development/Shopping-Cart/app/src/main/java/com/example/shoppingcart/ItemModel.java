package com.example.shoppingcart;

import java.io.Serializable;

public class ItemModel implements Serializable {
    String name;
    int cost, quantity;

    public ItemModel (String name, int cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }
    public void decrementQuantity() {
        if (this.quantity == 0) {
            System.out.println("Invalid quantity!");
        } else{
            this.quantity--;
        }
    }

    // accessor methods
    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public int getQuantity() {
        return this.quantity;
    }

}
