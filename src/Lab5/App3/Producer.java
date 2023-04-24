package Lab5.App3;

import java.util.Random;

public class Producer implements Runnable {
    private final Buffer buffer;
    private final Random random = new Random();

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int number = random.nextInt();
                buffer.add(number);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
