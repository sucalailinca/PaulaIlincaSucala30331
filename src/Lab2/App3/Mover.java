package Lab2.App3;

import java.util.Random;

public class Mover extends Thread {
    private SquarePanel panel;
    private int id;
    private int minSpeed;
    private int maxSpeed;
    private boolean stopped;

    public Mover(SquarePanel panel, int id, int minSpeed, int maxSpeed) {
        this.panel = panel;
        this.id = id;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    public void run() {
        Random random = new Random();

        while (!panel.isOutOfBounds(id) && !stopped) {
            int dx = 0;
            int dy = random.nextInt(maxSpeed - minSpeed + 1) + minSpeed;

            panel.moveSquare(id, dx, dy);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopMoving() {
        stopped = true;
    }
}
