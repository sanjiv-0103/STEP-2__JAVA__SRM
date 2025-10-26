public class Car {
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }

    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    }

    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.");
    }

    public void displayInfo() {
        System.out.println(year + " " + color + " " + brand + " " + model);
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2018, "White");
        Car car2 = new Car("Honda", "Civic", 2020, "Black");

        car1.startEngine();
        car1.displayInfo();
        System.out.println("Car age: " + car1.getAge(2025));

        car2.displayInfo();
        car2.stopEngine();
    }
}