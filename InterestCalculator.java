import java.util.*;
public class InterestCalculator
{
    public double calculateInterest(double principal, double rate, int time)
    {
        return principal * rate * time;
    }
    public double calculateInterest(double principal, double rate, int time, int compoundsperYear)
    {
        return principal * Math.pow(1+rate/compoundsperYear, compoundsperYear * time);
    }

    public static void main(String[] args) {
        InterestCalculator calculator = new InterestCalculator();
        Scanner sc = new Scanner(System.in);
        double principal, rate;
        int time, compoundsperYear;
        System.out.println("Enter Principal: ");
        principal = sc.nextDouble();
        System.out.println("Enter rate: ");
        rate = sc.nextDouble();
        System.out.println("Enter Time Period In Years: ");
        time = sc.nextInt();
        double simpleInterest = calculator.calculateInterest(principal, rate, time);
        System.out.println("Simple Interest" + simpleInterest);
        System.out.println("Mention The Year Compound Interest You Want: ");
        compoundsperYear = sc.nextInt();
       
        double compoundAmount = calculator.calculateInterest(principal, rate, time, compoundsperYear);
        System.out.println("Compound Amount: " + compoundAmount);
        System.out.println("Compound Interest: "+ (compoundAmount - principal));

    }
}