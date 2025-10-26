class Vehicle {
    private static int idCounter = 1;
    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName = "BK Rentals";
    private static int rentalDays = 0;

    private String vehicleId;
    private String brand, model;
    private double rentPerDay;
    private boolean isAvailable;
    private int daysRented;

    public Vehicle(String brand, String model, double rentPerDay) {
        this.vehicleId = String.format("VH%03d", idCounter++);
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.daysRented = 0;
        totalVehicles++;
    }

    public double calculateRent(int days) {
        double amt = rentPerDay * Math.max(0, days);
        totalRevenue += amt;
        rentalDays += Math.max(0, days);
        return amt;
    }

    public boolean rentVehicle(int days) {
        if (!isAvailable || days <= 0)
            return false;
        double amt = calculateRent(days);
        isAvailable = false;
        daysRented += days;
        System.out.println(vehicleId + " rented for " + days + " days. Amount: " + amt);
        return true;
    }

    public void returnVehicle() {
        isAvailable = true;
        System.out.println(vehicleId + " returned.");
    }

    public void displayVehicleInfo() {
        System.out.println(vehicleId + " | " + brand + " " + model
                + " | " + rentPerDay + "/day | Avail: " + isAvailable
                + " | DaysRented: " + daysRented);
    }

    // static helpers
    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        return rentalDays == 0 ? 0 : (totalRevenue / rentalDays);
    }

    public static void displayCompanyStats() {
        System.out.println(companyName + " | Vehicles: " + totalVehicles
                + " | Revenue: " + totalRevenue
                + " | Avg/day: " + getAverageRentPerDay());
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle.setCompanyName("SK Rentals");

        Vehicle v1 = new Vehicle("Toyota", "Yaris", 40);
        Vehicle v2 = new Vehicle("Honda", "City", 55);

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();

        v1.rentVehicle(3);
        v2.rentVehicle(2);

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();

        v1.returnVehicle();
        v2.returnVehicle();

        Vehicle.displayCompanyStats();
    }
}
