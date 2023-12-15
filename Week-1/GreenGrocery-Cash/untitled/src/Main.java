import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        double pear=2.14, apple=3.67, tomato=1.11, banana=0.95, eggplant=5.00, total=0.0;

        Scanner inp = new Scanner(System.in);


        // Toplam değerini 0 başlatıp her seferinde yeni fiyatı üzerine ekleyerek devam ettim
        // Scanner kullanarak kullanıcıdan değerleri aldım

        System.out.print("Armut Kac Kilo ? : ");
        total = total + inp.nextDouble() * pear;

        System.out.print("Elma Kac Kilo ? : ");
        total = total + inp.nextDouble() * apple;

        System.out.print("Domates Kac Kilo ? : ");
        total = total + inp.nextDouble() * tomato;

        System.out.print("Muz Kac Kilo ? : ");
        total = total + inp.nextDouble() * banana;

        System.out.print("Patlican Kac Kilo ? : ");
        total = total + inp.nextDouble() * eggplant;

        System.out.print("Toplam Tutar : " +total);



    }
}