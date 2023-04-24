package Lab5.App3;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread1 = new Thread(new Consumer(buffer, "Consumer1"));
        Thread consumerThread2 = new Thread(new Consumer(buffer, "Consumer2"));
        Thread consumerThread3 = new Thread(new Consumer(buffer, "Consumer3"));

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
    }
}
