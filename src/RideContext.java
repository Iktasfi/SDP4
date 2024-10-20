public class RideContext {
    private FareStrategy fareStrategy;
    private final double MINIMUM_FARE = 5.00;

    public RideContext(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public void setFareStrategy(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public double calculateFare(double distance, int duration) {
        if (distance < 0 || duration < 0) {
            throw new IllegalArgumentException("Distance or duration cannot be negative.");
        }

        double fare = fareStrategy.calculateFare(distance, duration);
        return Math.max(fare, MINIMUM_FARE);
    }

    public void selectStrategy(double distance, int hour) {
        if (hour >= 18 && hour <= 22) {
            setFareStrategy(new SurgeFareStrategy());
        } else if (distance > 20) {
            setFareStrategy(new PremiumFareStrategy());
        } else {
            setFareStrategy(new RegularFareStrategy());
        }
    }
}
