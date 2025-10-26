class Room {
    private String num, type;
    private double price;
    private boolean available = true;

    public Room(String n, String t, double p) {
        num = n;
        type = t;
        price = p;
    }

    public boolean isAvailable() {
        return available;
    }

    public void book() {
        available = false;
    }

    public void free() {
        available = true;
    }

    public double getPrice() {
        return price;
    }

    public String getNum() {
        return num;
    }

    public void display() {
        System.out.println(num + " | " + type + " | $" + price + " | Avail:" + available);
    }
}

class Guest {
    private static int gid = 1;
    private String id, name;

    public Guest(String n) {
        id = "G" + gid++;
        name = n;
    }

    public String getName() {
        return name;
    }
}

class Booking {
    private static int bid = 1;
    private String id;
    private Guest g;
    private Room r;
    private double amount;

    public Booking(Guest g, Room r, int nights) {
        this.id = "B" + bid++;
        this.g = g;
        this.r = r;
        r.book();
        this.amount = r.getPrice() * nights;
    }

    public void display() {
        System.out.println(id + " | " + g.getName() + " | Room:" + r.getNum() + " | Amt:" + amount);
    }
}

public class HotelReservation {
    public static void main(String[] args) {
        Room r1 = new Room("101", "Deluxe", 1000);
        Room r2 = new Room("102", "Standard", 600);
        Guest g1 = new Guest("SK");
        Booking b1 = new Booking(g1, r1, 3);
        r1.display();
        r2.display();
        b1.display();
    }
}
