package pizzas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HawaiianPizza extends AbstractPizza {

	private final static ArrayList<Toppings> defaultToppings = new ArrayList<>(Arrays.asList(Toppings.CHEESE,
			Toppings.CANADIAN_BACON, Toppings.PINEAPPLE));
	private final static double pizzaPrepCost = PizzaType.HAWAIIAN.getToppingPrice();
	
	/**
	 * Parameterized Constructor for if one wants a Hawaiian Pizza with extra toppings.
	 * @param toppingsList List of extra toppings(a topping appearing twice just means double)
	 * @param pizzaOrderID unique ID of the pizza
	 */
	public HawaiianPizza(List<Toppings> toppingsList, int pizzaOrderID) {	
		super(pizzaPrepCost, pizzaOrderID);
		toppingsList.addAll(defaultToppings);
		this.setToppingList(toppingsList);
		this.addToppingsToPrice(priceWithoutToppings);
	}
	
	/**
	 * Constructor to create a default Hawaiian Pizza.
	 * @param pizzaOrderID unique ID of the pizza.
	 */
	public HawaiianPizza(int pizzaOrderID) {
		super(defaultToppings,pizzaPrepCost, pizzaOrderID);
	}

	/**
	 * 
	 * @param
	 * @return
	 */
	@Override
	protected double addToppingsToPrice(double priceWithoutToppings) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 * @param
	 * @return
	 */
	@Override
	public double updatePizzaPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
