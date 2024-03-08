package pizzaManagement;
import pizzas.*;
import java.util.List;
import pizzaMakingStrategies.*;

public class PizzaOrder {
	
	
	
	private PizzaCookingFactory pizzaFactory;
	private ICookingStrategy cookingStrategy;
	private List<AbstractPizza> pizzaOrderList;
	
	
	public PizzaOrder() {
		// TODO Auto-generated constructor stub
	}
	
	public ICookingStrategy getCookingStrategy() {
		return cookingStrategy;
	}

	public void setCookingStrategy(ICookingStrategy cookingStrategy) {
		this.cookingStrategy = cookingStrategy;
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
	
	
	/**
	 * Private helper function to determine if a given pizza has a cooking strategy.
	 * @param pizza to check cooking strategy
	 * @return boolean for if pizza has a cooking strategy.
	 */
	private boolean hasCookingStrategy(AbstractPizza pizza) {
		ICookingStrategy cookingStrategy = pizza.getCookingStrategy();
		if(cookingStrategy instanceof BrickOvenCookingStrategy ||
		   cookingStrategy instanceof ConventionalOvenCookingStrategy ||
		   cookingStrategy instanceof MicrowaveCookingStrategy) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks all pizzas in pizzaOrderList for if a pizza does not have a cooking strategy. If a single pizza does not have a 
	 * cooking strategy (i.e. the pizza is uncooked), true is returned. Otherwise, false is returned.
	 * @return boolean for if there is any uncooked pizza
	 */
	public boolean isThereAnyUncookedPizza() {
		for(AbstractPizza pizza : pizzaOrderList) {
			if(!this.hasCookingStrategy(pizza)) {
				return true;
			}	
		}
		return false;
	}
	
	
	/**
	 * Calculates the total price of all pizzas in the pizzaOrderList given that all pizzas have a cooking strategy.
	 * If a pizza does not have one, an Exception is thrown.
	 * @return price of all pizzas in the pizzaOrderList
	 * @throws Exception Says that there are uncooked pizzas
	 */
	public double checkout() throws Exception{
		if(this.isThereAnyUncookedPizza()) {
			throw new Exception("There are uncooked pizzas! Cook all the pizzas next time.");
		}
		double total = 0.0;
		for(AbstractPizza pizza : pizzaOrderList) {
			total+= pizza.getTotalPrice();
		}
		return total;
	}
	
	
	/*This method gets the pizza with the given order ID, instantiates the cookingStrategy according to the cookingStrategyType
	parameter. Calls the cook function for the pizza of the pizza order with the given order ID. */
	public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
		return false;
	}
	
	
}
