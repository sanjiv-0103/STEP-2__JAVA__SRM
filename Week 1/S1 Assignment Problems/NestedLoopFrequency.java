import java.util.*;

public class NestedLoopFrequency {
    public static String[] nestedLoopFrequencies(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0')
                continue;
            int count = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    count++;
                    chars[j] = '0';
                }
            }
            freq[i] = count;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                list.add(chars[i] + " : " + freq[i]);
            }
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();

        String[] result = nestedLoopFrequencies(s);
        System.out.println("Character frequencies (nested loops):");
        for (String line : result)
            System.out.println(line);
        sc.close();
    }
}
