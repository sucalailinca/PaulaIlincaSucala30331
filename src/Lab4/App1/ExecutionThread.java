package Lab4.App1;


public class ExecutionThread extends Thread {
    Integer monitor;
    int activity_min, activity_max, sleep_fix;

    public ExecutionThread(Integer monitor, int activity_min, int activity_max, int sleep_fix) {
        this.monitor = monitor;
        this.sleep_fix = sleep_fix;
        this.activity_max = activity_max;
        this.activity_min = activity_min;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        synchronized (monitor) {
            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random()*(activity_max - activity_min) - activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++; i--;
            }
        }
        try {
            Thread.sleep(sleep_fix * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " - STATE 3");
    }
}
