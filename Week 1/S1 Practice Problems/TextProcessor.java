import java.util.*;

public class TextProcessor {

    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return sb.toString().trim();
    }

    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int sentenceCount = text.split("[.!?]").length;
        int charCount = text.replace(" ", "").length();

        String longestWord = "";
        Map<Character, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
            for (char c : word.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }

        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (var entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                mostCommonChar = entry.getKey();
                maxFreq = entry.getValue();
            }
        }

        System.out.println("\n=== TEXT ANALYSIS ===");
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Characters (no spaces): " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: " + mostCommonChar);
    }

    public static String[] getWordsSorted(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z ]", "");
        String[] words = cleaned.split("\\s+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph of text: ");
        String paragraph = scanner.nextLine();

        paragraph = cleanInput(paragraph);
        analyzeText(paragraph);

        String[] sortedWords = getWordsSorted(paragraph);
        System.out.println("\nWords in Alphabetical Order:");
        for (String word : sortedWords) {
            System.out.println(word);
        }

        System.out.print("\nEnter a word to search: ");
        String searchWord = scanner.nextLine();
        boolean found = Arrays.asList(sortedWords).contains(searchWord);
        System.out.println("Word found? " + (found ? "Yes" : "No"));

        scanner.close();
    }
}