import java.util.*;

public class Compressor {
    static String compress(String s) {
        if (s.isEmpty())
            return "";
        StringBuilder out = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                count++;
            else {
                out.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        out.append(count).append(s.charAt(s.length() - 1));
        return out.toString();
    }

    static String decompress(String s) {
        StringBuilder out = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int num = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            if (i >= s.length())
                break;
            char ch = s.charAt(i++);
            for (int k = 0; k < num; k++)
                out.append(ch);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to compress:");
        String text = sc.nextLine();

        String comp = compress(text);
        String back = decompress(comp);

        System.out.println("Compressed:  " + comp);
        System.out.println("Decompressed:" + back);
        sc.close();
    }
}
