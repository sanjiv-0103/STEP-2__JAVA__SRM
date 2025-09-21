import java.util.*;

public class WordsWithLength {
    public static int customLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return count;
    }

    public static String[] manualSplit(String s) {
        int len = customLength(s);
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c != ' ')
                sb.append(c);
            else if (sb.length() > 0) {
                words.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0)
            words.add(sb.toString());
        return words.toArray(new String[0]);
    }

    public static String[][] wordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(customLength(words[i]));
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = manualSplit(text);
        String[][] table = wordLengthTable(words);

        System.out.printf("%-15s %-5s%n", "Word", "Len");
        for (String[] row : table) {
            System.out.printf("%-15s %-5d%n", row[0], Integer.parseInt(row[1]));
        }
        sc.close();
    }
}
