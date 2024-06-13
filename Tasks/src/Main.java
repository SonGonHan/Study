import java.util.*;

public class Main {

    public static <K, V> Map<V, Collection<K>> inverse(Map<? extends K, ? extends V> map){
        Map<V, Collection<K>> inv = new HashMap<>();

        for (var entry : map.entrySet()) {
            inv.compute(entry.getValue(), (k, v) -> {
                if (v == null) {
                    v = new HashSet<>();
                }
                v.add(entry.getKey());
                return v;
            });
        }
        
        return inv;
    }

    public static void main(String[] args) {
        final int N = 100;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            map.put(i, (int)Math.round(Math.random() * 10));
        }
        var inv = inverse(map);
        System.out.println(inv);
    }
}