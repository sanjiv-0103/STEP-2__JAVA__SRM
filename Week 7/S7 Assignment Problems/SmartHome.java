class Device {
}

class SmartTV extends Device {
    void control() {
        System.out.println("TV channel changed");
    }
}

class SmartThermostat extends Device {
    void control() {
        System.out.println("Temperature set");
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Device[] devices = { new SmartTV(), new SmartThermostat() };
        for (Device d : devices) {
            if (d instanceof SmartTV)
                ((SmartTV) d).control();
            else if (d instanceof SmartThermostat)
                ((SmartThermostat) d).control();
        }
    }
}
