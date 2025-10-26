class Box {
    public void pack() {
        System.out.println("Packing the item securely in a box.");
    }

    public void unpack() {
        System.out.println("Unpacking the item from the box.");
    }
}

class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack();
        System.out.println("Adding gift wrap, ribbon, and a greeting card.");
    }

    @Override
    public void unpack() {
        System.out.println("Carefully removing ribbon and gift wrap.");
        super.unpack();
    }

    public static void main(String[] args) {
        GiftBox gb = new GiftBox();
        gb.pack();
        System.out.println("---");
        gb.unpack();
    }
}
