import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        // Firs off, we should name our Scanner class in order to get the weight and height values from the user
        Scanner entry = new Scanner(System.in);

        // Now let's get the height value from the user
        System.out.print("Lütfen boyunuzu (metre cinsinde) giriniz : ");
        double height;
        height = entry.nextDouble();

        // Now let's get the weight value from the user
         System.out.print("Lütfen kilonuzu giriniz : ");
        int weight = entry.nextInt();

         // Calculation of BMI
        double  BMI = weight / (height * height);

        System.out.print("Vücut Kitle İndeksiniz: "+ BMI);








    }
}