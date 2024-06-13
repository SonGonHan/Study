import java.util.HashMap;
import java.util.Map;

public class Main {

    public static <K> Map<K, Integer> arrayToMap(K[] ks){
        Map<K, Integer> map = new HashMap<>();
        for(K k : ks){
            map.compute(k, (_, v) -> v == null ? 1 : v + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        final int N = 100;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int)Math.round(Math.random() * 10);
        }
        Map<Integer, Integer> m = arrayToMap(arr);
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}