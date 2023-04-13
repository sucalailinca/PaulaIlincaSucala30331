package Lab5.App4Lab7;

import java.util.concurrent.Semaphore;

public class ExecutionThread extends Thread {
    int delay, permit, activity_min, activity_max;
    Semaphore semaphore;

    ExecutionThread(Semaphore semaphore, int delay, int activity_min, int activity_max, int permit) {
        this.semaphore = semaphore;
        this.delay = delay;
        this.activity_max = activity_max;
        this.activity_min = activity_min;
        this.permit = permit;
    }

    public void run() {
        while(true) {
            try {
                this.semaphore.acquire(this.permit);
                System.out.println(this.getName() + " took a token from the semaphore");
                System.out.println(this.getName() + " - STATE 1");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 10000; i++) {
                    i++; i--;
                }
                this.semaphore.release();
                System.out.println(this.getName() + " release a token from the semaphore");
                System.out.println(this.getName() + " - STATE 2");
                Thread.sleep(this.delay * 500);
                System.out.println(this.getName() + " - STATE 3");
                System.out.println(this.getName() + " - STATE 4");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
