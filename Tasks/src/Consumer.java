import java.util.Queue;

public class Consumer implements Runnable {

    @Override
    public void run() {
        while (Cycles != 0) {
            synchronized (sharedQueue) {
                TryToPollFromQueue();
            }
        }
    }

    private void TryToPollFromQueue() {
        try {
            if (sharedQueue.isEmpty()) {
                sharedQueue.wait();
            }
            PollFromQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void PollFromQueue() {
        System.out.println("Consumer: " + sharedQueue.poll());
        System.out.println();
        sharedQueue.notifyAll();
        --Cycles;
    }

    public Consumer(Queue<Integer> sharedQueue, int Cycles) {
        this.sharedQueue = sharedQueue;
        this.Cycles = Cycles;
    }

    private final Queue<Integer> sharedQueue;

    int Cycles;

}
