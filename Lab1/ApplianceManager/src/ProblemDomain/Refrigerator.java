package ProblemDomain;

public class Refrigerator extends Appliance {
    private int numberOfDoors; // Number of doors (2, 3, or 4)
    private double height; // Height in inches
    private double width; // Width in inches

    public Refrigerator(String itemNumber, String brand, int quantity, int wattage, String color, double price, int numberOfDoors, double height, double width) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.numberOfDoors = numberOfDoors;
        this.height = height;
        this.width = width;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return String.format("Item Number: %s\nBrand: %s\nQuantity: %d\nWattage: %d\nColor: %s\nPrice: %.2f\nNumber of Doors: %d\nHeight: %.2f\nWidth: %.2f",
                getItemNumber(), getBrand(), getQuantity(), getWattage(), getColor(), getPrice(), numberOfDoors, height, width);
    }
}
