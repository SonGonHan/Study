class Main {

    static class name_thr extends Thread {
        Object lock;

        public name_thr(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    try {
                        System.out.println(getName());
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Object lock = new Object();
        new name_thr(lock).start();
        new name_thr(lock).start();
    }

}