class FoodOrder {
    String customerName, foodItem;
    int quantity;
    double price;
    static final double fixedRate = 100.0;

    FoodOrder() {
        this("Unknown", "Unknown", 0, 0.0);
    }

    // 2. with food item
    FoodOrder(String foodItem) {
        this("Customer", foodItem, 1, fixedRate);
    }

    FoodOrder(String foodItem, int quantity) {
        this("Customer", foodItem, quantity, quantity * fixedRate);
    }

    FoodOrder(String customerName, String foodItem, int quantity, double price) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }

    void printBill() {
        System.out.println("Customer: " + customerName +
                ", Food: " + foodItem +
                ", Quantity: " + quantity +
                ", Total Price: " + price);
    }

    public static void main(String[] args) {
        FoodOrder o1 = new FoodOrder();
        FoodOrder o2 = new FoodOrder("Pizza");
        FoodOrder o3 = new FoodOrder("Burger", 3);
        FoodOrder o4 = new FoodOrder("Alice", "Pasta", 2, 250.0);

        o1.printBill();
        o2.printBill();
        o3.printBill();
        o4.printBill();
    }
}
