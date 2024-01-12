import java.util.*;

// Class representing the PatikaStore with a menu for product management
public class PatikaStore {
    private boolean isMenu = true;  // Flag to control the menu loop

    Scanner scan = new Scanner(System.in);

    // Method to display the main menu
    public void showMenu() {
        while (isMenu) {
            System.out.println();
            System.out.println("--PatikaStore Product Management Panel--");
            System.out.println("1 - Notebook Operations");
            System.out.println("2 - Mobile Phone Operations");
            System.out.println("3 - List Brands");
            System.out.println("0 - Exit");
            System.out.println();
            System.out.print("Your choice: ");
            System.out.println();

            int select = scan.nextInt();

            switch (select) {
                case 0:
                    isMenu = false;  // Exit the menu loop
                    break;
                case 1:
                    Notebook notebook = new Notebook();
                    notebook.runMenu();  // Run notebook management menu
                    break;
                case 2:
                    MobilePhone phone = new MobilePhone();
                    phone.runMenu();  // Run mobile phone management menu
                    break;
                case 3:
                    Brand brand = new Brand();
                    brand.printBrand();  // Print the list of brands
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
