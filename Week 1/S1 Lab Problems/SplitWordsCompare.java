import java.util.*;

public class SplitWordsCompare {
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

    // split manually
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

    public static boolean arraysEqual(String[] a, String[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] manual = manualSplit(text);
        String[] builtin = text.split("\\s+");

        System.out.println("Manual split: " + Arrays.toString(manual));
        System.out.println("Built-in split: " + Arrays.toString(builtin));
        System.out.println("Equal? " + arraysEqual(manual, builtin));
        sc.close();
    }
}
