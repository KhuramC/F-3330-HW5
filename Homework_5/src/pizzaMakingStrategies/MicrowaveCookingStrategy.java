package pizzaMakingStrategies;

import pizzas.AbstractPizza;

/**
 * A cooking Strategy for using the microwave that implements ICookingStrategy. The cooking price for
 * the microwave is defined in the CookingStyleType.
 */
public class MicrowaveCookingStrategy implements ICookingStrategy {

	
	/**
	 * Default Constructor to create an instance.
	 */
	public MicrowaveCookingStrategy() {
	}

	

	/**
	 * Returns the associated CookingStyleType of microwave cooking.
	 * @return MICROWAVE enum
	 */
	@Override
	public CookingStyleType getCookingStyleType() {
		return CookingStyleType.MICROWAVE;
	}

	
	/**
	 * Gets the cooking price associated with cooking in a brick oven.
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
