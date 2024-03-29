import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String filePath = "src/input.txt";
        String picnicStr = readFile(filePath);
        String[] picnic = wordsToArray(picnicStr);
        int wordCount = wordCounter(picnic);
        System.out.printf("В файле перечислено %d слов\n", wordCount);
        String longestWord = longestWord(picnic);
        System.out.printf("Самое длинное слово в файле - %s\n", longestWord);
        numberOfOccurences(picnic);

    }



    //Чтение файла
    static String readFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    // StringBuilder to Array
    static String[] wordsToArray(String strings) {
        while (strings.contains("  ")) {
            String replace = strings.replace("  ", " ");
            strings = replace.toLowerCase();
        }
        return strings.split(" ");
    }

    //Подсчет слов

    static int wordCounter(String[] arrayStrings){
        return arrayStrings.length;
    }

    //Самое длинное слово

    static String longestWord(String[] arrayStrings){
        String longestWord = arrayStrings[0];
        for (String str: arrayStrings) {
            if (str.length() > longestWord.length()) {
                longestWord = str;
            }
        }
        return longestWord;
    }

    // Вычислить частоту слов
    private static void numberOfOccurences(String[] arrayStrings) {
        HashMap<String, Integer> occurrences = new HashMap<>();
        for (String str: arrayStrings) {
            occurrences.putIfAbsent(str, 1);
            occurrences.put(str, occurrences.get(str) + 1);
        }
        System.out.println("Количество повторений слов в тексте:");
        occurrences.forEach((key,value) -> System.out.println(key + " - " + value));
    }





}
