package pizzas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SupremePizza extends AbstractPizza {

	private final static ArrayList<Toppings> defaultToppings = new ArrayList<>(Arrays.asList(Toppings.CHEESE,Toppings.TOMATO,
			Toppings.BELL_PEPPER,Toppings.ITALIAN_SAUSAGE,Toppings.PEPPERONI,Toppings.BLACK_OLIVE,Toppings.MUSHROOM));
	private final static double pizzaPrepCost = PizzaType.SUPREME.getToppingPrice();
	
	/**
	 * Parameterized Constructor for if one wants a Supreme Pizza with extra toppings.
	 * @param toppingsList List of extra toppings(a topping appearing twice just means double)
	 * @param pizzaOrderID unique ID of the pizza
	 */
	public SupremePizza(List<Toppings> toppingsList, int pizzaOrderID) {	
		super(pizzaPrepCost, pizzaOrderID);
		toppingsList.addAll(defaultToppings);
		this.setToppingList(toppingsList);
		this.addToppingsToPrice(priceWithoutToppings);
	}
	
	/**
	 * Constructor to create a default Supreme Pizza.
	 * @param pizzaOrderID unique ID of the pizza.
	 */
	public SupremePizza(int pizzaOrderID) {
		super(defaultToppings,pizzaPrepCost, pizzaOrderID);
	}

	/**
	 * calculates the total price of the pizza using
	 * priceWithoutToppings and the prices of each topping in the toppingsList. It also assigns
	 * totalPrice attribute to the calculated total price, and priceWithoutToppings attribute to
	 * the passed parameter. This could be called once to add the default toppings.
	 * @param priceWithoutToppings price without toppings
	 * @return the total price
	 */
	@Override
	protected double addToppingsToPrice(double priceWithoutToppings) {
		this.priceWithoutToppings = priceWithoutToppings;
		double toppingsPrice = 0;
		for (Toppings topping : toppingList) {
			toppingsPrice += topping.getToppingPrice();
		}
		this.totalPrice = toppingsPrice + priceWithoutToppings;
		return this.totalPrice;
	}

	/**
	 * calculates and updates the 
	 * totalPrice of the pizza using priceWithoutToppings attribute and the prices of each 
	 * topping in the toppingsList. You can use this method on each update you make with the 
	 * pizza.
	 * @return returns the final pizza price.
	 */
	@Override
	public double updatePizzaPrice() {
		this.totalPrice = this.addToppingsToPrice(pizzaPrepCost) + this.getCookingPrice();
		return this.totalPrice;
	}
	@Override
	public String toString() {
		return "Supreme Pizza [toppingList=" + toppingList + ", priceWithoutToppings=" + priceWithoutToppings
				+ ", totalPrice=" + totalPrice + ", pizzaOrderID=" + pizzaOrderID + ", cookingStrategy="
				+ cookingStrategy + ", cookingPrice=" + cookingPrice + "]";
	}
}
