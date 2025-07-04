package org.example.ecomercecheckout;

import org.example.ecomercecheckout.Model.*;
import org.example.ecomercecheckout.Service.CartService;
import org.example.ecomercecheckout.Service.CheckoutService;

import java.time.LocalDate;

public class AppController
{
    public static void main(String[] args)
    {
        try {
            // Customer
            Customer customer = new Customer("Ahmed", 1000);

            // Products
            Product cheese = new ExpirableProduct("Cheese", 100, 10, LocalDate.now().plusDays(2), 0.4);
            Product biscuits = new ExpirableProduct("Biscuits", 150, 5, LocalDate.now().plusDays(5), 0.7);
            Product tv = new ShippableProduct("TV", 500, 3, 8.0);
            Product scratchCard = new NotShippableProduct("Mobile Scratch Card", 10, 50);

            // Cart Service
            CartService cart = new CartService();

            // Add products
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(scratchCard, 1);

            // Checkout
            CheckoutService checkoutService = new CheckoutService();
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}