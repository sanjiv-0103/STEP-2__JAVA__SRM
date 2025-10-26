import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class ECommerce {
    private final String productId;
    private final String name;
    private final String category;
    private final String manufacturer;
    private final double basePrice;
    private final Map<String, String> specifications;

    public ECommerce(String productId, String name, String category,
            String manufacturer, double basePrice,
            Map<String, String> specifications) {
        if (productId == null || productId.isEmpty())
            throw new IllegalArgumentException("productId required");
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("name required");
        if (basePrice < 0)
            throw new IllegalArgumentException("price must be >= 0");
        this.productId = productId;
        this.name = name;
        this.category = category == null ? "General" : category;
        this.manufacturer = manufacturer == null ? "NA" : manufacturer;
        this.basePrice = basePrice;
        this.specifications = specifications == null
                ? Collections.emptyMap()
                : Collections.unmodifiableMap(new HashMap<>(specifications));
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public Map<String, String> getSpecifications() {
        return specifications;
    }

    public final double calculateTax(String region) {
        double rate = switch (region == null ? "" : region.toUpperCase()) {
            case "EU" -> 0.20;
            case "US" -> 0.07;
            case "AU" -> 0.10;
            default -> 0.05;
        };
        return basePrice * rate;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + basePrice;
    }
}

class Customer {
    private final String customerId;
    private final String email;
    private String name;
    private String phoneNumber;

    public Customer(String customerId, String email) {
        if (customerId == null || customerId.isEmpty())
            throw new IllegalArgumentException("customerId required");
        if (email == null || email.isEmpty())
            throw new IllegalArgumentException("email required");
        this.customerId = customerId;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPublicProfile() {
        return "Customer{name='" + (name == null ? "Guest" : name) + "'}";
    }
}

class ShoppingCart {
    private final String cartId;
    private final String customerId;
    private double totalAmount;
    private int itemCount;

    public ShoppingCart(String cartId, String customerId) {
        if (cartId == null || cartId.isEmpty())
            throw new IllegalArgumentException("cartId required");
        if (customerId == null || customerId.isEmpty())
            throw new IllegalArgumentException("customerId required");
        this.cartId = cartId;
        this.customerId = customerId;
    }

    public boolean addItem(ECommerce product, int quantity) {
        if (product == null || quantity <= 0)
            return false;
        double line = product.getBasePrice() * quantity;
        totalAmount += line;
        itemCount += quantity;
        return true;
    }

    public String getCartSummary() {
        return "Cart{id=" + cartId + ", items=" + itemCount + ", total=$" + String.format("%.2f", totalAmount) + "}";
    }
}

public class ECommerceDemo {
    public static void main(String[] args) {
        Customer c = new Customer("C001", "user@example.com");
        c.setName("Rohit");
        ShoppingCart cart = new ShoppingCart("CART-9", c.getCustomerId());

        ECommerce phone = new ECommerce(
                "P100", "Pixel Lite", "Electronics", "Acme",
                499.00, Map.of("storage", "128GB", "color", "Black"));
        cart.addItem(phone, 2);

        System.out.println(c.getPublicProfile());
        System.out.println(phone + " | AU tax = $" + String.format("%.2f", phone.calculateTax("AU")));
        System.out.println(cart.getCartSummary());
    }
}
