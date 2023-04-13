package Lab4.App4;

public class Main {
    public static void main (String[] args) {
        Integer[] monitor = {0, 1};
        int sleep_fix, activity_min, activity_max;

        new ExecutionThread(monitor,  0, 2, 3).start();
        new ExecutionThread(monitor,  0, 3, 5).start();
        new ExecutionThread(monitor,  0, 4, 6).start();

    }
}



