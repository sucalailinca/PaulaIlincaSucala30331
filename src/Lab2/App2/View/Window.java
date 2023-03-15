package Lab2.App2.View;

import javax.swing.*;
import java.util.ArrayList;

public class Window extends JFrame {
    ArrayList<ProgressTracker> threads = new ArrayList<>();

    public Window() {
        setLayout(null);
        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void addThread(ProgressTracker thread) {
        thread.addToFrame(this);
        threads.add(thread);
    }

    public void setThreadProgress(int id, double progress) {
        threads.get(id).setProgress(progress);
    }
}
