import java.util.*;
public class DistanceCalculator {
    public double calculateDistance(double speed, double time)
    {
        return speed * time;
    }

     public double calculateDistance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }
    
    public static void main(String[] args) {
        DistanceCalculator calculator = new DistanceCalculator();
        Scanner sc = new Scanner(System.in);
        double speed, time;
        System.out.println("Enter The Speed: ");
        speed = sc.nextDouble();
        System.out.println("Enter The Time: ");
        time = sc.nextDouble();
        double dsTime = calculator.calculateDistance(speed, time);
        System.out.println("Normal Distance: "+ dsTime + "km");
        double x1, y1, x2, y2;
        System.out.println("Enter The Coordinate Points: ");
        x1 = sc.nextDouble();
        y1 = sc.nextDouble();
        x2 = sc.nextDouble();
        y2 = sc.nextDouble();
        double disCord = calculator.calculateDistance(x1,y1,x2,y2);
        System.out.println("Distance Between Coordinates: " + disCord);
    }
}