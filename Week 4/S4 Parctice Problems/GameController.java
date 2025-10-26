public class GameController {
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;

    public GameController() {
        controllerBrand = "GenericPad";
        connectionType = "USB";
        hasVibration = true;
        batteryLevel = 100;
        sensitivity = 1.0;
    }

    public GameController(String brand, String type, boolean vibration, int battery, double sensitivity) {
        controllerBrand = brand;
        connectionType = type;
        hasVibration = vibration;
        this.batteryLevel = (battery >= 0 && battery <= 100) ? battery : 100;
        this.sensitivity = (sensitivity >= 0.1 && sensitivity <= 3.0) ? sensitivity : 1.0;
    }

    public GameController(String brand, String type) {
        this(brand, type, true, 100, 1.0);
    }

    public void displayConfiguration() {
        System.out.println("Brand: " + controllerBrand + ", Connection: " + connectionType +
                ", Vibration: " + hasVibration + ", Battery: " + batteryLevel +
                "%, Sensitivity: " + sensitivity);
    }

    public static void main(String[] args) {
        GameController c1 = new GameController();
        GameController c2 = new GameController("Sony Pods", "Bluetooth", true, 85, 2.5);
        GameController c3 = new GameController("XboxPad", "Wired");

        c1.displayConfiguration();
        c2.displayConfiguration();
        c3.displayConfiguration();
    }
}
