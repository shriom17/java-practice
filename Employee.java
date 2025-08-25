public abstract class Employee {
    protected String name;
    protected int id;
    
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();
    
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.printf("Salary: %.2f\n", calculateSalary());
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Array of employees demonstrating polymorphism
        Employee[] employees = {
            new FullTimeEmployee("Akash", 1, 50000.0),
            new PartTimeEmployee("Bidyut", 2, 20.0, 80.0),
            new PartTimeEmployee("Shriom", 3, 15.5, 60.0)
        };
        
        // Display details for all employees using polymorphism
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}

class FullTimeEmployee extends Employee {
    private final double fixedSalary;
    
    public FullTimeEmployee(String name, int id, double fixedSalary) {
        super(name, id);
        this.fixedSalary = fixedSalary;
    }
    
    @Override
    public double calculateSalary() {
        return fixedSalary;
    }
}

class PartTimeEmployee extends Employee {
    private final double hourlyWage;
    private final double hoursWorked;
    
    public PartTimeEmployee(String name, int id, double hourlyWage, double hoursWorked) {
        super(name, id);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }
    
    @Override
    public double calculateSalary() {
        return hourlyWage * hoursWorked;
    }
}


