class Hotel {
    void book(String room, int nights) {
        System.out.println("Standard Booking: " + room + " for " + nights + " nights");
    }

    void book(String room, int nights, double seasonalMultiplier) {
        System.out.println("Seasonal Booking: " + room + " for " + nights + " nights, price x" + seasonalMultiplier);
    }

    void book(String room, int nights, double discount, boolean meal) {
        System.out.println("Corporate Booking: " + room + " for " + nights + " nights, discount: " + discount
                + "%, meals: " + meal);
    }

    void book(String room, int nights, int guests, double decoration, boolean catering) {
        System.out.println(
                "Wedding Booking: " + guests + " guests, decoration fee: " + decoration + ", catering: " + catering);
    }
}

public class HotelSystem {
    public static void main(String[] args) {
        Hotel h = new Hotel();
        h.book("Deluxe", 3);
        h.book("Deluxe", 3, 1.2);
        h.book("Suite", 5, 15, true);
        h.book("Hall", 2, 200, 5000, true);
    }
}
