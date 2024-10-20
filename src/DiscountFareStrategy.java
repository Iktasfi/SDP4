public class DiscountFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, int duration) {
        return (0.75 * distance) + (0.15 * duration);
    }
}
