package pizzaManagement;
import pizzas.*;

import java.util.ArrayList;
import java.util.List;
import pizzaMakingStrategies.*;

public class PizzaOrder {
	
	
	
	private PizzaCookingFactory pizzaFactory;
	private ICookingStrategy cookingStrategy;
	private List<AbstractPizza> pizzaOrderList;
	
	
	public PizzaOrder() {
		this.pizzaOrderList = new ArrayList<>();
		this.pizzaFactory = new PizzaCookingFactory();
	}
	
	/**
	 * @return the pizzaOrderList
	 */
	public List<AbstractPizza> getPizzaOrderList() {
		return pizzaOrderList;
	}

	/**
	 * @param pizzaOrderList the pizzaOrderList to set
	 */
	public void setPizzaOrderList(List<AbstractPizza> pizzaOrderList) {
		this.pizzaOrderList = pizzaOrderList;
	}
	
	public ICookingStrategy getCookingStrategy() {
		return cookingStrategy;
	}

	public void setCookingStrategy(ICookingStrategy cookingStrategy) {
		this.cookingStrategy = cookingStrategy;
	}
	
	
	/**
	 * Prints the toppings that correlate with the orderID that is given. If the order ID is not found, it
	 * prints a statement stating that it cannot be found. If the Order ID is found, simply return.
	 * 
	 * @param orderID
	 */
	public void printListOfToppingsByPizzaOrderID(int orderID) {
		for (AbstractPizza pizza : pizzaOrderList) {
	        if (pizza.getPizzaOrderID() == orderID) {
	            System.out.println("Toppings for Pizza Order ID " + orderID + ":");
	            List<Toppings> toppingsList = pizza.getToppingList();
	            for (Toppings topping : toppingsList) {
	                System.out.println("- " + topping.name());
	            }
	            return; // returns once found
	        }
	    }
	    System.out.println("Order ID " + orderID + " NOT FOUND ");
	}
	
	//This method prints the pizzas in the pizzaOrderList//
	public void printPizzaOrderCart(int orderID) {
		for(AbstractPizza pizza : pizzaOrderList) {
			System.out.println(pizza.toString());
		}
	}
	
	
	//This method finds the pizza order with the given pizza order id and returns it.//
	public AbstractPizza getPizzaByOrderID(int orderID) {
		for(AbstractPizza pizza : pizzaOrderList) {
			if(pizza.getPizzaOrderID() == orderID) {
				return pizza;
			}
		}
		return null; // No pizza with given orderID
		
	}
	
	// This method creates a new pizza with the given PizzaType and adds it to the pizzaOrderList.//
	public boolean addPizzaToCart(PizzaType pizzaType) {
		boolean pizzaAdded = false;
		AbstractPizza pizza =  pizzaFactory.createPizza(pizzaType);
		pizzaOrderList.add(pizza);
		
		if(pizzaOrderList.getLast().getPizzaOrderID() == pizza.getPizzaOrderID()) {
			pizzaAdded = true;
		}
			
		return pizzaAdded;
		 
	}
	
	
	/**This method finds the pizza order with the given ID
	and adds the given topping to its topping list if it doesn’t already exist in the list. If the given
	topping is added, it also updates the pizza price and returns true. If the topping already exists in
	the topping list of the pizza, it returns false
	 * 
	 * @param orderID & topping 
	 * @return True upon success, otherwise false (Topping already exists / no pizza found with OrderID)
	 */
	public boolean addNewToppingToPizza(int orderID, Toppings topping) {
		for (AbstractPizza pizza : pizzaOrderList) {
	        if (pizza.getPizzaOrderID() == orderID) {
	            if (!pizza.getToppingList().contains(topping)) {
	                pizza.getToppingList().add(topping);
	                pizza.updatePizzaPrice();
	                return true; // Return true (topping added successfully)
	            } else {
	                return false; // Return false meaning that the topping already exists
	            }
	        }
	    }
	    return false; // Return false, meaning that no Pizza was found with the given OrderID
	}
	
	
	/** finds the pizza order with the given ID
	and removes the given topping from its topping list if it exists in the list. If the given topping is
	removed, it also updates the pizza price and returns true. If the topping doesn’t exist in the
	topping list of the pizza and cannot be removed, it returns false.
	 * 
	 * @param orderID & topping
	 * @return True upon success, otherwise false (Topping not found on pizza / no pizza found with OrderID)
	 */
	public boolean removeToppingFromPizza(int orderID, Toppings topping) {
		for (AbstractPizza pizza : pizzaOrderList) {
	        if (pizza.getPizzaOrderID() == orderID) {
	            if (pizza.getToppingList().remove(topping)) {
	                pizza.updatePizzaPrice();
	                return true; // Return true (topping removed successfully)
	            } else {
	                return false; // Return false meaning that the topping is not on found on the Pizza
	            }
	        }
	    }
	    return false; // Return false, meaning that no Pizza was found with the given OrderID
	}
	
	

	
	/**
	 * Checks all pizzas in pizzaOrderList for if a pizza does not have a cooking strategy. If a single pizza does not have a 
	 * cooking strategy (i.e. the pizza is uncooked), true is returned. Otherwise, false is returned.
	 * @return boolean for if there is any uncooked pizza
	 */
	public boolean isThereAnyUncookedPizza() {
		for(AbstractPizza pizza : pizzaOrderList) {
			if(!pizza.hasCookingStrategy()) {
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
			total += pizza.getTotalPrice();
		}
		return total;
	}
	
	
	/** This method gets the pizza with the given order ID, instantiates the cookingStrategy according to the cookingStrategyType
	parameter. Calls the cook function for the pizza of the pizza order with the given order ID.
	 * 
	 * @param orderID & cookingStrategyType.
	 * @return True upon success, otherwise false (Order ID not Found / Invalid cookingStrategy.)
	 */
	public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
		for (AbstractPizza pizza : pizzaOrderList) {
	        if (pizza.getPizzaOrderID() == orderID) {
	            ICookingStrategy cookingStrategy; // Instatiate cookingStrategy
	            switch (cookingStrategyType) {
	                case MICROWAVE:
	                    cookingStrategy = new MicrowaveCookingStrategy();
	                    break;
	                case CONVENTIONAL_OVEN:
	                    cookingStrategy = new ConventionalOvenCookingStrategy();
	                    break;
	                case BRICK_OVEN:
	                    cookingStrategy = new BrickOvenCookingStrategy();
	                    break;
	                default:
	                    return false; // Return false if it is an Invalid cookingStrategy type.
	            }
	            pizza.setCookingStrategy(cookingStrategy);
	            pizza.setCookingPrice(cookingStrategy.getCookingPrice());
	            pizza.setTotalPrice(pizza.updatePizzaPrice());
	            return true; // Cooking strategy set successfully
	        }
	    }
	    return false; // Return false, meaning that no Pizza was found with the given OrderID
	}
	
	
}
