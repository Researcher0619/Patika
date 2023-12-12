import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner fruit = new Scanner(System.in);

        // Amount taken from each fruit
        double Pear_Kg, Apple_Kg, tomato_Kg, Banana_Kg, Eggplant_Kg;

        // Prices per each of the fruit
        double Pear_Price = 2.14, Apple_Price = 3.67, Tomato_Price = 1.11, Banana_Price = 0.95, Eggplnat_Price = 5.0;
        double Total_Price;

        // Total amount taken from pear
        System.out.print("Armut kilosunu giriniz: ");
        Pear_Kg = fruit.nextInt();

        // Total amount taken from apple
        System.out.print("Elma kilosunu giriniz: ");
        Apple_Kg = fruit.nextInt();

        // Total amount taken from tomato
        System.out.print("Domates kilosunu giriniz: ");
        tomato_Kg = fruit.nextInt();

        // Total amount taken from banana
        System.out.print("Muz kilosunu giriniz: ");
        Banana_Kg = fruit.nextInt();

        // Total amount taken from eggplant
        System.out.print("Patlıcan kilosunu giriniz: ");
        Eggplant_Kg = fruit.nextInt();

        Total_Price = (Pear_Kg * Pear_Price) + (Apple_Kg * Apple_Price) + (tomato_Kg * Tomato_Price) +
                (Banana_Kg * Banana_Price) + (Eggplant_Kg * Eggplnat_Price);

        System.out.println("Toplam fiyat = " + Total_Price + " TL");


    }
}