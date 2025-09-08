interface Transaction
{
    void makePayment(double amount);
    void generateReceipt();
}
abstract class Payment implements Transaction
{
    protected double amount;
    public Payment(double amount)
    {
        this.amount = amount;
    }
    abstract boolean validatePayment();
}
class CreditCardPayment extends Payment
{
    private String cardNumber;
    public CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    boolean validatePayment() {
        // Credit card must be exactly 16 digits
        return cardNumber != null && cardNumber.matches("\\d{16}");
    }
     @Override
    public void makePayment(double amount) {
        if (validatePayment()) {
            System.out.println("Payment of Rs. " + amount + " made using Credit Card.");
        } else {
            System.out.println("Invalid Credit Card Number!");
        }
    }

    @Override
    public void generateReceipt() {
        System.out.println("Receipt: Credit Card Payment of Rs. " + amount);
    }
}
class UpiPayment extends Payment
{
    private String upiId;
    public UpiPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }
    @Override
    boolean validatePayment() {
        // UPI ID must contain '@'
        return upiId != null && upiId.contains("@");
    }
    @Override
    public void makePayment(double amount) {
        if (validatePayment()) {
            System.out.println("Payment of Rs. " + amount + " made using UPI.");
        } else {
            System.out.println("Invalid UPI ID!");
        }
    }
     @Override
    public void generateReceipt() {
        System.out.println("Receipt: UPI Payment of Rs. " + amount);
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        // Credit Card Payment
        Payment credit = new CreditCardPayment(1500, "1234567890123456");
        credit.makePayment(credit.amount);
        credit.generateReceipt();

        System.out.println();

        // UPI Payment
    Payment upi = new UpiPayment(750, "user@upi");
        upi.makePayment(upi.amount);
        upi.generateReceipt();
    }
    
}
