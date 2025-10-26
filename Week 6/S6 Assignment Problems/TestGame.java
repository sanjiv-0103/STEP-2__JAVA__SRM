class Game {
    String title;

    Game(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Game: " + title;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Game) && title.equals(((Game) o).title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}

class CardGame extends Game {
    int players;

    CardGame(String title, int players) {
        super(title);
        this.players = players;
    }

    @Override
    public String toString() {
        return super.toString() + " with " + players + " players";
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof CardGame) &&
                super.equals(o) &&
                players == ((CardGame) o).players;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + players;
    }
}

public class TestGame {
    public static void main(String[] args) {
        CardGame c1 = new CardGame("Poker", 4);
        CardGame c2 = new CardGame("Poker", 4);
        System.out.println(c1);
        System.out.println(c1.equals(c2));
    }
}
