import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        for (char c : text.toCharArray()) {
            int code = (int) c;
            String type;
            if (Character.isUpperCase(c))
                type = "Uppercase Letter";
            else if (Character.isLowerCase(c))
                type = "Lowercase Letter";
            else if (Character.isDigit(c))
                type = "Digit";
            else
                type = "Special Character";

            System.out.println(c + " -> ASCII: " + code + " (" + type + ")");
            sc.close();
        }
    }
}
