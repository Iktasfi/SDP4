public class RegularFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, int duration) {
        return (1.00 * distance) + (0.25 * duration);
    }
}
