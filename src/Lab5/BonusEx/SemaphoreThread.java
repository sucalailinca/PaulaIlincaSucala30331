package Lab5.BonusEx;

import java.util.concurrent.Semaphore;

public class SemaphoreThread extends Thread {
    int name, howManyCars , permit, cars;
    Semaphore s;

    SemaphoreThread(int name, int howManyCars, int permit, Semaphore s) {
        this.name = name;
        this.howManyCars = howManyCars;
        this.permit = permit;
        this.s = s;
    }

    public void run() {
        //while (true) {
            try {
                System.out.println("Fir " + name +" State 1");

                this.s.acquire(this.permit); // critical region
                System.out.println("Fir " + name + " took a token from the semaphore");
                System.out.println("Fir " + name +" State 2");

                /*for (int i = 0; i < howManyCars * 100000; i++) {
                    i++;
                    i--;
                }*/

                if (howManyCars > 10) {
                    cars = 10;
                } else {
                    cars = howManyCars;
                }
                Thread.sleep(cars * 1000);
                System.out.println(cars + " cars go from queue");

                this.s.release(this.permit); // end of critical region
                System.out.println("Fir " + name + " released a token from the semaphore");
                System.out.println("Fir " + name +" State 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       // }
    }

}
