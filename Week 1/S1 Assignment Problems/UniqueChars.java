import java.util.*;

public class UniqueChars {
    public static int customLength(String s) {
        int i = 0;
        try {
            for (;; i++)
                s.charAt(i);
        } catch (IndexOutOfBoundsException e) {

        }
        return i;
    }

    public static char[] uniqueChars(String text) {
        int n = customLength(text);
        char[] temp = new char[n];
        int uniqueCount = 0;

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
                temp[uniqueCount++] = c;
        }
        return Arrays.copyOf(temp, uniqueCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();
        char[] uniques = uniqueChars(s);
        System.out.println("Unique characters:");
        for (char c : uniques)
            System.out.print(c + " ");
        System.out.println();
        sc.close();
    }
}
