package ProblemDomain;

public class Dishwasher extends Appliance {
    private String feature;
    private String soundRating;

    public Dishwasher(String itemNumber, String brand, int quantity, int wattage, String color, double price, String feature, String soundRating) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.feature = feature;
        this.soundRating = soundRating;
    }

    @Override
    public String toString() {
        return String.format("Item Number: %s\nBrand: %s\nQuantity: %d\nWattage: %d\nColor: %s\nPrice: %.2f\nFeature: %s\nSound Rating: %s",
                getItemNumber(), getBrand(), getQuantity(), getWattage(), getColor(), getPrice(), feature, soundRating);
    }

	public Object getFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getSoundRating() {
		// TODO Auto-generated method stub
		return null;
	}
}
