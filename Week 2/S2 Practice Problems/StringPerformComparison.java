public class StringPerformComparison {
    public static String concatenateWithString(int n) {
        String result = "";
        for (int i = 0; i < n; i++)
            result += "Java";
        return result;
    }

    public static String concatenateWithStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append("Java");
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++)
            sb.append("Java");
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 10000;

        long t1 = System.nanoTime();
        concatenateWithString(n);
        long t2 = System.nanoTime();
        System.out.println("String: " + (t2 - t1) + " ns");

        long t3 = System.nanoTime();
        concatenateWithStringBuilder(n);
        long t4 = System.nanoTime();
        System.out.println("StringBuilder: " + (t4 - t3) + " ns");

        long t5 = System.nanoTime();
        concatenateWithStringBuffer(n);
        long t6 = System.nanoTime();
        System.out.println("StringBuffer: " + (t6 - t5) + " ns");
    }
}
