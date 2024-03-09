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

	@Override
	protected double addToppingsToPrice(double priceWithoutToppings) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double updatePizzaPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
