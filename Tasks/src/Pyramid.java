class Pyramid extends Shape{

    private final double s, h;

    public Pyramid(double s, double h){
        super(s * h / 3);
        this.s = s;
        this.h = h;
    }

}
