import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the paragraph that you will see which mostly common words are used.");
        String textContent = scan.nextLine();
        textContent = textContent.replaceAll("\\.","");
        System.out.println(textContent);

        // Convert text to lowercase to eliminate lowercase/uppercase distinction
        textContent = textContent.toLowerCase();

        HashMap<String, Integer> wordsMap = new HashMap<>();

        // Split the text using "\\s+" to get individual words
        String[] words = textContent.split(" ");

        // Let's count each word in the HashMap
        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                int count = wordsMap.get(word);
                wordsMap.put(word, count + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }

        // Find the most frequent word
        String mostFrequentWord = "";
        int maxCount = 0;

        Iterator<Map.Entry<String, Integer>> iterator = wordsMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String word = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                mostFrequentWord = word;
                maxCount = count;
            }
        }

        // Display the result
        System.out.println("Most frequent word: " + mostFrequentWord);
        System.out.println("Count: " + maxCount);
    }
}
