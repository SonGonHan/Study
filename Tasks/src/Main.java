public class Main {
    public static void main(String[] args) {
        final int N = 10;
        var Arr = new double[N];
        for (int i = 0; i < N; ++i) {
            Arr[i] = Math.random();
        }
        double swap;
        for (int i = 0; i < N; ++i) {
            for (int j = N - 1; j > i; --j) {
                if (Arr[j - 1] > Arr[j]) {
                    swap = Arr[j - 1];
                    Arr[j - 1] = Arr[j];
                    Arr[j] = swap;
                }
            }
        }
        for (var x : Arr) {
            System.out.println(x);
        }
    }
}