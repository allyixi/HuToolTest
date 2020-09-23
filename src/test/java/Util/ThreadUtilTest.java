package Util;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.Test;

public class ThreadUtilTest {
    // Hutool使用GlobalThreadPool持有一个全局的线程池，默认所有异步方法在这个线程池中执行。

    @Test
    public void test01() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(111);
            }
        });
        // 直接在公共线程池中执行线程
        ThreadUtil.execute(thread);

        // 获得一个新的线程池
        // ThreadUtil.newExecutor()

        // 执行异步方法
        // ThreadUtil.excAsync

        // 创建CompletionService，调用其submit方法可以异步执行多个任务，最后调用take方法按照完成的顺序获得其结果。若未完成，则会阻塞。
        // ThreadUtil.newCompletionService

        // 新建一个CountDownLatch，一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
        // ThreadUtil.newCountDownLatch

        // 挂起当前线程，是Thread.sleep的封装，通过返回boolean值表示是否被打断，而不是抛出异常。
        // ThreadUtil.sleep
        // ThreadUtil.safeSleep方法是一个保证挂起足够时间的方法，当给定一个挂起时间，使用此方法可以保证挂起的时间大于或等于给定时间，解决Thread.sleep挂起时间不足问题，此方法在Hutool-cron的定时器中使用保证定时任务执行的准确性。

        // ThreadUtil.getStackTrace
        // getStackTrace 获得堆栈列表
        // getStackTraceElement 获得堆栈项

        // createThreadLocal 创建本地线程对象
        // interupt 结束线程，调用此方法后，线程将抛出InterruptedException异常
        // waitForDie 等待线程结束. 调用 Thread.join() 并忽略 InterruptedException
        // getThreads 获取JVM中与当前线程同组的所有线程
        // getMainThread 获取进程的主线程
    }
}
