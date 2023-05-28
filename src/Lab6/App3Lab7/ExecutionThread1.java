package Lab6.App3Lab7;

import java.util.concurrent.CountDownLatch;

public class ExecutionThread1 extends Thread {
    Integer monitor1, monitor2;
    int sleep, activity_min, activity_max;
    CountDownLatch countDownLatch;

    public ExecutionThread1(Integer monitor1, Integer monitor2, int sleep, int activity_min, int activity_max, CountDownLatch countDownLatch) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 0");
        try {
            Thread.sleep(7 * 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i <= k * 100000; i++) {
            i++; i--;
        }

        synchronized (monitor1) {
            monitor1.notify();
        }
        synchronized (monitor2) {
            monitor2.notify();
        }
        System.out.println(this.getName() + " - STATE 2");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
