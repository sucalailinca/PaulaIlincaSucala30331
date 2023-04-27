package Lab5.BonusEx;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class CarGeneratorThread extends Thread {

    private final BlockingQueue<Car>[] queues;
    private final int[] numCarsToGenerate;
    private final Random random;

    public CarGeneratorThread(BlockingQueue<Car>[] queues, int[] numCarsToGenerate) {
        this.queues = queues;
        this.numCarsToGenerate = numCarsToGenerate;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int queueIndex = 0; queueIndex < queues.length; queueIndex++) {
            for (int i = 0; i < numCarsToGenerate[queueIndex]; i++) {
                Car car = new Car();
                try {
                    queues[queueIndex].put(car);
                } catch (InterruptedException e) {
                    System.err.println("CarGeneratorThread was interrupted while adding a car to a queue.");
                    Thread.currentThread().interrupt();
                }
                System.out.println("Added car " + car.getId() + " to queue " + queueIndex);
                try {
                    Thread.sleep(random.nextInt(500)); // Sleep for up to 500 milliseconds
                } catch (InterruptedException e) {
                    System.err.println("CarGeneratorThread was interrupted while sleeping.");
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
