import java.util.*;

public class PasswordTool {
    static boolean hasUpper(String s) {
        for (char c : s.toCharArray())
            if (c >= 'A' && c <= 'Z')
                return true;
        return false;
    }

    static boolean hasLower(String s) {
        for (char c : s.toCharArray())
            if (c >= 'a' && c <= 'z')
                return true;
        return false;
    }

    static boolean hasDigit(String s) {
        for (char c : s.toCharArray())
            if (c >= '0' && c <= '9')
                return true;
        return false;
    }

    static boolean hasSpecial(String s) {
        for (char c : s.toCharArray()) {
            if ((c >= 33 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 126))
                return true;
        }
        return false;
    }

    static String strength(String p) {
        int score = 0;
        if (p.length() >= 8)
            score++;
        if (hasUpper(p))
            score++;
        if (hasLower(p))
            score++;
        if (hasDigit(p))
            score++;
        if (hasSpecial(p))
            score++;

        if (score <= 2)
            return "Weak";
        if (score == 3 || score == 4)
            return "Medium";
        return "Strong";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a password:");
        String p = sc.nextLine();
        System.out.println("Strength: " + strength(p));
        sc.close();
    }
}
