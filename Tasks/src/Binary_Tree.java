import java.util.List;
import java.util.ArrayList;

public class Binary_Tree {

    private int N = 0;
    private double value = -1;
    private Binary_Tree parent = null;
    private Binary_Tree left = null;
    private Binary_Tree right = null;

    Exception Error = new Exception("Некорректный индекс");

    public Binary_Tree(){}

    public Binary_Tree(double...Array) {
        if (Array.length == 0) {
            return;
        }
        N = 1;
        value = Array[0];
        for (int i = 1; i < Array.length; ++i) {
            add(Array[i]);
        }
    }

    private Binary_Tree(double value, Binary_Tree Parent) {
        this.value = value;
        this.parent = Parent;
        N = 1;
        Binary_Tree par = Parent;
        while (par != null) {
            ++par.N;
            par = par.parent;
        }
    }

    public void add(double value) {
        Binary_Tree Current = this;
        while (true) {
            if (value < Current.value) {
                if (Current.left == null) {
                    Current.left = new Binary_Tree(value, Current);
                    break;
                } else {
                    Current = Current.left;
                }
            } else if (value > Current.value) {
                if (Current.right == null) {
                    Current.right = new Binary_Tree(value, Current);
                    break;
                } else {
                    Current = Current.right;
                }
            }
            else {
                break;
            }
        }
    }

    public boolean contains(double value) {
        Binary_Tree Current = this;
        while (Current != null) {
            if (value < Current.value) {
                Current = Current.left;
            } else if (value > Current.value) {
                Current = Current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    private List<Double> make_list() {
        List<Double> Ans = new ArrayList<>();
        Ans.add(value);
        if (left != null){
            Ans.addAll(left.make_list());
            left.parent = null;
        }
        if (right != null){
            Ans.addAll(right.make_list());
            right.parent = null;
        }
        left = null;
        right = null;
        return Ans;
    }

    public void remove(double value) {
        Binary_Tree Current = this;
        while (Current != null) {
            if (value > Current.value) {
                Current = Current.right;
            } else if (value < Current.value) {
                Current = Current.left;
            } else {
                List<Double> AddList = Current.make_list();
                Current = Current.parent;
                Binary_Tree par = Current;
                while (par != null) {
                    --par.N;
                    par = par.parent;
                }
                if (AddList.get(0) < Current.value){
                    Current.left.parent = null;
                    AddList.removeFirst();
                    double[] AddArray = AddList.stream().mapToDouble(Double::doubleValue).toArray();
                    Current.left = new Binary_Tree(AddArray);
                }
                else {
                    Current.right.parent = null;
                    AddList.removeFirst();
                    double[] AddArray = AddList.stream().mapToDouble(Double::doubleValue).toArray();
                    Current.right = new Binary_Tree(AddArray);
                }
                break;
            }
        }
    }



    public double get(int idx) throws Exception{
        if (idx < 0 || idx >= N) {
            throw Error;
        }
        Binary_Tree Current = this;
        while (idx >= 0) {
            int l = 0, r = 0;
            if (Current.left != null) {
                l = Current.left.size();
            }
            if (Current.right != null) {
                r = Current.right.size();
            }
            if (idx == l) {
                return Current.value;
            }
            if (idx <= l) {
                Current = Current.left;
            }
            else {
                Current = Current.right;
                idx -= l + 1;
            }
        }
        return get_true(idx, 0);
    }

    private double get_true(int idx, int i){
        return 0.0;
    }

    public int size() {
        return N;
    }



    public void print() {
        print_true();
        System.out.println();
    }

    private void print_true() {
        boolean printed = false;
        if (left != null) {
            left.print_true();
            System.out.print(value + " ");
            printed = true;
        }
        if (right != null) {
            if (!printed){
                System.out.print(value + " ");
                printed = true;
            }
            right.print_true();
        }
        if (!printed){
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) throws Exception{
        final int array_size = 10;
        double[] Array = new double[array_size];
        for (int i = 0; i < array_size; ++i) {
            Array[i] = Math.random();
        }
        Binary_Tree tree = new Binary_Tree(Array);
        tree.print();
        System.out.println(tree.contains(Array[3]));
        System.out.println(tree.size());
        tree.remove(Array[3]);
        System.out.println(tree.contains(Array[3]));
        tree.print();
        System.out.println(tree.size());
        for (int i = 0; i < array_size - 1; ++i) {
            System.out.print(tree.get(i) + " ");
        }
    }

}
