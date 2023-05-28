package Lab6.App2Lab6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ExecutionThread extends Thread {
    CyclicBarrier cyclicBarrier;
    Integer monitor;
    volatile FileWriter fileWriter;
    static int result = 0;
    int iterations;
    public ExecutionThread(CyclicBarrier cyclicBarrier, FileWriter fileWriter, Integer monitor){
        this.cyclicBarrier = cyclicBarrier;
        this.iterations = 0;
        this.fileWriter = fileWriter;
        this.monitor = monitor;
    }

    public void run(){
        System.out.println(this.getName() + " is activate");
        while(true){
            try {
                Random random = new Random();
                int min = -10;
                int max = 10;
                result = min + random.nextInt(max - min + 1);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(result);
            if (result == 0) {
                synchronized (monitor) {
                    try {
                        fileWriter.write(this.getName() + iterations + '\n');
                        System.out.println(this.getName() + " : " + iterations + '\n');
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            iterations++;
        }
    }
}
