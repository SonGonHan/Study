public class Fahrenheit_Converter implements BaseConverter {

    public Fahrenheit_Converter(){}

    public double convert(double temp) {
        return 1.4 * temp + 32;
    }

}
