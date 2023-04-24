package Lab5.App2Lab4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        ExecutionThread thread1, thread2;

        thread1 = new ExecutionThread(1, lock);
        thread2 = new ExecutionThread(2, lock);

        thread1.start();
        thread2.start();
    }
}
