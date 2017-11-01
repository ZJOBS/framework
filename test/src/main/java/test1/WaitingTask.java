import java.util.concurrent.CountDownLatch;

public class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;//同步工具类

    //构造函数注入同步工具类
    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("latch barrier passed for" + this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d", id);
    }
}
