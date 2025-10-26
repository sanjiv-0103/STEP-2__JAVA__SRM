class DeliveryCharges {

    void calculate(int distance) {
        double cost = distance * 5;
        System.out.println("Basic Delivery: Distance = " + distance + " km | Cost = Rs." + cost);
    }

    void calculate(int distance, double priority) {
        double cost = distance * 5 + priority;
        System.out.println("Premium Delivery: Distance = " + distance + " km + Priority Fee Rs." + priority
                + " | Cost = Rs." + cost);
    }

    void calculate(int distance, int orders, double discountPerOrder) {
        double cost = distance * 5 - (orders * discountPerOrder);
        if (cost < 0)
            cost = 0;
        System.out
                .println(
                        "Group Delivery: Distance = " + distance + " km | Orders = " + orders + " | Cost = Rs." + cost);
    }

    void calculate(int distance, double discountPercent, double freeLimit) {
        double baseCost = distance * 5;
        double discounted = baseCost - (baseCost * discountPercent / 100);

        if (discounted > freeLimit) {
            discounted = 0;
            System.out.println("Festival Special: Free Delivery! (Cost exceeded Rs." + freeLimit + ")");
        } else {
            System.out.println("Festival Special: Distance = " + distance + " km | " + discountPercent
                    + "% off | Cost = Rs." + discounted);
        }
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        DeliveryCharges dc = new DeliveryCharges();

        dc.calculate(10);
        dc.calculate(10, 20.0);
        dc.calculate(15, 3, 2.0);
        dc.calculate(30, 20.0, 100.0);
    }
}
