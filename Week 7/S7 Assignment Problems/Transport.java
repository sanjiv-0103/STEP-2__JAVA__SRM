class Vehicle {
    void dispatch() {
        System.out.println("Generic vehicle dispatched");
    }
}

class Bus extends Vehicle {
    void dispatch() {
        System.out.println("Bus on fixed route");
    }
}

class Taxi extends Vehicle {
    void dispatch() {
        System.out.println("Taxi calculating fare");
    }
}

public class Transport {
    public static void main(String[] args) {
        Vehicle v = new Bus();
        v.dispatch();
        v = new Taxi();
        v.dispatch();
    }
}
