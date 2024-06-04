public class List {

    private class Element {

        private Element prev = null;
        private Element next = null;
        private int value;

        private Element() {
        }

        private Element(int x) {
            value = x;
        }
    }

    private int N;

    private final Element Begin = new Element();
    private final Element End = new Element();

    Exception Exc = new Exception("Некорректный индекс");

    public List(int[] A) {
        Begin.next = End;
        End.prev = Begin;
        for (int i = 0; i < A.length; ++i) {
            add(A[i]);
        }
    }

    public int get(int idx) throws Exception {
        if (idx >= N || idx < 0) {
            throw Exc;
        }
        Element Cur_el = Begin.next;
        for (int i = 0; i < idx; ++i){
            Cur_el = Cur_el.next;
        }
        return Cur_el.value;
    }

    public void add(int value) {
        Element Prev_el = End.prev,
                Cur_el = new Element(value);
        Prev_el.next = Cur_el;
        Cur_el.prev = Prev_el;
        Cur_el.next = End;
        End.prev = Cur_el;
        ++N;
    }

    public void add(int idx, int value) throws Exception {
        if (idx > N || idx < 0) {
            throw Exc;
        }
        if (idx == N){
            add(value);
            return;
        }
        Element Prev_el,
                New_el = new Element(value),
                Next_el = Begin.next;
        for (int i = 0; i < idx; ++i){
            Next_el = Next_el.next;
        }
        Prev_el = Next_el.prev;
        Prev_el.next = New_el;
        Next_el.prev = New_el;
        New_el.prev = Prev_el;
        New_el.next = Next_el;
        ++N;
    }

    public boolean contains(int value) {
        Element Cur_el = Begin.next;
        while (Cur_el != End && Cur_el.value != value){
            Cur_el = Cur_el.next;
        }
        return Cur_el != End;
    }

    public void set(int idx, int value) throws Exception{
        if (idx >= N || idx < 0) {
            throw Exc;
        }
        Element Cur_el = Begin.next;
        for (int i = 0; i < idx; ++i){
            Cur_el = Cur_el.next;
        }
        Cur_el.value = value;
    }

    public void remove(int value){
        Element Cur_el = Begin.next;
        while (Cur_el != End && Cur_el.value != value){
            Cur_el = Cur_el.next;
        }
        if (Cur_el != End){
            Cur_el.prev.next = Cur_el.next;
            Cur_el.next.prev = Cur_el.prev;
            --N;
        }
    }

    public void removeAll(int value){
        Element Cur_el = Begin.next, Delete_el;
        while (Cur_el != End){
            if (Cur_el.value == value){
                Delete_el = Cur_el;
                Cur_el = Delete_el.prev;
                Delete_el.prev.next = Delete_el.next;
                Delete_el.next.prev = Delete_el.prev;
                --N;
            }
            Cur_el = Cur_el.next;
        }
    }

    public void sort() {
        Element i = Begin.next, j, min_el;
        while (i != End.prev) {
            j = i.next;
            min_el = j;
            while (j != End) {
                if (j.value < min_el.value) {
                    min_el = j;
                }
                j = j.next;
            }
            if (min_el.value < i.value) {
                int x = min_el.value;
                min_el.value = i.value;
                i.value = x;
            }
            i = i.next;
        }
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void clear(){
        while (N > 0){
            remove(Begin.next.value);
        }
    }

    public void print() {
        Element Current_el = Begin.next;
        while (Current_el != End) {
            System.out.print(Current_el.value + " ");
            Current_el = Current_el.next;
        }
        System.out.println();
    }


    public static void main(String[] args) throws Exception {
        int[] Arr = new int[15];
        for (int i = 0; i < 15; ++i){
            Arr[i] = (int)(Math.random() * 10);
        }
        List Test = new List(Arr);
        Test.print();
        Test.add(11);
        Test.add(2, -1);
        Test.print();
        System.out.println(Test.get(2));
        System.out.println(Test.contains(11));
        System.out.println(Test.contains(1000));
        Test.remove(-1);
        Test.print();
        Test.removeAll(4);
        Test.print();
        System.out.println(Test.size());
        Test.sort();
        Test.print();
        Test.set(0, -2);
        Test.print();
        Test.clear();
        System.out.println(Test.isEmpty());
        Test.print();
    }

}
