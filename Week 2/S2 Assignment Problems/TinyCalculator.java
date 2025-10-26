import java.util.*;

public class TinyCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an expression (e.g., 10 + 3 * 2). No parentheses. Left-to-right:");
        String[] parts = sc.nextLine().trim().split("\\s+");
        if (parts.length == 0) {
            System.out.println("Empty");
            sc.close();
            return;
        }

        int result = Integer.parseInt(parts[0]);
        for (int i = 1; i < parts.length - 1; i += 2) {
            String op = parts[i];
            int val = Integer.parseInt(parts[i + 1]);
            if (op.equals("+"))
                result += val;
            else if (op.equals("-"))
                result -= val;
            else if (op.equals("*"))
                result *= val;
            else if (op.equals("/"))
                result /= val;
            else {
                System.out.println("Unknown operator: " + op);
                break;
            }
        }
        System.out.println("Result: " + result);
        sc.close();
    }
}