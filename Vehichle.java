public class Vehichle {
    private static String regCenter = "National Registration Center";
    private static int totalReg = 0;
    
    private String ownerName;
    private String regNumber;
    private String vehicleType;

    Vehichle(String ownerName, String regNumber, String vehicleType) {
        this.ownerName = ownerName;
        this.regNumber = regNumber;
        this.vehicleType = vehicleType;
        totalReg++;
    }

    public static int getTotalRegisteredVehicles() {
        return totalReg;
    }

    public void displayInfo() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Registration Number: " + regNumber);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        Vehichle v1 = new Vehichle("Alice", "ABC123", "Car");
        Vehichle v2 = new Vehichle("Bob", "XYZ789", "Motorcycle");

        System.out.println("Total Registered Vehicles: " + Vehichle.getTotalRegisteredVehicles());

        v1.displayInfo();
        v2.displayInfo();
    }
}
