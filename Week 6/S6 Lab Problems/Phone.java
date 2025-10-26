class Phone {
    protected String brand;
    protected String model;

    public Phone() {
        System.out.println("Phone(): default constructor");
    }

    public Phone(String brand, String model) {
        System.out.println("Phone(String, String): parameterized constructor");
        this.brand = brand;
        this.model = model;
    }
}

class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone() {
        super();
        System.out.println("SmartPhone(): default constructor");
    }

    public SmartPhone(String brand, String model, String os) {
        super(brand, model);
        System.out.println("SmartPhone(String, String, String): parameterized constructor");
        this.operatingSystem = os;
    }

    public void printInfo() {
        System.out.println(brand + " " + model + " - " + operatingSystem);
    }

    public static void main(String[] args) {
        System.out.println("== Default constructors ==");
        SmartPhone s1 = new SmartPhone();
        s1.brand = "Generic";
        s1.model = "X1";
        s1.operatingSystem = "DroidOS";
        s1.printInfo();

        System.out.println("\n== Parameterized constructors ==");
        SmartPhone s2 = new SmartPhone("Samsung", "S25", "Android");
        s2.printInfo();
    }
}
