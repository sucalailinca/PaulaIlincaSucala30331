package Lab6.App2Lab6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("results.txt",true);
            CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
                @Override
                public void run() {
                    System.out.print('\n');
                }
            });
            writer.write("Something");
            Integer monitor1 = 1;
            ExecutionThread fir1 = new ExecutionThread(barrier, writer, monitor1);
            ExecutionThread fir2 = new ExecutionThread(barrier, writer, monitor1);
            ExecutionThread fir3 = new ExecutionThread(barrier, writer, monitor1);
            fir1.start();
            fir2.start();
            fir3.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
