package pizzaMakingStrategies;

/**
 * An enum for the different ways to cook a pizza at FakeSpeare. The associated extra cooking price is given for each type.
 */
public enum CookingStyleType {
	
	MICROWAVE(1.0),
	CONVENTIONAL_OVEN(8.0),
	BRICK_OVEN(10.0);

	private double cookingPrice;
	

	CookingStyleType(double cookingPrice) {
		this.cookingPrice = cookingPrice;
	}
	

	public double getCookingPrice() {
		return cookingPrice;
	}
}
