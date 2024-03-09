package pizzas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MargheritaPizza extends AbstractPizza {

	private final static ArrayList<Toppings> defaultToppings = new ArrayList<>(Arrays.asList(Toppings.TOMATO,Toppings.CHEESE));
	private final static double pizzaPrepCost = PizzaType.MARGHERITA.getToppingPrice();
	
	/**
	 * Parameterized Constructor for if one wants a Margherita Pizza with extra toppings.
	 * @param toppingsList List of extra toppings(a topping appearing twice just means double)
	 * @param pizzaOrderID unique ID of the pizza
	 */
	public MargheritaPizza(List<Toppings> toppingsList, int pizzaOrderID) {	
		super(pizzaPrepCost, pizzaOrderID);
		toppingsList.addAll(defaultToppings);
		this.setToppingList(toppingsList);
		this.addToppingsToPrice(priceWithoutToppings);
	}
	
	/**
	 * Constructor to create a default Margherita Pizza.
	 * @param pizzaOrderID unique ID of the pizza.
	 */
	public MargheritaPizza(int pizzaOrderID) {
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
