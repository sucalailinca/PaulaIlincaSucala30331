package Lab2.App3;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Moving Squares");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        SquarePanel panel = new SquarePanel();

        frame.add(panel);
        frame.setVisible(true);

        Mover mover1 = new Mover(panel, 0, 10, 50);
        Mover mover2 = new Mover(panel, 1, 5, 15);
        Mover mover3 = new Mover(panel, 2, 1, 5);

        mover1.start();
        mover2.start();
        mover3.start();
    }
}
