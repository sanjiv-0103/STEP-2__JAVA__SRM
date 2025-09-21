import java.util.*;

public class UniqueCharFrequency {
    public static char[] uniqueCharacters(String text) {
        int n = text.length();
        char[] temp = new char[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            boolean seen = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    seen = true;
                    break;
                }
            }
            if (!seen)
                temp[count++] = c;
        }
        return Arrays.copyOf(temp, count);
    }

    public static String[][] frequencyByUniques(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++)
            freq[text.charAt(i)]++;

        char[] uniques = uniqueCharacters(text);
        String[][] out = new String[uniques.length][2];
        for (int i = 0; i < uniques.length; i++) {
            out[i][0] = Character.toString(uniques[i]);
            out[i][1] = Integer.toString(freq[uniques[i]]);
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();

        String[][] table = frequencyByUniques(s);
        System.out.printf("%-8s %-8s%n", "Char", "Freq");
        System.out.println("----------------");
        for (String[] row : table) {
            String display = row[0].equals(" ") ? "[space]" : row[0];
            System.out.printf("%-8s %-8s%n", display, row[1]);
        }
        sc.close();
    }
}
