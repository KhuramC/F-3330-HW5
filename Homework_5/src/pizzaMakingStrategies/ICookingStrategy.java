package pizzaMakingStrategies;
import pizzas.AbstractPizza;

/**
 * An interface that has methods to cook (i.e. assign a cooking strategy to) a pizza. It also has methods to return
 * the corresponding CookingStyleType and CookingPrice. 
 */
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
	 * @return the corresponding cooking price.
	 */
	public double getCookingPrice();

}
