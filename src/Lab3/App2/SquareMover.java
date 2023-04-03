package Lab3.App2;

import java.util.Random;

public class SquareMover extends Thread {
    private SquarePanel panel;
    public int id;
    private int minSpeed;
    private int maxSpeed;
    private boolean stopped;
    private static boolean oneTouchedTheLine = false;
    private static boolean oneStopped=false;

    public SquareMover(SquarePanel panel, int id, int minSpeed, int maxSpeed) {
        this.panel = panel;
        this.id = id;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    public void run() {
        Random random = new Random();
        synchronized (this){
            while (!panel.isOutOfBounds(id) && !stopped ) {
                if (id == 0 || id == 1) {
                    int dx = random.nextInt(maxSpeed - minSpeed + 1) + minSpeed;
                    int dy = 0;

                    this.panel.moveSquare(id, dx, dy);

                } else {
                    int dx = -random.nextInt(maxSpeed - minSpeed + 1) - minSpeed;
                    int dy = 0;

                    panel.moveSquare(id, dx, dy);
                }


                try {
                    Thread.sleep(50);
                    if(oneTouchedTheLine && !oneStopped) {
                        oneStopped = true;
                    }
                    if(!oneTouchedTheLine && panel.touchedTheLine(300,id)){
                        oneTouchedTheLine = true;
                        stopMoving();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }}
    }

    public void stopMoving() {
        try {
            stopped = true;
            this.join();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
