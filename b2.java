interface Refundable {
    void refund();
}

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    abstract void pay();

    public void printAmount() {
        System.out.println("Amount: " + amount);
    }
}

class CashPayment extends Payment {

    public CashPayment(double amount) {
        super(amount);
    }

    void pay() {
        System.out.println("Paying by Cash");
        printAmount();
    }
}

class CreditCardPayment extends Payment implements Refundable {

    public CreditCardPayment(double amount) {
        super(amount);
    }

    void pay() {
        System.out.println("Paying by Credit Card");
        printAmount();
    }

    public void refund() {
        System.out.println("Refund via Credit Card");
    }
}

class EWalletPayment extends Payment implements Refundable {

    public EWalletPayment(double amount) {
        super(amount);
    }

    void pay() {
        System.out.println("Paying by E-Wallet");
        printAmount();
    }

    public void refund() {
        System.out.println("Refund via E-Wallet");
    }
}

public class Main {
    public static void main(String[] args) {

        Payment[] payments = new Payment[3];

        payments[0] = new CashPayment(100);
        payments[1] = new CreditCardPayment(200);
        payments[2] = new EWalletPayment(300);

        for (Payment p : payments) {
            p.pay();

            if (p instanceof Refundable) {
                ((Refundable) p).refund();
            }

            System.out.println();
