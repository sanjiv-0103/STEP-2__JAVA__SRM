class Bird {
    public void fly() {
        System.out.println("A bird is flying...");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        System.out.println("Penguin: I cannot fly; I waddle and swim!");
    }
}

class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagle: Soaring high with powerful wings!");
    }
}

class DemoBirds {
    public static void main(String[] args) {
        Bird[] flock = { new Bird(), new Penguin(), new Eagle() };
        for (Bird b : flock)
            b.fly();
    }
}