class Box extends Shape{

    private double available;

    Box(double volume) {
        super(volume);
        available = volume;
    }

    public boolean add(Shape shape) {
        if (available >= shape.getVolume()) {
            available -= shape.getVolume();
            return true;
        }
        return false;
    }

}
