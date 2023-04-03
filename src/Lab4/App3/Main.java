package Lab4.App3;

import Lab4.App1.ExecutionThread;

public class Main {
    public static void main(String[] args) {
        Integer monitor = new Integer(1);

        new ExecutionThread(monitor, 4, 7, 3).start();
        new ExecutionThread(monitor, 3, 6, 5).start();
        new ExecutionThread(monitor, 5, 7, 6).start();

    }

}
