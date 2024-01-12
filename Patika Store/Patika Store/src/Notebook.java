import java.util.ArrayList;
import java.util.Scanner;

// Notebook class extending Product and implementing Operation interface
public class Notebook extends Product implements Operation {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Notebook> notebooks = new ArrayList<>();

    // Parameterized constructor to initialize notebook properties
    public Notebook(int id, int price, double discountRate, int stock, String productName, String brand,
                    int memorySize, double screenSize, int ram) {
        super(id, price, discountRate, stock, productName, brand, memorySize, screenSize, ram);
    }

    // Default constructor
    public Notebook() {
        super();
    }

    // Static block to initialize a set of default notebooks
    static {
        notebooks.add(new Notebook(1, 25000, 0.25, 50, "M1", "Apple", 512, 13, 8));
        notebooks.add(new Notebook(2, 20000, 0.10, 75, "MateBook", "Huawei", 512, 14, 8));
        notebooks.add(new Notebook(3, 20000, 0.10, 25, "Nirvana", "Casper", 512, 14, 8));
    }

    // Override method to display the list of notebooks
    @Override
    public void showProductList() {
        System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s  %-6s%n",
                "ID", "Product Name", "Price", "Brand", "Storage", "Screen", "RAM", "Stock", "Discount");

        for (Notebook notebook : notebooks) {
            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s  %-6s%n",
                    notebook.getId(), notebook.getProductName(), notebook.getPrice(), notebook.getBrand(),
                    notebook.getMemorySize(), notebook.getScreenSize(), notebook.getRam(), notebook.getStock(),
                    notebook.getDiscountRate());
        }
    }

    // Override method to run the menu for notebook management
    @Override
    public void runMenu() {
        Notebook notebookManager = new Notebook();

        while (true) {
            System.out.println("\nNotebook Management Panel");
            System.out.println("1- List Notebooks");
            System.out.println("2- Add Notebook");
            System.out.println("3- Delete Notebook");
            System.out.println("4- Filter by ID");
            System.out.println("5- Filter by Brand");
            System.out.println("0- Main Menu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    notebookManager.showProductList();
                    break;
                case 2:
                    notebookManager.addProduct();
                    break;
                case 3:
                    notebookManager.deleteProduct();
                    break;
                case 4:
                    notebookManager.filterByProductID();
                    break;
                case 5:
                    notebookManager.filterByProductBrand();
                    break;
                case 0:
                    System.out.println("Returning to the main menu.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Override method to filter notebooks by brand
    @Override
    public void filterByProductBrand() {
        System.out.println("Enter the brand you want to filter:");
        String filterBrand = scanner.next();

        System.out.println("Filter results");
        for (Notebook notebook : notebooks) {
            if (notebook.getBrand().equalsIgnoreCase(filterBrand)) {
                System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s%n",
                        notebook.getId(), notebook.getProductName(), notebook.getPrice(), notebook.getBrand(),
                        notebook.getMemorySize(), notebook.getScreenSize(), notebook.getRam());
            }
        }
    }

    // Override method to filter notebooks by ID
    @Override
    public void filterByProductID() {
        System.out.println("Enter the ID you want to filter:");
        int filterID = scanner.nextInt();

        System.out.println("Filter results");
        for (Notebook notebook : notebooks) {
            if (notebook.getId() == filterID) {
                System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s%n",
                        notebook.getId(), notebook.getProductName(), notebook.getPrice(), notebook.getBrand(),
                        notebook.getMemorySize(), notebook.getScreenSize(), notebook.getRam());
            }
        }
    }

    // Override method to add a new notebook to the list
    @Override
    public void addProduct() {
        System.out.println("Please enter a new ID:");
        int newNotebookID = scanner.nextInt();
        scanner.nextLine();

        if (findNotebookById(newNotebookID) == null) {
            System.out.println("Please enter the product name:");
            String newNotebookName = scanner.nextLine();

            System.out.println("Please enter the brand:");
            String newNotebookBrand = scanner.nextLine();

            System.out.println("Please enter the price:");
            int newNotebookPrice = scanner.nextInt();

            System.out.println("Please enter the discount rate:");
            double newNotebookDiscount = scanner.nextDouble();

            System.out.println("Please enter the stock information:");
            int newNotebookStock = scanner.nextInt();

            System.out.println("Please enter the storage size:");
            int newNotebookMemorySize = scanner.nextInt();

            System.out.println("Please enter the screen size:");
            double newNotebookScreenSize = scanner.nextDouble();

            System.out.println("Please enter the RAM (in GB):");
            int newNotebookRam = scanner.nextInt();

            notebooks.add(new Notebook(newNotebookID, newNotebookPrice, newNotebookDiscount, newNotebookStock,
                    newNotebookName, newNotebookBrand, newNotebookMemorySize, newNotebookScreenSize, newNotebookRam));

            System.out.println("New notebook added.");
            System.out.println("----------------------");

        } else {
            System.out.println("This product has already been added. Please try again.");
        }
    }

    // Override method to delete a notebook from the list
    @Override
    public void deleteProduct() {
        System.out.println("Enter the ID of the product you want to delete:");
        int deleteSelection = scanner.nextInt();

        Notebook notebookToDelete = findNotebookById(deleteSelection);

        if (notebookToDelete != null) {
            notebooks.remove(notebookToDelete);
            System.out.println("Product deleted.");
        } else {
            System.out.println("ID not found.");
        }
    }

    // Method to find a notebook by its ID
    private Notebook findNotebookById(int id) {
        for (Notebook notebook : notebooks) {
            if (notebook.getId() == id) {
                return notebook;
            }
        }
        return null;
    }
}
