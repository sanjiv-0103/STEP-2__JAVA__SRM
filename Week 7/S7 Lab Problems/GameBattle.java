class Character {
    void attack() {
        System.out.println("Character attacks!");
    }
}

class Warrior extends Character {
    @Override
    void attack() {
        System.out.println(" Warrior attacks with weapons! (High defense)");
    }
}

class Mage extends Character {
    @Override
    void attack() {
        System.out.println(" Mage casts a spell! (Uses mana)");
    }
}

class Archer extends Character {
    @Override
    void attack() {
        System.out.println(" Archer shoots an arrow! (Long-range damage)");
    }
}

public class GameBattle {
    public static void main(String[] args) {
        Character[] army = {
                new Warrior(),
                new Mage(),
                new Archer(),
                new Warrior()
        };

        for (Character c : army) {
            c.attack();
        }
    }
}
