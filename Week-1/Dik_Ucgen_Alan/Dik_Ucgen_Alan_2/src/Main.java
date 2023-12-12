import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Side 1 of the Triangle
        System.out.print("Enter the length of side 1: ");
        double side1 = scanner.nextDouble();

        // Side 2 of the Triangle
        System.out.print("Enter the length of side 2: ");
        double side2 = scanner.nextDouble();

        // Side 3 of the Triangle
        System.out.print("Enter the length of side 3: ");
        double side3 = scanner.nextDouble();

        // The Perimeter of The Triangle
        double u =  (side1 + side2 + side3) / 2.0 ;

        // The area of The Triangle
        double area = Math.sqrt(u * (u - side1) * (u - side2) * (u - side3));

        // Print The Area of The Triangle
        System.out.println("The area of the triangle : "+ area);
    }
}