import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    public CustomThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    @Override
    public void execute(Runnable command) {
        if (command != null) {
            Main.Repeat rep = command.getClass().getAnnotation(Main.Repeat.class);
            final int RepeatCount = rep != null ? rep.value() : 1;
            for (int i = 0; i < RepeatCount; ++i) {
                command.run();
            }
        }
    }

}
