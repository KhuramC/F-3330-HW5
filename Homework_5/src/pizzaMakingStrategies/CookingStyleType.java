package pizzaMakingStrategies;

public enum CookingStyleType {
	
	MICROWAVE(1.0),
	CONVENTIONAL_OVEN(8.0),
	BRICK_OVEN(10.0);

	private double cookingPrice;
	
	//Constructor//
	CookingStyleType(double cookingPrice) {
		this.cookingPrice = cookingPrice;
	}
	
	//Getter//
	public double getCookingPrice() {
		return cookingPrice;
	}
}
