import java.util.ArrayList;
import java.util.Scanner;

// MobilePhone class extending Product and implementing Operation interface
public class MobilePhone extends Product implements Operation {
    private int batteryPower;   // Battery power of the mobile phone
    private String color;       // Color of the mobile phone
    private static Scanner scanner = new Scanner(System.in);   // Scanner object for user input
    static ArrayList<MobilePhone> phones = new ArrayList<>();   // ArrayList to store mobile phones

    // Parameterized constructor to initialize mobile phone properties
    public MobilePhone(int id, int price, double discountRate, int stock, String productName, String brand,
                       int memorySize, double screenSize, int ram, int batteryPower, String color) {
        super(id, price, discountRate, stock, productName, brand, memorySize, screenSize, ram);
        this.batteryPower = batteryPower;
        this.color = color;
    }

    // Default constructor
    public MobilePhone() {

    }

    // Getter method for retrieving the battery power
    public int getBatteryPower() {
        return batteryPower;
    }

    // Setter method for setting the battery power
    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    // Getter method for retrieving the color
    public String getColor() {
        return color;
    }

    // Setter method for setting the color
    public void setColor(String color) {
        this.color = color;
    }

    // Static block to initialize a set of default mobile phones
    static {
        phones.add(new MobilePhone(100, 30000, 0.1, 10, "Galaxy S23", "Samsung", 128, 6.1, 6, 4000, "Black"));
        phones.add(new MobilePhone(200, 25000, 0.2, 15, "iPhone 12", "Apple", 64, 6.1, 6, 4000, "Blue"));
    }

    // Override method to display the list of mobile phones
    @Override
    public void showProductList() {
        System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                "ID", "Product Name", "Price", "Brand", "Storage", "Screen", "RAM", "Battery", "Color", "Stock", "Discount");

        for (MobilePhone phone : phones) {
            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                    phone.getId(), phone.getProductName(), phone.getPrice(), phone.getBrand(), phone.getMemorySize(),
                    phone.getScreenSize(), phone.getRam(), phone.getBatteryPower(), phone.getColor(),
                    phone.getStock(), phone.getDiscountRate());
        }
    }

    // Override method to run the menu for mobile phone management
    @Override
    public void runMenu() {
        MobilePhone mobilePhoneManager = new MobilePhone();

        while (true) {
            System.out.println("\nMobile Phone Management Panel");
            System.out.println("1- List Mobile Phones");
            System.out.println("2- Add Mobile Phone");
            System.out.println("3- Delete Mobile Phone");
            System.out.println("4- Filter by ID");
            System.out.println("5- Filter by Brand");
            System.out.println("0- Main Menu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    mobilePhoneManager.showProductList();
                    break;
                case 2:
                    mobilePhoneManager.addProduct();
                    break;
                case 3:
                    mobilePhoneManager.deleteProduct();
                    break;
                case 4:
                    mobilePhoneManager.filterByProductID();
                    break;
                case 5:
                    mobilePhoneManager.filterByProductBrand();
                    break;
                case 0:
                    System.out.println("Returning to the main menu.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Override method to filter mobile phones by brand
    @Override
    public void filterByProductBrand() {
        System.out.println("Enter the brand you want to filter:");
        String filterBrand = scanner.next();

        System.out.println("Filter results:");
        for (MobilePhone phone : phones) {
            if (phone.getBrand().equalsIgnoreCase(filterBrand)) {
                System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                        phone.getId(), phone.getProductName(), phone.getPrice(), phone.getBrand(),
                        phone.getMemorySize(), phone.getScreenSize(), phone.getRam(), phone.getBatteryPower(),
                        phone.getColor(), phone.getStock(), phone.getDiscountRate());
            }
        }
    }

    // Override method to add a new mobile phone to the list
    @Override
    public void addProduct() {
        System.out.println("Please enter a new ID:");
        int newPhoneID = scanner.nextInt();
        scanner.nextLine();

        if (findPhoneById(newPhoneID) == null) {
            System.out.println("Please enter the product name:");
            String newPhoneName = scanner.nextLine();

            System.out.println("Please enter the brand:");
            String newPhoneBrand = scanner.nextLine();

            System.out.println("Please enter the price:");
            int newPhonePrice = scanner.nextInt();

            System.out.println("Please enter the discount rate:");
            double newPhoneDiscount = scanner.nextDouble();

            System.out.println("Please enter the stock information:");
            int newPhoneStock = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Please enter the storage size:");
            int newPhoneStorage = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Please enter the screen size:");
            double newPhoneScreenSize = scanner.nextDouble();

            System.out.println("Please enter the RAM (in GB):");
            int newPhoneRam = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Please enter the color:");
            String newPhoneColor = scanner.nextLine();

            System.out.println("Please enter the battery power:");
            int newPhoneBatterySize = scanner.nextInt();

            phones.add(new MobilePhone(newPhoneID, newPhonePrice, newPhoneDiscount, newPhoneStock, newPhoneName,
                    newPhoneBrand, newPhoneStorage, newPhoneScreenSize, newPhoneRam, newPhoneBatterySize, newPhoneColor));

            System.out.println("New mobile phone added.");
            System.out.println("----------------------");

        } else {
            System.out.println("This product has already been added. Please try again.");
        }
    }

    // Override method to delete a mobile phone from the list
    @Override
    public void deleteProduct() {
        System.out.println("Enter the ID of the product you want to delete:");
        int deleteSelection = scanner.nextInt();

        MobilePhone phoneToDelete = findPhoneById(deleteSelection);

        if (phoneToDelete != null) {
            phones.remove(phoneToDelete);
            System.out.println("Product deleted.");

        } else {
            System.out.println("ID not found.");
        }
    }

    // Override method to filter mobile phones by ID
    @Override
    public void filterByProductID() {
        System.out.println("Enter the ID you want to filter:");
        int filterID = scanner.nextInt();

        MobilePhone filteredPhone = findPhoneById(filterID);

        if (filteredPhone != null) {
            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s%n",
                    "ID", "Product Name", "Price", "Brand", "Storage", "Screen", "RAM", "Battery", "Color", "Stock", "Discount");

            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                    filteredPhone.getId(), filteredPhone.getProductName(), filteredPhone.getPrice(),
                    filteredPhone.getBrand(), filteredPhone.getMemorySize(), filteredPhone.getScreenSize(),
                    filteredPhone.getRam(), filteredPhone.getBatteryPower(), filteredPhone.getColor(),
                    filteredPhone.getStock(), filteredPhone.getDiscountRate());
        } else {
            System.out.println("No product found by ID.");
        }
    }

    // Method to find a mobile phone by its ID
    private MobilePhone findPhoneById(int id) {
        for (MobilePhone phone : phones) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }
}
