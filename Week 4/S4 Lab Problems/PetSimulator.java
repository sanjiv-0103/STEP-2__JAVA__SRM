import java.util.Random;
import java.util.UUID;

class VirtualPet {
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private String stage;

    private static final String[] EVOLUTION_STAGES = { "Egg", "Baby", "Child", "Teen", "Adult", "Elder" };
    private static int totalPetsCreated = 0;

    public VirtualPet() {
        this("Mystery", getRandomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }

    public VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 1, 60, 60, EVOLUTION_STAGES[1]);
    }

    public VirtualPet(String petName, String species) {
        this(petName, species, 2, 70, 70, EVOLUTION_STAGES[2]);
    }

    public VirtualPet(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stage = stage;
        totalPetsCreated++;
    }

    private static String generatePetId() {
        return UUID.randomUUID().toString().substring(0, 6); // short unique ID
    }

    private static String getRandomSpecies() {
        String[] speciesList = { "Dragon", "Cat", "Dog", "Phoenix", "Unicorn" };
        Random rand = new Random();
        return speciesList[rand.nextInt(speciesList.length)];
    }

    public void feedPet() {
        happiness += 5;
        health += 5;
    }

    public void playWithPet() {
        happiness += 10;
        health -= 2;
    }

    public void healPet() {
        health = Math.min(100, health + 20);
    }

    public void simulateDay() {
        age++;
        happiness -= 5;
        health -= 5;
        evolvePet();
    }

    private void evolvePet() {
        int stageIndex = Math.min(age / 3, EVOLUTION_STAGES.length - 1);
        stage = EVOLUTION_STAGES[stageIndex];
        if (health <= 0) {
            stage = "Ghost 👻";
        }
    }

    public void displayStatus() {
        System.out.printf("[%s] %s (%s) - Age: %d | Stage: %s | ❤️ %d | 😊 %d%n",
                petId, petName, species, age, stage, health, happiness);
    }

    public static int getTotalPetsCreated() {
        return totalPetsCreated;
    }
}

public class PetSimulator {
    public static void main(String[] args) {
        VirtualPet pet1 = new VirtualPet();
        VirtualPet pet2 = new VirtualPet("Buddy");
        VirtualPet pet3 = new VirtualPet("Luna", "Dragon");

        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day + " 🗓️");
            pet1.simulateDay();
            pet2.feedPet();
            pet3.playWithPet();

            pet1.displayStatus();
            pet2.displayStatus();
            pet3.displayStatus();
            System.out.println();
        }

        System.out.println("Total pets created: " + VirtualPet.getTotalPetsCreated());
    }
}
