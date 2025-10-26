public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = "  Java Programming is Fun and Challenging!  ";

        System.out.println("Original length: " + sampleText.length());
        String trimmed = sampleText.trim();
        System.out.println("Trimmed length: " + trimmed.length());
        System.out.println("Char at index 5: " + sampleText.charAt(5));
        System.out.println("Substring: " + sampleText.substring(6, 17));
        System.out.println("Index of 'Fun': " + sampleText.indexOf("Fun"));
        System.out.println("Contains 'Java'? " + sampleText.contains("Java"));
        System.out.println("Starts with 'Java'? " + trimmed.startsWith("Java"));
        System.out.println("Ends with '!': " + sampleText.endsWith("!"));
        System.out.println("Uppercase: " + sampleText.toUpperCase());
        System.out.println("Lowercase: " + sampleText.toLowerCase());
    }
}