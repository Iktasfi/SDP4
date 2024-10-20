public class PremiumFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, int duration) {
        return (2.00 * distance) + (0.50 * duration);
    }
}
