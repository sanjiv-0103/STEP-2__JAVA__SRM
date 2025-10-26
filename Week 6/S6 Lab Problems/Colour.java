class Color {
    protected String name;

    public Color(String name) {
        this.name = name;
        System.out.println("Color constructed: " + name);
    }

    public void info() {
        System.out.println("Color: " + name);
    }
}

class PrimaryColor extends Color {
    protected int intensity;

    public PrimaryColor(String name, int intensity) {
        super(name);
        this.intensity = intensity;
        System.out.println("PrimaryColor intensity set to " + intensity);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Intensity: " + intensity);
    }
}

class RedColor extends PrimaryColor {
    private String shade;

    public RedColor(int intensity, String shade) {
        super("Red", intensity);
        this.shade = shade;
        System.out.println("RedColor shade: " + shade);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Shade: " + shade);
    }

    public static void main(String[] args) {
        RedColor rc = new RedColor(85, "Crimson");
        rc.info();
    }
}