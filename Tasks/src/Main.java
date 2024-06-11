import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Main {

    public static class MyListIterator<T> implements ListIterator<T> {

        private final LinkedList<T> List;
        private int index;

        MyListIterator(LinkedList<T> List) {
            this.List = List;
            index = -1;
        }

        @Override
        public boolean hasNext() {
            return index + 1 < List.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Нет следующего элемента");
            }
            return List.get(++index);
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("Нет предшествующего элемента");
            }
            return List.get(--index);
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            if (index < 0 || index >= List.size()) {
                throw new IllegalStateException("Нельзя удалить элемент");
            }
            List.remove(index);
        }

        @Override
        public void set(T t) {
            if (index < 0 || index >= List.size()) {
                throw new IllegalStateException("Нельзя изменить элемент");
            }

            List.set(index, t);
        }

        @Override
        public void add(T t) {
            if (index < 0 || index > List.size()) {
                throw new IllegalStateException("Нельзя вставить элемент");
            }
            List.add(index, t);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> LL= new LinkedList<>();
        LL.add(1);
        LL.add(2);
        LL.add(3);
        LL.add(4);
        MyListIterator<Integer> it = new MyListIterator<>(LL);
        for (int i = 0; i < LL.size(); ++i) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        it.set(1000);
        for (int i = 0; i < 2; ++i) {
            System.out.print(it.previous() + " ");
        }
        System.out.println();
        it.remove();
        it = new MyListIterator<>(LL);
        for (int i = 0; i < LL.size(); ++i) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        it.add(-1);
        it.previous();
        System.out.print(it.next());
    }
}