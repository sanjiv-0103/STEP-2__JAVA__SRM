class Light {
    public Light() {
        System.out.println("Light created (default)");
    }

    public Light(String type) {
        this();
        System.out.println("Light type: " + type);
    }
}

class LED extends Light {
    public LED() {
        super("Generic");
        System.out.println("LED created (default)");
    }

    public LED(String color) {
        this();
        System.out.println("LED color: " + color);
    }
}

public class TestLight {
    public static void main(String[] args) {
        new LED("Blue");
    }
}