package Lab3.App2;
import javax.swing.*;
import java.awt.event.*;

public class Main implements ActionListener,KeyListener {
    static boolean start = false;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Moving Squares");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 1000);
        Lines lines = new Lines();
        SquarePanel panel = new SquarePanel();
        frame.add(lines);
        frame.setVisible(true);
        frame.add(panel);
        frame.setVisible(true);


        SquareMover mover1 = new SquareMover(panel, 0, 5, 10);
        SquareMover mover2 = new SquareMover(panel, 1, 10, 20);
        SquareMover mover3 = new SquareMover(panel, 2, 2, 20);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_S){
                    mover1.start();
                    mover2.start();
                    mover3.start();
                }
            }
        });
    }

    public void actionPerformed(ActionEvent actionEvent){
        start = true;
    }

    public void keyPressed(KeyEvent event){
        int code = event.getKeyCode();
        if(code == KeyEvent.VK_S)
            start = true;

    }
    public void keyTyped(KeyEvent event){}
    public void keyReleased(KeyEvent event){}
}
