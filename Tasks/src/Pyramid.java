public class Pyramid extends Shape{

    private final double s, h;

    public Pyramid(double s, double h){
        this.s = s;
        this.h = h;
    }

    @Override
    public double getVolume() {
        return s * h / 3;
    }

}
