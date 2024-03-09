package pizzaMakingStrategies;

import pizzas.AbstractPizza;

/**
 * A cooking Strategy for using the regular oven that implements ICookingStrategy. The cooking price for
 * the regular oven is defined in the CookingStyleType.
 */
public class ConventionalOvenCookingStrategy implements ICookingStrategy {

	
	/**
	 * Default Constructor to create an instance.
	 */
	public ConventionalOvenCookingStrategy() {
	}

	
	/**
	 * Returns the associated CookingStyleType of regular oven cooking.
	 * @return CONVENTIONAL_OVEN enum
	 */
	@Override
	public CookingStyleType getCookingStyleType() {
		return CookingStyleType.CONVENTIONAL_OVEN;
	}

	
	/**
	 * Gets the cooking price associated with cooking in a regular oven.
	 * @return the cooking price of the CookingStyleType.
	 */
	@Override
	public double getCookingPrice() {
		return this.getCookingStyleType().getCookingPrice();
	}
	
	/**
	 * Sets the cookingStrategy and associated cookingPrice for the pizza and then updates the priceWithoutToppings and totalPrice.
	 * If there is already a cooking strategy selected, a message is given and false is returned.
	 * @param pizza to be cooked
	 * @return boolean for whether the pizza ended up getting cooked or not.
	 */
	@Override
	public boolean cook(AbstractPizza pizza) {
		if(pizza.hasCookingStrategy()) {
			System.out.println("The pizza provided already has been cooked/has a cooking strategy.");
			return false;
		}
		
		pizza.setCookingStrategy(new BrickOvenCookingStrategy());
		pizza.setCookingPrice(this.getCookingPrice());
		
		double pizzaBasePrice = pizza.getPriceWithoutToppings();
		double newPizzaPrice = pizzaBasePrice + this.getCookingPrice(); //add cooking price//
		pizza.setPriceWithoutToppings(newPizzaPrice);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

		
		pizza.updatePizzaPrice();
		return true;
	}

}
