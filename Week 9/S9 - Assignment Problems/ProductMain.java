class Product {
    int productId;
    String productName;

    Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Product p = (Product) obj;
        return productId == p.productId;
    }
}

public class ProductMain {
    public static void main(String[] args) {
        Product p1 = new Product(101, "Pen");
        Product p2 = new Product(101, "Pen");
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
    }
}
