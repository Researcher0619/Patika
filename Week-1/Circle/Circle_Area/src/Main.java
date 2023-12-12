import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int round ;
        double pi = 3.14, Per_of_Circle, area;
        double angle;

        //We described our Scanner Class get the input from the user
        Scanner input = new Scanner(System.in);

        //Let's get the round value from the user
        System.out.print("Please enter the round value: ");
        round = input.nextInt();

        // Let's get the center angle of the circle from the user
        System.out.print("Please enter the center angle of the circle: ");
        angle = input.nextDouble();

        // Area of the circle
        area = (pi * (round * round) * angle ) / 360 ;

        System.out.print(" Area of the circle : " + area);

    }
}