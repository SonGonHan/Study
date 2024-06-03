public class Main {
    public static void main(String[] args) {
        final int N = 100;
        int i, j;
        find_simple:
        for (i = 2; i < N; ++i) {
            for (j = 2; j <= Math.sqrt(i); ++j) {
                if (i % j == 0) {
                    continue find_simple;
                }
            }
            System.out.println(i);
        }
    }
}