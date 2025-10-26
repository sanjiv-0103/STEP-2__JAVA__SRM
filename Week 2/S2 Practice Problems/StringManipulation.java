import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String trimmed = text.trim();
        String replaced = trimmed.replace(" ", "_");
        String noDigits = replaced.replaceAll("\\d", "");
        String[] words = noDigits.split("_");
        String joined = String.join(" | ", words);

        System.out.println("Trimmed: " + trimmed);
        System.out.println("Replaced spaces: " + replaced);
        System.out.println("Removed digits: " + noDigits);
        System.out.println("Words: " + Arrays.toString(words));
        System.out.println("Joined: " + joined);
        sc.close();
    }
}