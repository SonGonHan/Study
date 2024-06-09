public class Main {

    public static void main(String[] args) {
        double temperature = 23.5;
        System.out.println("t = " +
                new Celsium_Converter().convert(temperature));
        System.out.println("t = " +
                new Kelvin_Converter().convert(temperature));
        System.out.println("t = " +
                new Fahrenheit_Converter().convert(temperature));
        System.out.println("t = " +
                new Reomure_Converter().convert(temperature));
    }
}