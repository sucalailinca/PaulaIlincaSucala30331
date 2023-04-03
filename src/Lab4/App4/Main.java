package Lab4.App4;

import Lab4.App1.ExecutionThread;

public class Main {
    public static void main(String[] args) {
        Integer monitor = new Integer(1);

        new ExecutionThread(monitor, 2, 3, 7);
    }
}
