package Lab6.App1.App1Lab7ReentrantLock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutionThread extends Thread {
    ReentrantLock lock1, lock2;
    int activity_min1, activity_min2, activity_max1, activity_max2, sleep;
    CyclicBarrier cyclicBarrier;

    public ExecutionThread(ReentrantLock lock1, ReentrantLock lock2, int activity_min1, int activity_min2, int activity_max1, int activity_max2, int sleep, CyclicBarrier cyclicBarrier) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.activity_min1 = activity_min1;
        this.activity_min2 = activity_min2;
        this.activity_max1 = activity_max1;
        this.activity_max2 = activity_max2;
        this.sleep = sleep;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 0");

        int k = (int) Math.round(Math.random() * (activity_max1 - activity_min1) + activity_min1);
        for (int i = 0; i <= k * 100000; i++) {
            i++; i--;
        }
        System.out.println(this.getName() + " - STATE 1");

        if (lock1.tryLock()) {
            try {
                int l = (int) Math.round(Math.random() * (activity_max2 - activity_min2) + activity_min2);
                for (int i = 0; i <= l * 100000; i++) {
                    i++; i--;
                }
                System.out.println(this.getName() + " - STATE 2");
                if (lock2.tryLock()) {
                    try {
                        System.out.println(this.getName() + " - STATE 3");

                        try {
                            Thread.sleep(sleep * 500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            } finally {
                lock1.unlock();
            }
        }
        System.out.println(this.getName() + " - STATE 4");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
