package pizzaManagement;
import pizzas.*;
import pizzaMakingStrategies.*;

public class PizzaOrder {

	public PizzaOrder() {
		// TODO Auto-generated constructor stub
	}
	
	
	//gets the pizza order with the given pizza order ID and prints the toppings of that order //
	public void printListOfToppingsByPizzaOrderID(int orderID) {
		
	}
	
	//This method prints the pizzas in the pizzaOrderList//
	public void printPizzaOrderCart(int orderID) {
		
	}
	
	
	//This method finds the pizza order with the given pizza order id and returns it.//
	public AbstractPizza getPizzaByOrderID(int orderID) {
		return null;
		
	}
	
	// This method creates a new pizza with the given PizzaType and adds it to the pizzaOrderList.//
	public boolean addPizzaToCart(PizzaType pizzaType) {
		 return false;
		 
	}
	
	
	/*This method finds the pizza order with the given ID
	and adds the given topping to its topping list if it doesn’t already exist in the list. If the given
	topping is added, it also updates the pizza price and returns true. If the topping already exists in
	the topping list of the pizza, it returns false */
	public boolean addNewToppingToPizza(int orderID, Toppings topping) {
		return false;
	}
	
	
	/* finds the pizza order with the given ID
	and removes the given topping from its topping list if it exists in the list. If the given topping is
	removed, it also updates the pizza price and returns true. If the topping doesn’t exist in the
	topping list of the pizza and cannot be removed, it returns false. */
	public boolean removeToppingFromPizza(int orderID, Toppings topping) {
		return false;
	}
	
	
	/*This method checks the pizzas in the pizzaOrderList and checks their cooking strategies. It returns
	true if there are any pizzas without any assigned pizza cooking strategy. It returns false if there
	are no pizzas without an assigned cooking strategy. */
	public boolean isThereAnyUncookedPizza() {
		return false;
	}
	
	
	/*This method checks if there are any uncooked pizzas. If all pizzas are cooked, it calculates the total
	price of all pizzas and returns the total cart price. However, if there is at least one uncooked pizza
	it throws an exception (Use the general Exception class). The checkout method calls the
	isThereAnyUncookedPizza method to check for uncooked pizzas and throws an exception*/
	public double checkout() throws Exception{
		return -1.0;
	}
	
	
	/*This method gets the pizza with the given order ID, instantiates the cookingStrategy according to the cookingStrategyType
	parameter. Calls the cook function for the pizza of the pizza order with the given order ID. */
	public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
		return false;
	}
	
	
}
