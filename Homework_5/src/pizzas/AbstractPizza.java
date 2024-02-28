package pizzas;

public abstract class AbstractPizza {

	public AbstractPizza() {
		// TODO Auto-generated constructor stub
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
	protected abstract double updatePizzaPrice();
	
}
