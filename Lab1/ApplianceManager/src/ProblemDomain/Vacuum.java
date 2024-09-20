package ProblemDomain;

public class Vacuum extends Appliance {
    private String grade;
    private String batteryVoltage;

    public Vacuum(String itemNumber, String brand, int quantity, int wattage, String color, double price, String grade, String batteryVoltage) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.grade = grade;
        this.batteryVoltage = batteryVoltage;
    }

    @Override
    public String toString() {
        return String.format("Item Number: %s\nBrand: %s\nQuantity: %d\nWattage: %d\nColor: %s\nPrice: %.2f\nGrade: %s\nBattery Voltage: %s",
                getItemNumber(), getBrand(), getQuantity(), getWattage(), getColor(), getPrice(), grade, batteryVoltage);
    }

	public Object getGrade() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getBatteryVoltage() {
		// TODO Auto-generated method stub
		return null;
	}
}
