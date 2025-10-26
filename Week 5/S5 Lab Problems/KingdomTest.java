class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;

    public KingdomConfig(String name, int year) {
        this.kingdomName = name;
        this.foundingYear = year;
    }

    public String getKingdomName() {
        return kingdomName;
    }

    public int getFoundingYear() {
        return foundingYear;
    }
}

class MagicalStructure {
    private String structureName;
    private int magicPower;

    public MagicalStructure(String name, int power) {
        this.structureName = name;
        this.magicPower = power;
    }

    public void boostPower(int extra) {
        magicPower += extra;
        System.out.println(structureName + " boosted. Power: " + magicPower);
    }

    public void showStructure() {
        System.out.println("Structure: " + structureName + ", Magic Power: " + magicPower);
    }
}

public class KingdomTest {
    public static void main(String[] args) {
        KingdomConfig config = new KingdomConfig("Avalon", 1200);
        System.out.println("Kingdom: " + config.getKingdomName() + ", Founded: " + config.getFoundingYear());

        MagicalStructure tower = new MagicalStructure("Wizard Tower", 500);
        tower.showStructure();
        tower.boostPower(100);
    }
}