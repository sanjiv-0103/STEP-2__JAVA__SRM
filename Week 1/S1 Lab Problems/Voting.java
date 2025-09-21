import java.util.*;

public class Voting {
    public static int[] randomAges(int n) {
        Random r = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = 10 + r.nextInt(90);
        }
        return ages;
    }

    public static String[][] canVoteTable(int[] ages) {
        String[][] table = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            table[i][0] = String.valueOf(ages[i]);
            table[i][1] = (ages[i] >= 18) ? "true" : "false";
        }
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-5s %-10s%n", "Age", "CanVote");
        for (String[] row : table) {
            System.out.printf("%-5s %-10s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        int[] ages = randomAges(10);
        String[][] table = canVoteTable(ages);
        displayTable(table);
    }
}
