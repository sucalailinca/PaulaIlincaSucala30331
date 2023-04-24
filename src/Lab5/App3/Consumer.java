package Lab5.App3;

public class Consumer implements Runnable {
    private final Buffer buffer;
    private final String name;

    public Consumer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffer.remove();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
