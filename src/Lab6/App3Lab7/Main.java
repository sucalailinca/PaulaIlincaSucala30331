package Lab6.App3Lab7;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatch;
        Integer monitor1 = 0;
        Integer monitor2 = 1;

        countDownLatch = new CountDownLatch(3);
        ExecutionThread1 t = new ExecutionThread1(monitor1, monitor2, 7, 2, 3, countDownLatch);
        t.start();

        new ExecutionThread2(monitor1, monitor2, 5, 3, 5, countDownLatch, t).start();
        new ExecutionThread2(monitor1, monitor2, 5, 4, 6, countDownLatch, t).start();

        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
