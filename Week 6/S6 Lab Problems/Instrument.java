abstract class Instrument {
    protected String name;
    protected String material;

    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public abstract void play();

    public void commonInfo() {
        System.out.println(name + " (material: " + material + ")");
    }
}

class Piano extends Instrument {
    private int keys;

    public Piano(int keys, String material) {
        super("Piano", material);
        this.keys = keys;
    }

    @Override
    public void play() {
        commonInfo();
        System.out.println("Playing piano with " + keys + " keys.");
    }
}

class Guitar extends Instrument {
    private int strings;

    public Guitar(int strings, String material) {
        super("Guitar", material);
        this.strings = strings;
    }

    @Override
    public void play() {
        commonInfo();
        System.out.println("Strumming guitar with " + strings + " strings.");
    }
}

class Drum extends Instrument {
    private double diameterInInches;

    public Drum(double diameterInInches, String material) {
        super("Drum", material);
        this.diameterInInches = diameterInInches;
    }

    @Override
    public void play() {
        commonInfo();
        System.out.println("Beating drum of diameter " + diameterInInches + " inches.");
    }
}

class DemoInstruments {
    public static void main(String[] args) {
        Instrument[] band = {
                new Piano(88, "Wood/Metal"),
                new Guitar(6, "Wood"),
                new Drum(14.0, "Composite")
        };
        for (Instrument i : band)
            i.play();
    }
}
