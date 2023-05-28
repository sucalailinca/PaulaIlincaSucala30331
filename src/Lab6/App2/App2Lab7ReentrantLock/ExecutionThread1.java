package Lab6.App2.App2Lab7ReentrantLock;

import java.lang.management.MemoryType;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutionThread1 extends Thread {
    ReentrantLock lock1;
    int sleep, activity_min, activity_max;
    CyclicBarrier cyclicBarrier;

    public ExecutionThread1(ReentrantLock lock1, int sleep, int activity_min, int activity_max, CyclicBarrier cyclicBarrier) {
        this.lock1 = lock1;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {

        System.out.println(this.getName() + " - STATE 1");

        lock1.lock();

        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i <= k * 100000; i++) {
            i++; i--;
        }
        System.out.println(this.getName() + " - STATE 2");

        try {
            Thread.sleep(sleep * 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock1.unlock();

        System.out.println(this.getName() + " - STATE 3");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
