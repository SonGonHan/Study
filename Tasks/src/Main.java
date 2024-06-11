import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {

    public static class ArrayIterator <T> implements Iterator<T> {

        private final T[] Array;
        private int index;

        ArrayIterator(T[] Array) {
            this.Array = Array;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index + 1 < Array.length;
        }

        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Нет следующего элемента");
            }
            return Array[++index];
        }

        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("Нет предыдущего элемента");
            }
            return Array[--index];
        }

        public int getIndex() {
            return index;
        }
    }

    public static void main(String[] args) {
        Integer[] Array = {1, 2, 3, 4};
        ArrayIterator<Integer> it = new ArrayIterator<>(Array);
        for (int i = 0; i < 3; ++i) {
            System.out.println(it.next());
        }
        System.out.println();
        System.out.println(it.getIndex());
        System.out.println();
        for (int i = 0; i < 3; ++i){
            System.out.println(it.previous());
            System.out.println();
        }
        System.out.println(it.getIndex());
    }
}