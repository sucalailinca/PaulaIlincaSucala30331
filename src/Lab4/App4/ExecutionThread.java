package Lab4.App4;

public class ExecutionThread extends Thread {
    Integer monitor;
    int sleep_fix;
    int activity_min;
    int activity_max;

    public ExecutionThread (Integer monitor, int activity_min, int activity_max, int sleep_fix) {
        this.activity_max = activity_max;
        this.activity_min = activity_min;
        this.monitor = monitor;
        this.sleep_fix = sleep_fix;
    }

    public void run() {

    }

}
