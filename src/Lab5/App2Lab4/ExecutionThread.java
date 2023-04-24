package Lab5.App2Lab4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutionThread extends Thread {
    int name;
    Lock lock;

    public ExecutionThread(int name, Lock lock) {
        this.name = name;
        this.lock = lock;
    }

    public void run() {
        System.out.println("Thread " + name + " at STATE 1");
        if (getName().equals("1")) {
            int k = (int) Math.round(Math.random()* (4 - 2) + 2);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }
        else if (getName().equals("2")) {
            int k = (int) Math.round(Math.random()* (5 - 3) + 3);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }

        this.lock.lock();
        System.out.println("Thread " + name + " acquired the lock");
        criticalRegion();

        System.out.println("Thread " + name + " at STATE 2");
        if (getName().equals("1")) {
            int k = (int) Math.round(Math.random()* (6 - 4) + 4);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }
        else if (getName().equals("2")) {
            int k = (int) Math.round(Math.random()* (7 - 5) + 5);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }

        System.out.println("Thread " + name + " at STATE 3");

        this.lock.unlock();
        System.out.println("Thread " + name + " release the lock");

        if (getName().equals("1")) {
            try {
                Thread.sleep(4 * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (getName().equals("2")) {
            try {
                Thread.sleep(5 * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread " + name + " at STATE 4");
    }

    public void criticalRegion() {
        System.out.println("IS EXECUTION THE CRITICAL REGION!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
