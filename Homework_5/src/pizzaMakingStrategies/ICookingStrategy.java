package pizzaMakingStrategies;
import pizzas.*;

public interface ICookingStrategy {
	
	/* sets the cookingPrice,
	cookingStrategy and updates the pizzaPrice of the pizza that is being cooked and passed as a
	parameter. There could only be one cooking strategy selected for a pizza. The cooking strategy
	changes the pizza price */
	public boolean cook(AbstractPizza pizza);

}
