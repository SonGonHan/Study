public class Box extends Shape{

    private final double volume;
    private double available;

    Box(double volume) {
        this.volume = volume;
        available = volume;
    }

    @Override
    public double getVolume() {
        return available;
    }

    public boolean add(Shape shape) {
        if (available >= shape.getVolume()) {
            available -= shape.getVolume();
            return true;
        }
        return false;
    }

}
