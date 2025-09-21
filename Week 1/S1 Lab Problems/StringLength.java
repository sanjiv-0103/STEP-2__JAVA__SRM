import java.util.*;

public class StringLength {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.next();

        int myLen = customLength(input);
        int builtinLen = input.length();

        System.out.println("Custom length(): " + myLen);
        System.out.println("Built-in length(): " + builtinLen);
        sc.close();
    }
}
