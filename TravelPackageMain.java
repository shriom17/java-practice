import java.util.ArrayList;
import java.util.List;

// Product
class TravelPackage {
    private String destination;
    private String duration;
    private String hotelType;
    private String mealPlan; // optional
    private List<String> activities; // optional

    // Constructor is private to enforce Builder usage
    private TravelPackage(TravelPackageBuilder builder) {
        this.destination = builder.destination;
        this.duration = builder.duration;
        this.hotelType = builder.hotelType;
        this.mealPlan = builder.mealPlan;
        this.activities = builder.activities;
    }

    @Override
    public String toString() {
        return "\n--- Travel Package Itinerary ---" +
                "\nDestination: " + destination +
                "\nDuration: " + duration +
                "\nHotel Type: " + hotelType +
                "\nMeal Plan: " + (mealPlan != null ? mealPlan : "None") +
                "\nActivities: " + (activities.isEmpty() ? "None" : String.join(", ", activities)) +
                "\n--------------------------------";
    }

    // Builder Class
    public static class TravelPackageBuilder {
        private String destination;
        private String duration;
        private String hotelType;
        private String mealPlan;
        private List<String> activities = new ArrayList<>();

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

        public TravelPackageBuilder setMealPlan(String mealPlan) {
            this.mealPlan = mealPlan;
            return this;
        }

        public TravelPackageBuilder addActivity(String activity) {
            this.activities.add(activity);
            return this;
        }

        public TravelPackage build() {
            return new TravelPackage(this);
        }
    }
}

// Director (optional)
class TravelDirector {
    public TravelPackage createLuxuryPackage() {
        return new TravelPackage.TravelPackageBuilder()
                .setDestination("Paris")
                .setDuration("7 Days")
                .setHotelType("5-Star")
                .setMealPlan("Full-board")
                .addActivity("Sightseeing")
                .addActivity("Cultural Tours")
                .build();
    }

    public TravelPackage createBudgetPackage() {
        return new TravelPackage.TravelPackageBuilder()
                .setDestination("Bali")
                .setDuration("3 Days")
                .setHotelType("3-Star")
                .setMealPlan("Breakfast only")
                .addActivity("Beach Relaxation")
                .build();
    }
}

// Client
public class TravelPackageMain {
    public static void main(String[] args) {
        // Using Builder directly
        TravelPackage customPackage = new TravelPackage.TravelPackageBuilder()
                .setDestination("Tokyo")
                .setDuration("5 Days")
                .setHotelType("4-Star")
                .setMealPlan("Half-board")
                .addActivity("Adventure Sports")
                .addActivity("Sightseeing")
                .build();

        // Using Director for predefined package
        TravelDirector director = new TravelDirector();
        TravelPackage luxuryPackage = director.createLuxuryPackage();
        TravelPackage budgetPackage = director.createBudgetPackage();

        // Print details
        System.out.println(customPackage);
        System.out.println(luxuryPackage);
        System.out.println(budgetPackage);
    }
}
