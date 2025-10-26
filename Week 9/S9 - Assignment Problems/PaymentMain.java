interface Discount {
    double apply(double amount);
}

class Payment {
    void processTransaction(double amount) {
        class Validator {
            boolean isValid(double amt) {
                return amt > 0;
            }
        }
        Validator v = new Validator();
        if (v.isValid(amount)) {
            Discount d = new Discount() {
                public double apply(double amt) {
                    return amt * 0.9;
                }
            };
            System.out.println("Final amount: " + d.apply(amount));
        } else
            System.out.println("Invalid amount");
    }
}

public class PaymentMain {
    public static void main(String[] args) {
        Payment p = new Payment();
        p.processTransaction(1000);
    }
}
