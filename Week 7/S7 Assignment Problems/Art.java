class Artwork {
    void show() {
        System.out.println("General artwork");
    }
}

class Painting extends Artwork {
    void paintStyle() {
        System.out.println("Oil painting style");
    }
}

public class Art {
    public static void main(String[] args) {
        Artwork a = new Painting();
        a.show();
        if (a instanceof Painting) {
            Painting p = (Painting) a;
            p.paintStyle();
        }
    }
}
