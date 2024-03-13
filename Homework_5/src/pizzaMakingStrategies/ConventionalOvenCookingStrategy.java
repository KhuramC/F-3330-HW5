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

	@Override
	public String toString() {
	    return "Conventional Oven Cooking Strategy";
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
	 * Sets the cookingStrategy and associated cookingPrice for the pizza and then updates the totalPrice.
	 * @param pizza to be cooked
	 * @return boolean for whether the cooking was successful(shouldn't really ever occur
	 */
	@Override
	public boolean cook(AbstractPizza pizza) {

		pizza.setCookingStrategy(new BrickOvenCookingStrategy());
		pizza.setCookingPrice(this.getCookingPrice());
		
		pizza.setTotalPrice(pizza.updatePizzaPrice());
		return true;
	}

}
