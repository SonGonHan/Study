class SolidOfRevolution extends Shape{

    protected final double radius;

    protected SolidOfRevolution(double radius, double volume) {
        super(volume);
        this.radius = radius;
    }
}
