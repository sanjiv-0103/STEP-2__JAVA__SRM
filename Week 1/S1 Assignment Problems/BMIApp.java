import java.util.*;

public class BMIApp {
    public static String[] computeBMI(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weightKg / (heightM * heightM);

        String status;
        if (bmi < 18.5)
            status = "Underweight";
        else if (bmi < 25)
            status = "Normal";
        else if (bmi < 30)
            status = "Overweight";
        else
            status = "Obese";

        return new String[] {
                String.format(Locale.US, "%.1f cm", heightCm),
                String.format(Locale.US, "%.1f kg", weightKg),
                String.format(Locale.US, "%.1f", bmi),
                status
        };
    }

    public static String[][] buildReport(double[][] hw) {
        String[][] out = new String[hw.length][4];
        for (int i = 0; i < hw.length; i++) {
            out[i] = computeBMI(hw[i][0], hw[i][1]);
        }
        return out;
    }

    public static void displayTable(String[][] data) {
        System.out.printf("%-8s %-12s %-12s %-8s %-12s%n",
                "Person", "Height", "Weight", "BMI", "Status");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-8d %-12s %-12s %-8s %-12s%n",
                    (i + 1), data[i][0], data[i][1], data[i][2], data[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hw = new double[10][2];

        System.out.println("Enter weight (kg) and height (cm) for 10 persons:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " weight (kg): ");
            hw[i][0] = sc.nextDouble();
            System.out.print("Person " + (i + 1) + " height (cm): ");
            hw[i][1] = sc.nextDouble();
        }
        String[][] report = buildReport(hw);
        displayTable(report);
        sc.close();
    }
}
