import java.util.*;

public class FirstNonRepeating {
    public static Character firstNonRepeating(String text) {
        int[] freq = new int[256];
        int n = text.length();

        for (int i = 0; i < n; i++) {
            freq[text.charAt(i)]++;
        }
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (freq[c] == 1)
                return c;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();
        Character ans = firstNonRepeating(s);
        System.out.println("First non-repeating: " + (ans == null ? "None" : ans));
        sc.close();
    }
}
