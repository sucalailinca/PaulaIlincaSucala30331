package Lab4.App2;

public class ExecutionThread extends Thread {
    Integer[] monitor;
    int[] activity1;
    int[] activity2;
    int sleep;

    public ExecutionThread (Integer[] monitor, int[] activity1, int[] activity2, int sleep) {
        this.monitor = monitor;
        this.activity1 = activity1;
        this.activity2 = activity2;
        this.sleep = sleep;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int)Math.round(Math.random() * (activity1[1] - activity1[0]) + activity1[0]);
        for ( int i = 0; i < k * 100000; i++) {
            i++; i--;
        }

        if (this.getName().equals("Thread-0")) {
            synchronized (monitor[0]) {
                System.out.println(this.getName() + " - STATE 2");
                k = (int) Math.round(Math.random() * (activity2[1] - activity2[0]) + activity2[0]);
                for ( int i = 0 ; i < k * 100000; i++) {
                    i++; i--;
                }
                synchronized (monitor[1]) {
                    System.out.println(this.getName() + " - STATE 3");
                }

                try {
                    Thread.sleep(sleep * 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        if (this.getName().equals("Thread-1")) {
            synchronized (monitor[1]) {
                System.out.println(this.getName() + " - STATE 2");
                k = (int) Math.round(Math.random() * (activity2[1] - activity2[0]) + activity2[0]);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                synchronized (monitor[0]) {
                    System.out.println(this.getName() + " - STATE 3");
                }
                try {
                    Thread.sleep(sleep * 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(getName() + " - STATE 4");

    }
}
