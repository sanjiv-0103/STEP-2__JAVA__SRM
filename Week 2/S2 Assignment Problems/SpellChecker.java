import java.util.*;

public class SpellChecker {
    static int simpleDistance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int len = Math.min(a.length(), b.length());
        int diff = Math.abs(a.length() - b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
        }
        return diff;
    }

    static String bestSuggestion(String word, String[] dict) {
        String best = word;
        int bestScore = 9999;
        for (String d : dict) {
            int score = simpleDistance(word, d);
            if (score < bestScore) {
                bestScore = score;
                best = d;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String[] words = sc.nextLine().split("\\s+");

        System.out.println("Enter dictionary words (space-separated):");
        String[] dict = sc.nextLine().split("\\s+");

        for (String w : words) {
            boolean ok = false;
            for (String d : dict) {
                if (w.equalsIgnoreCase(d)) {
                    ok = true;
                    break;
                }
            }
            if (ok) {
                System.out.println(w + " -> OK");
            } else {
                System.out.println(w + " -> maybe: " + bestSuggestion(w, dict));
            }
        }
        sc.close();
    }
}
