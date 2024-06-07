interface Shape extends Comparable<Shape> {

    double getVolume();

    String toString();

    @Override
    default int compareTo(Shape other) {
        return Double.compare(this.getVolume(), other.getVolume());
    }

}
