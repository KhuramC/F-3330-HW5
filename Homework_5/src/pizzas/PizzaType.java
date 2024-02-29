package pizzas;

public enum PizzaType {
	HAWAIIAN(3.00),
	MARGHERITA(2.50),
	SUPREME(3.50),
	VEGETARIAN(1.50);
	
	private double toppingPrice;

    // Constructor
    PizzaType(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    // Getter for toppingPrice
    public double getToppingPrice() {
        return toppingPrice;
    }

    // Setter for toppingPrice (not typical for enums)
    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }
}
		