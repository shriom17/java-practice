public class Ecommerce {
    // Base abstract class
    static abstract class Order {
        protected int orderId;
        protected double amount;

        public Order(int orderId, double amount) {
            this.orderId = orderId;
            this.amount = amount;
        }

        public abstract double calculateDiscount();
        public abstract void generateInvoice();
    }

    // RegularOrder: 5% discount if amount > 1000
    static class RegularOrder extends Order {
        public RegularOrder(int orderId, double amount) {
            super(orderId, amount);
        }

        @Override
        public double calculateDiscount() {
            return (amount > 1000) ? amount * 0.05 : 0;
        }

        @Override
        public void generateInvoice() {
            double discount = calculateDiscount();
            double total = amount - discount;
            System.out.println("---- Regular Order Invoice ----");
            System.out.println("Order ID: " + orderId);
            System.out.println("Amount: $" + amount);
            System.out.println("Discount: $" + discount);
            System.out.println("Total: $" + total);
            System.out.println("-------------------------------");
        }
    }

    // PrimeOrder: 10% discount + free shipping
    static class PrimeOrder extends Order {
        public PrimeOrder(int orderId, double amount) {
            super(orderId, amount);
        }

        @Override
        public double calculateDiscount() {
            return amount * 0.10;
        }

        @Override
        public void generateInvoice() {
            double discount = calculateDiscount();
            double total = amount - discount;
            System.out.println("---- Prime Order Invoice ----");
            System.out.println("Order ID: " + orderId);
            System.out.println("Amount: $" + amount);
            System.out.println("Discount: $" + discount);
            System.out.println("Shipping: Free");
            System.out.println("Total: $" + total);
            System.out.println("-------------------------------");
        }
    }

    // BulkOrder: flat 15% discount for orders above 10 items
    static class BulkOrder extends Order {
        private int itemCount;

        public BulkOrder(int orderId, double amount, int itemCount) {
            super(orderId, amount);
            this.itemCount = itemCount;
        }

        @Override
        public double calculateDiscount() {
            return (itemCount > 10) ? amount * 0.15 : 0;
        }

        @Override
        public void generateInvoice() {
            double discount = calculateDiscount();
            double total = amount - discount;
            System.out.println("---- Bulk Order Invoice ----");
            System.out.println("Order ID: " + orderId);
            System.out.println("Amount: $" + amount);
            System.out.println("Items: " + itemCount);
            System.out.println("Discount: $" + discount);
            System.out.println("Total: $" + total);
            System.out.println("-------------------------------");
        }
    }

    public static void main(String[] args) {
        Order r = new RegularOrder(101, 1200);
        Order p = new PrimeOrder(102, 1500);
        Order b = new BulkOrder(103, 3000, 15);

        r.generateInvoice();
        System.out.println();
        p.generateInvoice();
        System.out.println();
        b.generateInvoice();
    }
}