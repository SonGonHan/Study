import java.util.Arrays;

public class Search {

    static final int N = 1000000;

    public static int linear_search(double[] Arr, double value) {
        for (int i = 0; i < N; ++i) {
            if (Arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int binary_search(double[] Arr, double value) {
        int l = 0, r = N - 1, m;
        while (l < r) {
            m = (r + l) / 2;
            if (Arr[m] < value) {
                l = m + 1;
            }
            else if (Arr[m] > value) {
                r = m - 1;
            }
            else {
                return m;
            }
        }
        return -1;
    }

    public static double[] generate_random_array(){
        double[] Array = new double[N];
        for (int i = 0; i < N; ++i) {
            Array[i] = Math.random();
        }
        return Array;
    }

    public static void main(String[] args) {
        double[] Test_Array = generate_random_array();
        double[] Sorted_Array = Arrays.copyOf(Test_Array, N);
        long startTime = System.nanoTime();
        Sort.insertion_sort(Sorted_Array);
        long endTime = System.nanoTime();
        double value = Math.random();
        System.out.println((endTime - startTime) / 1000000 + "ms");

        int idx;
        startTime = System.nanoTime();
        idx = linear_search(Sorted_Array, 1);
        endTime = System.nanoTime();
        System.out.println((endTime - startTime));

        startTime = System.nanoTime();
        idx = binary_search(Sorted_Array, 1);
        endTime = System.nanoTime();
        System.out.println((endTime - startTime));

    }

}
