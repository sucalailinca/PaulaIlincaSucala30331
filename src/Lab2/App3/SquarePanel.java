package Lab2.App3;

import javax.swing.*;
import java.awt.*;

public class SquarePanel extends JPanel {
    private Rectangle[] squares = new Rectangle[3];

    public SquarePanel() {
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Rectangle(50 + i * 100, 50, 50, 50);
        }
    }

    public void moveSquare(int id, int dx, int dy) {
        squares[id].translate(dx, dy);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < squares.length; i++) {
            g.setColor(Color.pink);
            g.fillRect(squares[i].x, squares[i].y, squares[i].width, squares[i].height);
        }
    }

    public boolean isOutOfBounds(int id) {
        return squares[id].y > getHeight();
    }
}
