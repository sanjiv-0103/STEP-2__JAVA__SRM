import java.util.*;

public class MiniCSV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Paste CSV rows (blank line to finish):");

        List<String[]> rows = new ArrayList<>();
        while (true) {
            String line = sc.nextLine();
            if (line.trim().isEmpty())
                break;
            String[] cells = line.split(",", -1);
            for (int i = 0; i < cells.length; i++)
                cells[i] = cells[i].trim();
            rows.add(cells);
        }

        System.out.println("\nParsed table:");
        for (String[] r : rows) {
            System.out.print("| ");
            for (String c : r)
                System.out.print(c + " | ");
            System.out.println();
        }

        sc.close();
    }
}