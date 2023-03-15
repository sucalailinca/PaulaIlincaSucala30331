package Lab2.App2.Model;

import java.util.Observable;

public class Fir extends Observable implements Runnable {
    private final int id;
    private final int processorLoad;

    public Fir(int id, int processorLoad) {
        this.id = id;
        this.processorLoad = processorLoad;
    }

    @Override()
    public void run() {
        int c = 0;
        while (c < 1000) {
            for (int j = 0; j < this.processorLoad; j++){
                j++;
                j--;
            }
            c++;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            this.setChanged();
            this.notifyObservers(new UpdateNotif(this.id, c));
        }
    }
}
