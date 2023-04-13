package Lab5.App4Lab7;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        new ExecutionThread(semaphore, 3, 4, 7, 1).start();
        new ExecutionThread(semaphore, 6, 5, 7, 1).start();
        new ExecutionThread(semaphore, 5, 3, 6, 1).start();
    }
}
