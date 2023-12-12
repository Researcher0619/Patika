import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        double fee_per_km = 2.20;
        int distance;
        double total_sum;

        // We named the Scanner class to get the inputs from the user
        Scanner road = new Scanner(System.in);

        //Enter the distance you want to travel ?
        System.out.print("How many kilometers would you like to travel ? ");
        distance = road.nextInt();

        //Calculatin the total fee for total distance
        total_sum = 10 + (distance*fee_per_km);

        total_sum = (total_sum < 20 ) ? 20 : total_sum;

        System.out.print("Total Fee : " + total_sum + " TL");








    }
}
