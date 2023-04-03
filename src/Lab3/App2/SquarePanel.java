package Lab3.App2;

import javax.swing.*;
import java.awt.*;

public class SquarePanel extends JPanel {
    private Rectangle[] squares = new Rectangle[3];

    public SquarePanel() {
        squares[0]=new Rectangle(50, 300, 50, 50);
        squares[1]=new Rectangle(150, 300, 50, 50);
        squares[2]=new Rectangle(900, 300, 50, 50);
    }

    synchronized public void moveSquare(int id, int dx, int dy) {
        squares[id].translate(dx, dy);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < squares.length; i++) {
            g.setColor(Color.BLUE);
            g.fillRect(squares[i].x, squares[i].y, squares[i].width, squares[i].height);
        }
    }

    public boolean isOutOfBounds(int id) {
        return squares[id].y > getHeight();
    }

    public boolean touchedTheLine(int dx, int id){
        if(id == 0 || id == 1){
            if(squares[id].x >= dx)
                return true;}
        else if(squares[id].x <= dx )
            return true;
        return false;
    }
}
