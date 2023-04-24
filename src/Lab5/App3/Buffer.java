package Lab5.App3;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private final int capacity;
    private final ArrayList<Integer> buffer = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition bufferNotFull = lock.newCondition();
    private final Condition bufferNotEmpty = lock.newCondition();


    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    public void add(int number) throws InterruptedException {
        lock.lock();
        try {
            while (buffer.size() == capacity) {
                bufferNotFull.await();
            }
            buffer.add(number);
            System.out.println("Producer " + number);
            bufferNotEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int remove() throws InterruptedException {
        lock.lock();
        try {
            while (buffer.size() == 0){
                bufferNotEmpty.await();
            }
            int number = buffer.remove(0);
            System.out.println(Thread.currentThread().getName() + " consumed " + number);
            bufferNotFull.signalAll();
            return number;
        } finally {
            lock.unlock();
        }
    }
}
