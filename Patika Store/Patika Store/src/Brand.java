import java.util.Scanner;
import java.util.TreeSet;

// Class representing a Brand with comparable capability
public class Brand implements Comparable<Brand>{
    private int id;             // Unique identifier for the brand
    private String name;        // Name of the brand
    private static int idCounter = 1;   // Counter to assign unique IDs
    private Scanner scan = new Scanner(System.in);  // Scanner object for user input
    private static TreeSet<Brand> brandList = new TreeSet<>();   // TreeSet to store a sorted list of brands

    // Parameterized constructor to create a brand with a given name
    public Brand(String name) {
        this.id = idCounter++;  // Assign a unique ID to the brand
        this.name = name;       // Set the name of the brand
    }

    // Default constructor
    public Brand(){

    }

    // Getter method for retrieving the brand ID
    public int getId() {
        return id;
    }

    // Setter method for setting the brand ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter method for retrieving the brand name
    public String getName() {
        return name;
    }

    // Setter method for setting the brand name
    public void setName(String name) {
        this.name = name;
    }

    // Static block to initialize a set of default brands
    static {
        System.out.println("--BRANDS--");
        brandList.add(new Brand("Samsung"));
        brandList.add(new Brand("Lenovo"));
        brandList.add(new Brand("Apple"));
        brandList.add(new Brand("Huawei"));
        brandList.add(new Brand("Casper"));
        brandList.add(new Brand("Asus"));
        brandList.add(new Brand("Hp"));
        brandList.add(new Brand("Xiaomi"));
        brandList.add(new Brand("Monster"));
    }

    // Implementation of the compareTo method for brand comparison
    @Override
    public int compareTo(Brand o) {
        return this.name.compareTo(o.getName());
    }

    // Method to print the list of brands
    public void printBrand() {
        for (Brand brand : brandList){
            System.out.println("- " + brand.getName());
        }
    }
}
