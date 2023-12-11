import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        double fee, vat_Amount, fee_With_Vat,  vat_Rate = 0.18 ;
        // We named our Scanner class below
        Scanner money = new Scanner(System.in);

        System.out.print("Enter the fee amount: ");
        fee = money.nextDouble();

        //if the fee is greater than 1000
        if(fee > 1000){
            vat_Rate = 0.08;
        }
        vat_Amount = (fee * vat_Rate );
        fee_With_Vat = ( fee + vat_Amount ) ;
        System.out.println("Fee with Value Added Tax Amount : " + fee_With_Vat);

    }
}