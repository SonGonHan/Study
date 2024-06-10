import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        final int N = 1_000_000;
        ArrayList<Double> AL= new ArrayList<>();
        LinkedList<Double> LL= new LinkedList<>();

        var time = System.nanoTime();
        for (int i = 0; i < N; i++) {
            AL.add(Math.random());
        }
        System.out.println((System.nanoTime() - time) / 1000000 + " ms");

        time = System.nanoTime();
        for (int i = 0; i < N; ++i) {
            LL.add(Math.random());
        }
        System.out.println((System.nanoTime() - time) / 1000000 + " ms");

        double val;
        time = System.nanoTime();
        for (int i = 0; i < N; ++i) {
            val = AL.get((int)Math.floor(Math.random() * N));
        }
        System.out.println((System.nanoTime() - time) / 1000000 + " ms");

        time = System.nanoTime();
        for (int i = 0; i < N; ++i) {
            val = LL.get((int)Math.floor(Math.random() * N));
        }
        System.out.println((System.nanoTime() - time) / 1000000 + " ms");
    }
}