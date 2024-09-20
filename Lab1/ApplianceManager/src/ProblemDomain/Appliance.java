package ProblemDomain;

public abstract class Appliance {
    private String itemNumber;
    private String brand;
    private int quantity;
    private int wattage;
    private String color;
    private double price;

    public Appliance(String itemNumber, String brand, int quantity, int wattage, String color, double price) {
        this.itemNumber = itemNumber;
        this.brand = brand;
        this.quantity = quantity;
        this.wattage = wattage;
        this.color = color;
        this.price = price;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public String getBrand() {
        return brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWattage() {
        return wattage;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public abstract String toString();
}
