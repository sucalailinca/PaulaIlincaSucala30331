package Lab6.App1.App1Lab7Semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);

        while(true) {
            CountDownLatch countDownLatch = new CountDownLatch(3);

            new ExecutionThread(s1, s2, 4, 2, 4,4,6, countDownLatch).start();
            new ExecutionThread(s1, s2, 5, 3, 5,5,7, countDownLatch).start();

            countDownLatch.countDown();

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
