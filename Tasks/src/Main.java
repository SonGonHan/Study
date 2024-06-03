import java.util.Arrays;

public class Main {

    public static int N = 10, RANGE = 10;

    private static int[] remove(int[] Arr, int num_del) {
        int remove_count = 0;
        for (int i = 0; i < N - remove_count; ++i) {
            if (Arr[i] == num_del) {
                Arr[i] = Arr[N - (++remove_count)];
            }
        }
        return Arrays.copyOf(Arr, N - remove_count);
    }

    public static void main(String[] args) {
        int[] Arr = new int[N];
        for (int i = 0; i < N; ++i) {
            Arr[i] = (int) Math.floor(Math.random() * RANGE);
        }
        System.out.println(Arrays.toString(Arr));

        int num_del = (int) Math.floor(Math.random() * RANGE);
        System.out.println(num_del);
        
        System.out.println(Arrays.toString(remove(Arr, num_del)));
    }

}