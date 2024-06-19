import java.util.Queue;

public class Producer implements Runnable {

    @Override
    public void run() {
        while (Cycles != 0) {
            synchronized (sharedQueue) {
                TryToAddInQueue();
            }
        }
    }

    private void TryToAddInQueue() {
        try {
            if (sharedQueue.size() == N) {
                sharedQueue.wait();
            }
            AddInQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void AddInQueue() {
        int value = (int) Math.floor(Math.random() * 10);
        System.out.println("Producer: " + value);
        sharedQueue.add(value);
        sharedQueue.notifyAll();
        System.out.println();
        --Cycles;
    }

    Producer(Queue<Integer> sharedQueue, int N, int Cycles) {
        this.sharedQueue = sharedQueue;
        this.N = N;
        this.Cycles = Cycles;
    }

    private final Queue<Integer> sharedQueue;

    final int N;

    int Cycles;


}
