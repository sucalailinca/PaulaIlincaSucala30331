package Lab5.BonusEx;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame("Intersection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        IntersectionPannel panel = new IntersectionPannel();
        frame.add(panel);
        frame.setVisible(true);

        Semaphore s = new Semaphore(10);
        SemaphoreThread thread1, thread2, thread3, thread4;

        BlockingQueue<Car>[] queues = new BlockingQueue[4];
        queues[0] = new LinkedBlockingQueue<>();
        queues[1] = new LinkedBlockingQueue<>();
        queues[2] = new LinkedBlockingQueue<>();
        queues[3] = new LinkedBlockingQueue<>();

        int[] numCarsToGenerate = { 11, 1, 2, 3};
        CarGeneratorThread generatorThread = new CarGeneratorThread(queues, numCarsToGenerate);
        generatorThread.start();

        Thread.sleep(5000);

        thread1 = new SemaphoreThread(1, numCarsToGenerate[0], 10, s);
        thread2 = new SemaphoreThread(2, numCarsToGenerate[1], 10, s);
        thread3 = new SemaphoreThread(3, numCarsToGenerate[2], 10, s);
        thread4 = new SemaphoreThread(4, numCarsToGenerate[3], 10, s);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
