public class Main {
    public static void main(String[] args) {

        int[] myArray = {0, 20, 20, 10, 10, 20, 5, 20};

        for (int i = 0; i < myArray.length; i++) {
            int count = 0; // Reset count for each new number
            for(int j = 0; j < myArray.length; j++){
                if(myArray[i] == myArray[j]){
                    count++;
                }
            }
            System.out.println("The number " + myArray[i] + " repeated "  + count + " times");
        }
    }
}
