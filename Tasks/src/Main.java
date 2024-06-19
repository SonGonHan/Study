import java.util.LinkedList;
import java.util.Queue;

class Main {

    public static void main(String[] args){
        Queue<Integer> sharedQueue = new LinkedList<>();
        final int N = 4;
        int Cycles = 20;
        Thread prodThread = new Thread(new Producer(sharedQueue, N, Cycles), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue, Cycles), "Consumer");
        prodThread.start();
        consThread.start();
    }

}