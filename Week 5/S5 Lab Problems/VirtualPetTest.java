class VirtualPet {
    private String petName;
    private int happiness;
    private int health;

    public VirtualPet(String name) {
        this.petName = name;
        this.happiness = 50;
        this.health = 50;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getHappiness() {
        return happiness;
    }

    public void feedPet() {
        happiness += 10;
        if (happiness > 100)
            happiness = 100;
        System.out.println(petName + " is fed. Happiness: " + happiness);
    }

    public void playWithPet() {
        health += 10;
        if (health > 100)
            health = 100;
        System.out.println(petName + " played. Health: " + health);
    }

    public void showStatus() {
        System.out.println("Pet: " + petName + ", Happiness: " + happiness + ", Health: " + health);
    }
}

public class VirtualPetTest {
    public static void main(String[] args) {
        VirtualPet pet = new VirtualPet("Meow ");
        pet.showStatus();
        pet.feedPet();
        pet.playWithPet();
        pet.showStatus();
    }
}