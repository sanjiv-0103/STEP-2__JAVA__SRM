class Product {
    private static int id = 1;
    private String pid, name, cat;
    private double price;
    private int stock;

    public Product(String n, String c, double p, int s) {
        pid = "P" + id++;
        name = n;
        cat = c;
        price = p;
        stock = s;
    }

    public String getId() {
        return pid;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int q) {
        if (q <= stock)
            stock -= q;
    }

    public void display() {
        System.out.println(pid + " | " + name + " | " + cat + " | $" + price + " | Stock:" + stock);
    }
}

class ShoppingCart {
    private static int cid = 1;
    private String cartId, customer;
    private Product[] items = new Product[10];
    private int[] qty = new int[10];
    private int count = 0;
    double total = 0;

    public ShoppingCart(String name) {
        cartId = "C" + cid++;
        customer = name;
    }

    public void add(Product p, int q) {
        if (p.getStock() >= q && count < items.length) {
            items[count] = p;
            qty[count] = q;
            total += p.getPrice() * q;
            p.reduceStock(q);
            count++;
        }
    }

    public void display() {
        System.out.println(cartId + " | " + customer + " Cart:");
        for (int i = 0; i < count; i++)
            System.out.println("  " + items[i].getId() + " x" + qty[i]);
        System.out.println("Total: $" + total);
    }
}

public class ShoppingCartApp {
    public static void main(String[] args) {
        Product p1 = new Product("Pen", "Stationery", 1.5, 20);
        Product p2 = new Product("Book", "Stationery", 5, 10);
        p1.display();
        p2.display();

        ShoppingCart c = new ShoppingCart("Sam");
        c.add(p1, 2);
        c.add(p2, 3);
        c.display();
    }
}
