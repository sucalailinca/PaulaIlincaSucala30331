package Lab4.App1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] monitor = {0, 1};

        new ExecutionThread(monitor, 2, 4, 4).start();
        new ExecutionThread(monitor, 3, 6, 3).start();
        new ExecutionThread(monitor, 2, 5, 5).start();
   
    }
}
