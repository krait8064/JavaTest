package cn.krait8063;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * created by krait8064 at 2019/12/18
 */
public class ThreadPoolTest {
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<?> submit = executorService.submit(new Runnable() {

            @Override
            public void run() {

            }
        });
        boolean done = submit.isDone();

    }
}
