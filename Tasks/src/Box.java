import java.util.ArrayList;

public class Box implements Shape {

    private ArrayList<Shape> shapes = new ArrayList<>();
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
            shapes.add(shape);
            available -= shape.getVolume();
            return true;
        }
        return false;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

}
