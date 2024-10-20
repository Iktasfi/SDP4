public class RideSharingApp {
    public static void main(String[] args) {
        RideContext ride = new RideContext(new RegularFareStrategy());

        double fare = ride.calculateFare(10, 15);
        System.out.println("Regular Fare: $" + fare);

        ride.selectStrategy(10, 19);
        fare = ride.calculateFare(10, 15);
        System.out.println("Surge Fare: $" + fare);

        ride.selectStrategy(25, 12);
        fare = ride.calculateFare(25, 30);
        System.out.println("Premium Fare: $" + fare);

        ride.setFareStrategy(new DiscountFareStrategy());
        fare = ride.calculateFare(5, 10);
        System.out.println("Discount Fare: $" + fare);

        try {
            ride.calculateFare(-5, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
