import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void showDetails() {
        System.out.println("Product: " + name + ", Price: ₹" + price);
    }

    public String getName() {
        return name;
    }
}

class Order {
    private String orderId;
    private List<Product> products;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added product '" + product.getName() + "' to Order " + orderId);
    }

    public void showOrderDetails() {
        System.out.println("Order " + orderId + " contains:");
        for (Product p : products)
            p.showDetails();
    }

    public String getOrderId() {
        return orderId;
    }
}

class Customer {
    private String name, email;
    private List<Order> orders;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order " + order.getOrderId());
    }

    public void showCustomerOrders() {
        System.out.println("Orders placed by " + name + " (" + email + "):");
        for (Order o : orders)
            o.showOrderDetails();
    }
}

public class ShoppingDemo {
    public static void main(String[] args) {
        Customer c = new Customer("Amit", "amit@gmail.com");
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mobile", 25000);
        Product p3 = new Product("Mouse", 700);
        Order o1 = new Order("O1");
        Order o2 = new Order("O2");
        o1.addProduct(p1);
        o1.addProduct(p3);
        o2.addProduct(p2);
        c.placeOrder(o1);
        c.placeOrder(o2);
        c.showCustomerOrders();
    }
}