import java.util.Arrays;
import java.util.function.Function;

public class Main {

    public static <T> void fill(T[] Arr, Function<Integer, T> f) {
        for (int i = 0; i < Arr.length; ++i) {
            Arr[i] = f.apply(i);
        }
    }

    public static void main(String[] args) {
        Integer[] squares = new Integer[10];
        fill(squares, integer -> integer * integer);
        System.out.println(Arrays.toString(squares));
    }
}