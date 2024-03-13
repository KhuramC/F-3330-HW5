package testing;
import pizzas.*;
import pizzaMakingStrategies.*;
import pizzaManagement.*;


public class Main {

    public static void main(String[] args) {
        // Instantiate a pizza order
        PizzaOrder order = new PizzaOrder();

        // Add pizzas to the cart
        order.addPizzaToCart(PizzaType.MARGHERITA);
        order.addPizzaToCart(PizzaType.VEGETARIAN);

        // Print the pizza order cart
        System.out.println("Pizza Order Cart:");
        order.printPizzaOrderCart(1);

        // Select cooking strategies for the pizzas in the cart
        order.selectCookingStrategyByPizzaOrderID(1, CookingStyleType.BRICK_OVEN);
        order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.CONVENTIONAL_OVEN);

        // Print the pizza order cart with cooking strategies
        System.out.println("\nPizza Order Cart , printed with selected CookingStategy(s)");
        order.printPizzaOrderCart(1);

        try {
            // Attempt to checkout (calculate the total price)
            double totalPrice = order.checkout();
            System.out.println("\nCheckout Success. ----- Total Price: $" + totalPrice);
        } catch (Exception e) {
            // Exception (uncooked pizzas)
            System.out.println("\nError upon checkout " + e.getMessage());
        }

        // Commented out until needed ----- Test for adding new toppings
        order.addNewToppingToPizza(1, Toppings.BLACK_OLIVE);
//        order.addNewToppingToPizza(1, Toppings.MUSHROOM);
//        order.addNewToppingToPizza(2, Toppings.CANADIAN_BACON);
//
//
        System.out.println("\nPizza Order Cart after the added toppings:");
        order.printPizzaOrderCart(1);
//
     // A second checkout to show that when BlackOlives are added, the price is increased.
        try {
            // Attempt to checkout (calculate the total price)
            double totalPrice = order.checkout();
            System.out.println("\nCheckout Success. ----- Total Price: $" + totalPrice);
        } catch (Exception e) {
            // Exception (uncooked pizzas)
            System.out.println("\nError upon checkout " + e.getMessage());
        }
        
        // Commented out until needed ----- Test for removing new toppings
//        order.removeToppingFromPizza(1, Toppings.BLACK_OLIVE);
        order.removeToppingFromPizza(2, Toppings.MUSHROOM);

        System.out.println("\nPizza Order Cart after the removed toppings:");
        order.printPizzaOrderCart(1);

        // A third checkout to show that when Mushrooms are removed, price is decreased.
        try {
            // Attempt to checkout (calculate the total price)
            double totalPrice = order.checkout();
            System.out.println("\nCheckout Success. ----- Total Price: $" + totalPrice);
        } catch (Exception e) {
            // Exception (uncooked pizzas)
            System.out.println("\nError upon checkout " + e.getMessage());
        }
        
        // Printing toppings by OrderID. As well as an order ID that should not be found (3).
        System.out.println("\n");
        order.printListOfToppingsByPizzaOrderID(1);
        order.printListOfToppingsByPizzaOrderID(2);
//        order.printListOfToppingsByPizzaOrderID(3);

    }
}
