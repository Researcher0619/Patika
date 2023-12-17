import java.util.Scanner;

public class Main {
    static boolean isPalindrom(int number) {
        int tempNum = number;
        int reverseNum = 0;
        int lastNum;

        while (tempNum != 0) {
            lastNum = tempNum % 10;
            reverseNum = (reverseNum * 10) + lastNum;
            tempNum /= 10;

        }
        if (number == reverseNum)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrom(10));

    }
}