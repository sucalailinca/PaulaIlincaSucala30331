package Lab6.App1.App1Lab7Semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class ExecutionThread extends Thread {
    int delay, activity_min, activity_max, activity_min2, activity_max2;
    Semaphore s1, s2;
    CountDownLatch countDownLatch;

    ExecutionThread(Semaphore s1, Semaphore s2, int delay, int activity_min, int activity_max, int activity_min2, int activity_max2, CountDownLatch countDownLatch) {
        this.s1 = s1;
        this.s2 = s2;
        this.delay = delay;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.activity_min2 = activity_min2;
        this.activity_max2 = activity_max2;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 0");

        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for(int i = 0; i <= k*100000; i++) {
            i++; i--;
        }
        System.out.println(this.getName() + " - STATE 1");

        s1.tryAcquire();
        try {
            int l = (int)Math.round(Math.random() * (activity_max2 - activity_min2) + activity_min2);
            for(int i = 0; i <= k * 100000; i++) {
                i++; i--;
            }
            System.out.println(this.getName() + " - STATE 2");

            s2.acquire(1);
            try {
                System.out.println(this.getName() + " - STATE 3");
                try {
                    Thread.sleep(delay * 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                s2.release(1);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            s1.release(1);
        }

        System.out.println(this.getName() + " - STATE 4");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
