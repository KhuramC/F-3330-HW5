package pizzaManagement;
import pizzas.*;

public class PizzaCookingFactory {

	public PizzaCookingFactory() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * creates an AbstractPizza instance and
	 * instantiates it according to the pizzaType parameter. It also sets the pizzaOrderID of the pizza
	 * using the current orderIDCounter of the pizza. The orderIDCounter will be incremented and
	 * assigned automatically on every creation of pizza, to assign unique pizza order IDs.
	 * @param pizzaType
	 * @return pizza
	 */
	public AbstractPizza createPizza(PizzaType pizzaType) {
		AbstractPizza pizza = null;
		int orderIDCounter = AbstractPizza.getOrderIDCounter();
		
		switch(pizzaType) {
		case MARGHERITA:
			pizza = new MargheritaPizza(orderIDCounter);
			break;
		case HAWAIIAN:
			pizza = new HawaiianPizza(orderIDCounter);
			break;
		case SUPREME:
			pizza = new SupremePizza(orderIDCounter);
			break;
		case VEGETARIAN:
			pizza = new VegetarianPizza(orderIDCounter);
			break;
		}
		
		if (pizza != null) {
            pizza.setPizzaOrderID(orderIDCounter);
        }
		
		return pizza;
	}
}
