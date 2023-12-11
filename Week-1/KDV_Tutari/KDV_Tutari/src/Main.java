import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        double fee, vat_Amount, fee_With_Vat,  vat_Rate_1 = 1.8 , vat_Rate_2 = 0.08;
        // We named our Scanner class below
        Scanner money = new Scanner(System.in);

        System.out.print("Enter the fee amount: ");
        fee = money.nextDouble();

            //if the fee is less than 1000
        if(fee > 0 && fee < 1000){
            vat_Amount = (fee * vat_Rate_1 );
            fee_With_Vat = ( fee + vat_Amount ) ;

            System.out.println("Fee without Value Added Tax : " + fee);
            System.out.println("Value Added Tax Rate : " + vat_Rate_1);
            System.out.println("Value Added Tax Amount : " + vat_Amount);
            System.out.println("Fee with Value Added Tax Amount : " + fee_With_Vat);


            //if the fee is less than 1000
        }else {
            vat_Amount = (fee * vat_Rate_2 );
            fee_With_Vat = ( fee + vat_Amount ) ;

            System.out.println("Fee without Value Added Tax : " + fee);
            System.out.println("Value Added Tax Rate : " + vat_Rate_2);
            System.out.println("Value Added Tax Amount : " + vat_Amount);
            System.out.println("Fee with Value Added Tax Amount : " + fee_With_Vat);
        }

    }
}