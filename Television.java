import java.util.*;

public class Television {
    float cost;
    float discount;
    float amount;

    public void accept()
    {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter The Cost: ");
       cost = sc.nextFloat();
    }

    public double calculate()
    {
        discount = 0.1f * cost;
        amount = cost - discount;
        return amount;
    }

    public void display()
    {
        System.out.println("Cost: " + cost);
        System.out.println("Discount: " + discount);
        System.out.println("Amount after discount: " + amount);
    }

    public static void main(String[] args) {
        Television tv = new Television();
        tv.accept();
        tv.calculate();
        tv.display();
    }
}
