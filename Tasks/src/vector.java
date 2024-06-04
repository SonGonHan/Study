public class vector {

    private final int[] Values;
    private final int[] Weights;
    private int Size = 0;

    public vector(int[] V, int[] W) {
        this.Values = V;
        this.Weights = W;
        for (int i = 1; i < this.Weights.length; ++i) {
            this.Weights[i] += this.Weights[i - 1];
        }
        Size = this.Weights[this.Weights.length - 1];
    }

    public int get() {
        int need_index = (int) (Math.random() * Size) + 1;
        int l = 0, r = this.Weights.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (need_index < this.Weights[m]){
                r = m;
            }
            else if (need_index > this.Weights[m]){
                l = m + 1;
            }
            else {
                return Values[m];
            }
        }
        return Values[l];
    }

    public static void main(String[] args) {
        final int N = 1000;
        int[] V = {0, 1, 2};
        int[] W = {1, 3, 6};
        vector Test = new vector(V, W);
        int[] Arr = {0, 0, 0};
        for (int i = 0; i < N; ++i) {
            ++Arr[Test.get()];
        }
        for (int i = 0; i < V.length; ++i) {
            System.out.println((double) Arr[i] / N);
        }
    }

}