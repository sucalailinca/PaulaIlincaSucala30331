package Lab4.App4;

public class ExecutionThread extends Thread{
    Integer[] monitor;
    int sleep_fix, activity_min, activity_max;
    public ExecutionThread(Integer[] monitor, int sleep_fix, int activity_min, int activity_max) {
        this.monitor = monitor;
        this.sleep_fix = sleep_fix;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 0");

        if(this.getName().equals("Thread-0")) {
            try {
                Thread.sleep(sleep_fix * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 1");

            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            synchronized (monitor[0]) {
                synchronized ((monitor[1])) {
                    monitor[0].notify();
                    monitor[1].notify();
                }
            }
            System.out.println(this.getName() + " - STATE 2");
        }
        if(this.getName().equals("Thread-1")) {
            synchronized (monitor[0]) {
                try {
                    monitor[0].wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.getName() + " - STATE 1");
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            System.out.println(this.getName() + " - STATE 2");
        }
        if(this.getName().equals("Thread-2")) {
            synchronized (monitor[1]) {
                try {
                    monitor[1].wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.getName() + " - STATE 1");
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            System.out.println(this.getName() + " - STATE 2");
        }
    }
}