import java.util.ArrayList;
import java.util.List;

// TravelPackage class - Product
class TravelPackage {
    private String destination;
    private String duration;
    private String hotelType;
    private String mealPlan;
    private List<String> activities;

    // Constructor
    public TravelPackage(String destination, String duration, String hotelType, 
                        String mealPlan, List<String> activities) {
        this.destination = destination;
        this.duration = duration;
        this.hotelType = hotelType;
        this.mealPlan = mealPlan;
        this.activities = activities != null ? new ArrayList<>(activities) : new ArrayList<>();
    }

    // Getters
    public String getDestination() { return destination; }
    public String getDuration() { return duration; }
    public String getHotelType() { return hotelType; }
    public String getMealPlan() { return mealPlan; }
    public List<String> getActivities() { return activities; }

    public void printDetails() {
        System.out.println("\n--- Travel Package Details ---");
        System.out.println("Destination: " + destination);
        System.out.println("Duration: " + duration);
        System.out.println("Hotel Type: " + hotelType);
        System.out.println("Meal Plan: " + (mealPlan != null ? mealPlan : "Not included"));
        System.out.print("Activities: ");
        if (activities.isEmpty()) {
            System.out.println("None");
        } else {
            System.out.println(String.join(", ", activities));
        }
        System.out.println("-----------------------------");
    }
}

// TravelPackageBuilder class - Builder
class TravelPackageBuilder {
    private String destination;
    private String duration;
    private String hotelType;
    private String mealPlan;
    private List<String> activities = new ArrayList<>();

    // Required parameters
    public TravelPackageBuilder setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public TravelPackageBuilder setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public TravelPackageBuilder setHotelType(String hotelType) {
        this.hotelType = hotelType;
        return this;
    }

    // Optional parameters
    public TravelPackageBuilder setMealPlan(String mealPlan) {
        this.mealPlan = mealPlan;
        return this;
    }

    public TravelPackageBuilder addActivity(String activity) {
        this.activities.add(activity);
        return this;
    }

    public TravelPackageBuilder addActivities(List<String> activities) {
        this.activities.addAll(activities);
        return this;
    }

    // Build method
    public TravelPackage build() {
        if (destination == null || duration == null || hotelType == null) {
            throw new IllegalStateException("Destination, duration, and hotel type are required");
        }
        return new TravelPackage(destination, duration, hotelType, mealPlan, activities);
    }

    // Reset builder for reuse
    public void reset() {
        destination = null;
        duration = null;
        hotelType = null;
        mealPlan = null;
        activities.clear();
    }
}

// TravelDirector class - Director (provides predefined packages)
class TravelDirector {
    private TravelPackageBuilder builder;

    public TravelDirector(TravelPackageBuilder builder) {
        this.builder = builder;
    }

    public TravelPackage createLuxuryPackage(String destination, String duration) {
        builder.reset();
        return builder
            .setDestination(destination)
            .setDuration(duration)
            .setHotelType("5-Star Luxury Resort")
            .setMealPlan("All-Inclusive")
            .addActivity("Private Beach Access")
            .addActivity("Spa Treatment")
            .addActivity("Fine Dining")
            .addActivity("Concierge Service")
            .build();
    }

    public TravelPackage createBudgetPackage(String destination, String duration) {
        builder.reset();
        return builder
            .setDestination(destination)
            .setDuration(duration)
            .setHotelType("Budget Hotel")
            .setMealPlan("Breakfast Only")
            .addActivity("City Walking Tour")
            .addActivity("Local Market Visit")
            .build();
    }

    public TravelPackage createAdventurePackage(String destination, String duration) {
        builder.reset();
        return builder
            .setDestination(destination)
            .setDuration(duration)
            .setHotelType("Adventure Lodge")
            .setMealPlan("Full Board")
            .addActivity("Hiking")
            .addActivity("Rock Climbing")
            .addActivity("Wildlife Safari")
            .addActivity("Camping")
            .build();
    }

    public TravelPackage createFamilyPackage(String destination, String duration) {
        builder.reset();
        return builder
            .setDestination(destination)
            .setDuration(duration)
            .setHotelType("Family Resort")
            .setMealPlan("Half Board")
            .addActivity("Theme Park Visit")
            .addActivity("Kids Club")
            .addActivity("Family Pool Activities")
            .addActivity("Educational Tours")
            .build();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Travel Package Builder Demo ===");
        
        TravelPackageBuilder builder = new TravelPackageBuilder();
        TravelDirector director = new TravelDirector(builder);

        // 1. Build a custom package using builder directly
        System.out.println("\n1. Custom Travel Package:");
        TravelPackage customPackage = builder
            .setDestination("Paris, France")
            .setDuration("7 Days, 6 Nights")
            .setHotelType("4-Star Boutique Hotel")
            .setMealPlan("Continental Breakfast")
            .addActivity("Eiffel Tower Visit")
            .addActivity("Louvre Museum Tour")
            .addActivity("Seine River Cruise")
            .build();
        customPackage.printDetails();

        // 2. Build a luxury package using director
        System.out.println("\n2. Luxury Package:");
        TravelPackage luxuryPackage = director.createLuxuryPackage("Maldives", "10 Days, 9 Nights");
        luxuryPackage.printDetails();

        // 3. Build a budget package using director
        System.out.println("\n3. Budget Package:");
        TravelPackage budgetPackage = director.createBudgetPackage("Bangkok, Thailand", "5 Days, 4 Nights");
        budgetPackage.printDetails();

        // 4. Build an adventure package using director
        System.out.println("\n4. Adventure Package:");
        TravelPackage adventurePackage = director.createAdventurePackage("Nepal Himalayas", "14 Days, 13 Nights");
        adventurePackage.printDetails();

        // 5. Build a family package using director
        System.out.println("\n5. Family Package:");
        TravelPackage familyPackage = director.createFamilyPackage("Orlando, Florida", "6 Days, 5 Nights");
        familyPackage.printDetails();

        // 6. Build a minimal package (no optional features)
        System.out.println("\n6. Minimal Package:");
        builder.reset();
        TravelPackage minimalPackage = builder
            .setDestination("Local City")
            .setDuration("2 Days, 1 Night")
            .setHotelType("Standard Hotel")
            .build();
        minimalPackage.printDetails();

        System.out.println("\n=== Demo Complete ===");
    }
}

