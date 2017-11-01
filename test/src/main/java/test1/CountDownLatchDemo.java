import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*案例保证TaskPortion线程一定在WaitingTask线程全部完成后才执行 */
public class CountDownLatchDemo {
    static final int size = 100;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();// 新建一个线程池
        CountDownLatch latch = new CountDownLatch(size);//创建计数器为100个
        for (int i = 0; i < 10; i++) {
            exec.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < size; i++) {
            exec.execute(new TaskPortion(latch));
        }

        System.out.println("Launch all tasks");
        exec.shutdown();//退出线程
    }
}
