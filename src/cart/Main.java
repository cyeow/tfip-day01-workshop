package cart;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Console cons = System.console();
        boolean continueRunning = true;
        List<String> cart = new ArrayList<>();

        System.out.println("Welcome to your shopping cart\n");
                
        while(continueRunning) {
            String input = cons.readLine("> ").trim().toLowerCase();
            if(input.startsWith("list")) {
                // call list
                listCart(cart);

            } else if (input.startsWith("add")) {
                // check then add
                addToCart(cart, input.substring(3).trim());

            } else if (input.startsWith("delete")) {
                // call delete

                if(input.substring(6).trim().length() == 1) {
                    deleteFromCart(cart, Integer.parseInt(input.substring(6).trim()));
                } else {
                    deleteFromCart(cart, input.substring(6).trim());
                }
            } else if (input.startsWith("exit")) {
                stopShopping(cart);
            } else {
                System.out.printf("Invalid input.\n");
            }
        }
    }

    private static void stopShopping(List<String> cart) {
        if(cart.size() > 0) {
            System.out.printf("This is your final cart.\n");
            listCart(cart);    
        }
        System.out.printf("Thanks for shopping. Goodbye!\n");
        System.exit(0);
    }

    private static void deleteFromCart(List<String> cart, int i) {
               
        if(cart.size() > i) {
            System.out.printf("%s has been removed from the cart.\n", cart.remove(i));
        } else {
            System.out.printf("Item at position %d does not exist in the cart.\n", i);
        }
    }

    private static void deleteFromCart(List<String> cart, String item) {
        item = item.trim().toLowerCase();
        
        if(cart.contains(item)) {
            deleteFromCart(cart, cart.indexOf(item));
        } else {
            System.out.printf("The cart does not have %s.\n", item);
        }
    }

    private static void addToCart(List<String> cart, String input) {
        // 1. split items into a list 
        // 2. check if item is already in the list 
        // 3. add to list

        ArrayList<String> newItems = new ArrayList<>(Arrays.asList(input.split(",")));

        for(String item : newItems) {
            item = item.trim().toLowerCase();
            if(cart.contains(item)) {
                System.out.printf("You already have %s in the cart.\n", item);
            } else {
                cart.add(item);
                System.out.printf("%s has been added to the cart.\n", item);
            }
        }
    }

    private static void listCart(List<String> cart) {
        
        if(cart.size() > 0) {
            int i = 1;

            for(String item : cart) {
                System.out.printf("%d. %s\n", i++, item);            
            }
        } else {
            System.out.println("Cart is empty. Start adding items by typing \"add [item1], [item2]\"");
        }

    }
}
