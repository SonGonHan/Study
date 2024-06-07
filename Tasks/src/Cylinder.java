class Cylinder extends SolidOfRevolution{

    private final double height;

    public Cylinder(double height, double radius) {
        super(radius, Math.PI * Math.pow(radius, 2) * height);
        this.height = height;
    }

}
