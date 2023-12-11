import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Create Variables
        int mat, fizik, kimya, turkce, tarih , muzik ;
        // We should import Scanner class in order to get the entries from the user

        // We named our Scanner class below
        Scanner Entries = new Scanner(System.in);

        // Now it is time to get entries from the user
        System.out.println("Matematik notunuzu giriniz : " );
        mat = Entries.nextInt();

        System.out.println("Fizik notunuzu giriniz : " );
        fizik = Entries.nextInt();

        System.out.println("Kimya notunuzu giriniz : " );
        kimya = Entries.nextInt();

        System.out.println("Türkçe notunuzu giriniz : " );
        turkce = Entries.nextInt();

        System.out.println("Tarih notunuzu giriniz : " );
        tarih = Entries.nextInt();

        System.out.println("Müzik notunuzu giriniz : " );
        muzik = Entries.nextInt();

        int toplam = (mat + fizik + kimya + turkce + tarih + muzik) ;
        
        double sonuc = (toplam) / 6.0 ;

        String durum = (sonuc > 60) ? "Sınıfı Geçti": "Sınıfta Kaldı";

        System.out.println("Ortalamanız: "+ sonuc+" " +durum);
         









    }
}