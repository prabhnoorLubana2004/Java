package ProblemDomain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ApplianceManager {
    private List<Appliance> appliances;

    public ApplianceManager() {
        appliances = new ArrayList<>();
        loadAppliances(); // Load appliances from file
    }

    public void displayMenu() {
        System.out.println("Welcome to Modern Appliances!");
        System.out.println("How may we assist you?");
        System.out.println("1 – Check out appliance");
        System.out.println("2 – Find appliances by brand");
        System.out.println("3 – Display appliances by type");
        System.out.println("4 – Produce random appliance list");
        System.out.println("5 – Save & exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    checkoutAppliance(scanner);
                    break;
                case 2:
                    findAppliancesByBrand(scanner);
                    break;
                case 3:
                    displayAppliancesByType(scanner);
                    break;
                case 4:
                    produceRandomApplianceList(scanner);
                    break;
                case 5:
                    saveAppliances();
                    running = false; // Exit the loop
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private void loadAppliances() {
        String filename = "appliances.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String itemNumber = parts[0];
                String brand = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int wattage = Integer.parseInt(parts[3]);
                String color = parts[4];
                double price = Double.parseDouble(parts[5]);

                switch (itemNumber.charAt(0)) {
                    case '1':
                        // Refrigerator
                        int numberOfDoors = Integer.parseInt(parts[6]);
                        double height = Double.parseDouble(parts[7]);
                        double width = Double.parseDouble(parts[8]);
                        appliances.add(new Refrigerator(itemNumber, brand, quantity, wattage, color, price, numberOfDoors, height, width));
                        break;
                    case '2':
                        // Vacuum
                        String grade = parts[6];
                        String batteryVoltage = parts[7];
                        appliances.add(new Vacuum(itemNumber, brand, quantity, wattage, color, price, grade, batteryVoltage));
                        break;
                    case '3':
                        // Microwave
                        double capacity = Double.parseDouble(parts[6]);
                        String roomType = parts[7];
                        appliances.add(new Microwave(itemNumber, brand, quantity, wattage, color, price, capacity, roomType));
                        break;
                    case '4':
                    case '5':
                        // Dishwasher
                        String feature = parts[6];
                        String soundRating = parts[7];
                        appliances.add(new Dishwasher(itemNumber, brand, quantity, wattage, color, price, feature, soundRating));
                        break;
                    default:
                        System.out.println("Unknown appliance type for item number: " + itemNumber);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading appliances file: " + e.getMessage());
        }
    }

    private void checkoutAppliance(Scanner scanner) {
        System.out.print("Enter the item number of an appliance: ");
        String itemNumber = scanner.nextLine();
        for (Appliance appliance : appliances) {
            if (appliance.getItemNumber().equals(itemNumber)) {
                if (appliance.getQuantity() > 0) {
                    appliance.setQuantity(appliance.getQuantity() - 1);
                    System.out.println("Appliance \"" + itemNumber + "\" has been checked out.");
                    return;
                } else {
                    System.out.println("The appliance is not available to be checked out.");
                    return;
                }
            }
        }
        System.out.println("No appliances found with that item number.");
    }

    private void findAppliancesByBrand(Scanner scanner) {
        System.out.print("Enter brand to search for: ");
        String brand = scanner.nextLine();
        System.out.println("Matching Appliances:");
        for (Appliance appliance : appliances) {
            if (appliance.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(appliance);
            }
        }
    }

    private void displayAppliancesByType(Scanner scanner) {
        System.out.println("Appliance Types");
        System.out.println("1 – Refrigerators");
        System.out.println("2 – Vacuums");
        System.out.println("3 – Microwaves");
        System.out.println("4 – Dishwashers");
        System.out.print("Enter type of appliance: ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (type) {
        case 1:
            // Display Refrigerators
            System.out.print("Enter number of doors: 2 (double door), 3 (three doors) or 4 (four doors): ");
            int doors = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Matching refrigerators:");
            for (Appliance appliance : appliances) {
                if (appliance instanceof Refrigerator) {
                    Refrigerator fridge = (Refrigerator) appliance;
                    if (fridge.getNumberOfDoors() == doors) {
                        System.out.println(appliance);
                    }
                }
            }
            break;
        case 2:
            // Display Vacuums
            System.out.print("Enter battery voltage value (18 V for Low, 24 V for High): ");
            String voltage = scanner.nextLine();
            System.out.println("Matching vacuums:");
            for (Appliance appliance : appliances) {
                if (appliance instanceof Vacuum) {
                    Vacuum vacuum = (Vacuum) appliance;
                    if (((String) vacuum.getBatteryVoltage()).equalsIgnoreCase(voltage)) {
                        System.out.println(appliance);
                    }
                }
            }
            break;
        case 3:
            // Display Microwaves
            System.out.print("Room where the microwave will be installed (K for Kitchen, W for Work Site): ");
            String roomType = scanner.nextLine();
            System.out.println("Matching microwaves:");
            for (Appliance appliance : appliances) {
                if (appliance instanceof Microwave) {
                    Microwave microwave = (Microwave) appliance;
                    if (((String) microwave.getRoomType()).equalsIgnoreCase(roomType)) {
                        System.out.println(appliance);
                    }
                }
            }
            break;
        case 4:
            // Display Dishwashers
            System.out.print("Enter the sound rating of the dishwasher (Qt for Quietest, Qr for Quieter, Qu for Quiet, M for Moderate): ");
            String soundRating = scanner.nextLine();
            System.out.println("Matching dishwashers:");
            for (Appliance appliance : appliances) {
                if (appliance instanceof Dishwasher) {
                    Dishwasher dishwasher = (Dishwasher) appliance;
                    if (((String) dishwasher.getSoundRating()).equalsIgnoreCase(soundRating)) {
                        System.out.println(appliance);
                    }
                }
            }
            break;
        default:
            System.out.println("Invalid appliance type.");
    }
}


    private void produceRandomApplianceList(Scanner scanner) {
        System.out.print("Enter number of appliances: ");
        int count = scanner.nextInt();
        Random rand = new Random();
        System.out.println("Random appliances:");
        for (int i = 0; i < count; i++) {
            int index = rand.nextInt(appliances.size());
            System.out.println(appliances.get(index));
        }
    }

    private void saveAppliances() {
        String filename = "appliances.txt";
        try (FileWriter writer = new FileWriter(filename)) {
            for (Appliance appliance : appliances) {
                writer.write(appliance.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving appliances file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ApplianceManager manager = new ApplianceManager();
        manager.run();
    }
}

