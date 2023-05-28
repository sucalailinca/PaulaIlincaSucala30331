package Lab6.App1.App1Lab7ReentrantLock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        while(true) {
            new ExecutionThread(lock1, lock2, 2, 4, 4, 6, 4, cyclicBarrier).start();
            new ExecutionThread(lock1, lock2, 3, 5, 5, 7, 5, cyclicBarrier).start();

            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            cyclicBarrier.reset();
        }
    }

}
