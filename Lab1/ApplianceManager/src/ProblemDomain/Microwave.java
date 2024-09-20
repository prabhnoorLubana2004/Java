package ProblemDomain;

public class Microwave extends Appliance {
    private double capacity;
    private String roomType;

    public Microwave(String itemNumber, String brand, int quantity, int wattage, String color, double price, double capacity, String roomType) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.capacity = capacity;
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return String.format("Item Number: %s\nBrand: %s\nQuantity: %d\nWattage: %d\nColor: %s\nPrice: %.2f\nCapacity: %.1f\nRoom Type: %s",
                getItemNumber(), getBrand(), getQuantity(), getWattage(), getColor(), getPrice(), capacity, roomType);
    }

	public Object getCapacity() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRoomType() {
		// TODO Auto-generated method stub
		return null;
	}
}
