import java.util.Arrays;
import java.util.function.Predicate;
import java.util.Objects;

public class Main {

    public static Object[] filter(Object[] Arr, Predicate<Object> filter) {
        int offset = 0;
        for (int i = 0; i < Arr.length - offset; ++i) {
            if (filter.test(Arr[i])) {
                Arr[i] = Arr[Arr.length - ++offset];
                --i;
            }
        }
        return Arrays.copyOf(Arr, Arr.length - offset);
    }

    public static void main(String[] args) {
        String[] array = new String[]{"1rewf ", "feefewf", "a", null, ";l;"};

        String[] newArray = (String[]) filter(array, Objects::isNull);
        System.out.println(Arrays.toString(newArray));
    }
}