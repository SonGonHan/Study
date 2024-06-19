import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class Main {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Repeat {
        int value();
    }

    @Repeat(3)
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello!");
        }
    }

    public static void main(String[] args) {
        CustomThreadPoolExecutor customThreadPoolExecutor =
                new CustomThreadPoolExecutor(10);
        customThreadPoolExecutor.execute(new MyRunnable());
    }

}