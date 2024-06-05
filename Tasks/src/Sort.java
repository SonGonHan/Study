public class Sort {

    private static void swap(double[] Arr, int i, int j) {
        double temp = Arr[i];
        Arr[i] = Arr[j];
        Arr[j] = temp;
    }

    public static void bubble_sort(double[] Arr) {
        final int N = Arr.length;
        boolean sort_neeeded = true;
        while (sort_neeeded) {
            sort_neeeded = false;
            for (int i = 0; i < N - 1; i++) {
                if (Arr[i] > Arr[i + 1]) {
                    swap(Arr, i, i + 1);
                    sort_neeeded = true;
                }
            }
        }
    }

    public static void selection_sort(double[] Arr) {
        final int N = Arr.length;
        for (int i = 0; i < N; ++i) {
            int min = i;
            for (int j = i + 1; j < N; ++j) {
                if (Arr[j] < Arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(Arr, i, min);
            }
        }
    }

    public static void insertion_sort(double[] Arr) {
        final int N = Arr.length;
        for (int i = 1; i < N; ++i) {
            int j = i;
            while (j > 0 && Arr[j] < Arr[j - 1]) {
                swap(Arr, j, j - 1);
                --j;
            }
        }
    }




}
