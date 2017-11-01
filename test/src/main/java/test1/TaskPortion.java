import java.util.*;
import java.util.concurrent.*;

public class TaskPortion implements Runnable {
    private static int counter = 0;//计数器
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch latch;//同步工具类

    //构造函数注入同步工具类
    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            dowork();
           // latch.countDown();//通知已完成任务
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void dowork() throws InterruptedException {//被打断异常
        TimeUnit.MICROSECONDS.sleep(rand.nextInt(2000));//线程休眠
        System.out.println(this + "complated");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}
