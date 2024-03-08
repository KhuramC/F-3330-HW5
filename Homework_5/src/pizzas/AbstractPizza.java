package pizzas;

import java.util.ArrayList;
import java.util.List;

import pizzaMakingStrategies.ICookingStrategy;

public abstract class AbstractPizza {
/*Implement an abstract base class AbstractPizza with protected attributes/fields 
toppingList(List<Toppings>), priceWithoutToppings(double), totalPrice(double),
pizzaOrderID(int), orderIDCounter(static int), cookingStrategy(ICookingStrategy), 
cookingPrice(double). Also, a constructor should be implemented to instantiate the toppingList 
as an ArrayList and respective setter and getter methods
 */
	// Protected attributes
	protected List<Toppings> toppingList;
	protected double priceWithoutToppings;
	protected double totalPrice;
	protected int pizzaOrderID;
	protected static int orderIDCounter;
	protected ICookingStrategy cookingStrategy;
	protected double cookingPrice;
	
	// Constructor
	public AbstractPizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice, int pizzaOrderID,
			ICookingStrategy cookingStrategy, double cookingPrice) {
		super();
		this.toppingList = new ArrayList<>(); // instantiate the toppingList as an ArrayList
		this.priceWithoutToppings = priceWithoutToppings;
		this.totalPrice = totalPrice;
		this.pizzaOrderID = pizzaOrderID;
		this.cookingStrategy = cookingStrategy;
		this.cookingPrice = cookingPrice;
	}

	// copy constructor
	public AbstractPizza(AbstractPizza p) {
		this.toppingList = new ArrayList<>();
		for (Toppings topping : p.toppingList) {
			this.toppingList.add(topping);
		}
		this.priceWithoutToppings = p.getPriceWithoutToppings();
		this.totalPrice = p.getTotalPrice();
		this.pizzaOrderID = p.getPizzaOrderID();
		this.cookingStrategy = p.getCookingStrategy();
		this.cookingPrice = p.getCookingPrice();
	}
	
	
	/**
	 * @return the toppingList
	 */
	public List<Toppings> getToppingList() {
		return toppingList;
	}


	/**
	 * @param toppingList the toppingList to set
	 */
	public void setToppingList(List<Toppings> toppingList) {
		this.toppingList = toppingList;
	}


	/**
	 * @return the priceWithoutToppings
	 */
	public double getPriceWithoutToppings() {
		return priceWithoutToppings;
	}


	/**
	 * @param priceWithoutToppings the priceWithoutToppings to set
	 */
	public void setPriceWithoutToppings(double priceWithoutToppings) {
		this.priceWithoutToppings = priceWithoutToppings;
	}


	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}


	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	/**
	 * @return the pizzaOrderID
	 */
	public int getPizzaOrderID() {
		return pizzaOrderID;
	}


	/**
	 * @param pizzaOrderID the pizzaOrderID to set
	 */
	public void setPizzaOrderID(int pizzaOrderID) {
		this.pizzaOrderID = pizzaOrderID;
	}


	/**
	 * @return the orderIDCounter
	 */
	public static int getOrderIDCounter() {
		return orderIDCounter;
	}


	/**
	 * @param orderIDCounter the orderIDCounter to set
	 */
	public static void setOrderIDCounter(int orderIDCounter) {
		AbstractPizza.orderIDCounter = orderIDCounter;
	}


	/**
	 * @return the cookingStrategy
	 */
	public ICookingStrategy getCookingStrategy() {
		return cookingStrategy;
	}


	/**
	 * @param cookingStrategy the cookingStrategy to set
	 */
	public void setCookingStrategy(ICookingStrategy cookingStrategy) {
		this.cookingStrategy = cookingStrategy;
	}


	/**
	 * @return the cookingPrice
	 */
	public double getCookingPrice() {
		return cookingPrice;
	}


	/**
	 * @param cookingPrice the cookingPrice to set
	 */
	public void setCookingPrice(double cookingPrice) {
		this.cookingPrice = cookingPrice;
	}


	/*calculates the total price of the pizza using
	priceWithoutToppings and the prices of each topping in the toppingsList. It also assigns
	totalPrice attribute to the calculated total price, and priceWithoutToppings attribute to
	the passed parameter. This could be called once to add the default toppings. */
	protected abstract double addToppingsToPrice(double priceWithoutToppings);
	
	
	/* calculates and updates the
	totalPrice of the pizza using priceWithoutToppings attribute and the prices of each
	topping in the toppingsList. You can use this method on each update you make with the
	pizza.*/
	public abstract double updatePizzaPrice();
	
}
