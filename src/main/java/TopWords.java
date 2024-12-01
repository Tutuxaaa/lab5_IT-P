import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "D:/projects/lab6/src/main/java/Harry_Potter_text.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Integer> topWords = new HashMap<>();

        scanner.useDelimiter("\\s");

        while (scanner.hasNext()) {
            String word = scanner.next().replaceAll("[^A-Za-z']", "").toLowerCase();
            if (word.isBlank()) {
                continue;
            }
            topWords.putIfAbsent(word, 0);
            topWords.put(word, topWords.get(word) + 1);
        }
        scanner.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(topWords.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int k = 0; k < 10; k++) {
            System.out.println((k + 1) + ": " + list.get(k).getKey() + " (повторений: " +list.get(k).getValue() + ")");
        }
    }
}