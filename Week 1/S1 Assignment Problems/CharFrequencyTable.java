import java.util.*;

public class CharFrequencyTable {
    public static String[][] charFrequencies(String text) {
        int[] freq = new int[256];
        int n = text.length();
        for (int i = 0; i < n; i++)
            freq[text.charAt(i)]++;

        int k = 0;
        for (int i = 0; i < 256; i++)
            if (freq[i] > 0)
                k++;

        String[][] out = new String[k][2];
        int idx = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                out[idx][0] = Character.toString((char) i);
                out[idx][1] = Integer.toString(freq[i]);
                idx++;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();

        String[][] table = charFrequencies(s);
        System.out.printf("%-8s %-8s%n", "Char", "Freq");
        System.out.println("----------------");
        for (String[] row : table) {
            String display = row[0].equals(" ") ? "[space]" : row[0];
            System.out.printf("%-8s %-8s%n", display, row[1]);
        }
        sc.close();
    }
}
