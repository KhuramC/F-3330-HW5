package pizzaMakingStrategies;
import pizzas.AbstractPizza;

public interface ICookingStrategy {
	
	
	/**
	 * The method to cook a pizza a certain way (adding some extra dollars to the price of the pizza).
	 * @param pizza to be cooked
	 * @return boolean whether cooking was successful.
	 */
	public boolean cook(AbstractPizza pizza);
	
	/**
	 * The method to get the corresponding CookingStyleType Enum for a CookingStrategy.
	 * @return the corresponding CookingStyleType
	 */
	public CookingStyleType getCookingStyleType();
	
	/**
	 * The method to get the corresponding cooking price for a CookingStrategy.
	 * @return
	 */
	public double getCookingPrice();

}
