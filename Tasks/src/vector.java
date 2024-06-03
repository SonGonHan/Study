public class vector {

    private double x;
    private double y;
    private double z;


    public vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public double scalar_product(final vector V){
        return this.x * V.x + this.y * V.y + this.z * V.z;
    }

    public vector vector_product(final vector V){
        return new vector(
                this.y * V.z - this.z * V.y,
                this.z * V.x + this.x * V.z,
                this.x * V.y - this.y * V.x);
    }

    public double angle_between(final vector V){
        return Math.toDegrees(Math.acos(scalar_product(V) / (this.length() * V.length())));
    }

    public vector addition(final vector V){
        return new vector(
                this.x + V.x,
                this.y + V.y,
                this.z + V.z);
    }

    public vector subtraction(final vector V){
        return new vector(
                this.x - V.x,
                this.y - V.y,
                this.z - V.z);
    }

    public static vector[] generate(final int N){
        vector[] Vectors = new vector[N];
        for (int i = 0; i < N; ++i) {
            Vectors[i] = new vector(
                    Math.random() * 2 - 1,
                    Math.random() * 2 - 1,
                    Math.random() * 2 - 1);
        }
        return Vectors;
    }

    @Override
    public String toString() {
        return "Vector:" +
                "\nx = " + x +
                "\ny = " + y +
                "\nz = " + z;
    }

    public static void main(String[] args) {
        vector[] Vectors = vector.generate(10);
        System.out.println(Vectors[0]);
        System.out.println(Vectors[1]);
        System.out.println(Vectors[0].length());
        System.out.println(Vectors[0].scalar_product(Vectors[1]));
        System.out.println(Vectors[0].vector_product(Vectors[1]));
        System.out.println(Vectors[0].angle_between(Vectors[1]));
        System.out.println(Vectors[0].addition(Vectors[1]));
        System.out.println(Vectors[0].subtraction(Vectors[1]));
    }

}