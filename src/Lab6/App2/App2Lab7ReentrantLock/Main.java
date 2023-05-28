package Lab6.App2.App2Lab7ReentrantLock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier;
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        cyclicBarrier = new CyclicBarrier(4);

        while(true) {
            new ExecutionThread1(lock1, 4, 2, 4, cyclicBarrier).start();
            new ExecutionThread1(lock2, 5, 2, 5, cyclicBarrier).start();
            new ExecutionThread2(lock1, lock2, 3, 3, 6, cyclicBarrier).start();

            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

            cyclicBarrier.reset();
        }
    }
}
