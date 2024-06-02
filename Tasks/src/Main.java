public class Main {
    public static void main(String[] args) {
        final int N = 100;
        var Arr = new double[N];
        double min_val = 1, max_val = 0, avg_val = 0;
        for (int i = 0; i < N; ++i) {
            Arr[i] = Math.random();
            min_val = Math.min(min_val, Arr[i]);
            max_val = Math.max(max_val, Arr[i]);
            avg_val += Arr[i] / N;
        }
        System.out.println("Min val: " + min_val);
        System.out.println("Max val: " + max_val);
        System.out.println("Avg val: " + avg_val);
    }
}