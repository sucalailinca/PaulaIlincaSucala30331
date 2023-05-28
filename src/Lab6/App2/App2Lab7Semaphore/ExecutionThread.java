package Lab6.App2.App2Lab7Semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class ExecutionThread extends Thread {
    Semaphore s1, s2;
    int sleep, activity_max, activity_min;
    CountDownLatch countDownLatch;

    public ExecutionThread(Semaphore s1, Semaphore s2, int sleep, int activity_min, int activity_max, CountDownLatch countDownLatch) {
        this.s1 = s1;
        this.s2 = s2;
        this.sleep = sleep;
        this.activity_max = activity_max;
        this.activity_min = activity_min;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");

        if(this.getName().equals("Thread-0")) {
            try {
                s1.acquire(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int k = (int) Math.round(Math.random()*(activity_max - activity_min) + activity_min);
            for(int i = 0; i <= k*100000; i++) {
                i++; i--;
            }
            System.out.println(this.getName() + " - STATE 2");
            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s1.release(1);
        }

        if(this.getName().equals("Thread-2")) {
            s2.acquireUninterruptibly(1);

            int k = (int) Math.round(Math.random()*(activity_max - activity_min) + activity_min);
            for(int i = 0; i <= k*100000; i++) {
                i++; i--;
            }
            System.out.println(this.getName() + " - STATE 2");
            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s2.release(1);
        }

        if(this.getName().equals("Thread-1")) {
            s1.acquireUninterruptibly(1);
            s2.acquireUninterruptibly(1);

            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for(int i = 0; i <= k*100000; i++) {
                i++; i--;
            }
            System.out.println(this.getName() + " - STATE 2");
            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s1.release(1);
            s2.release(2);
        }

        System.out.println(this.getName() + " - STATE 3");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
