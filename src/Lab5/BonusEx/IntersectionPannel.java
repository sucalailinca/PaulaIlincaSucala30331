package Lab5.BonusEx;

import javax.swing.*;
import java.awt.*;

public class IntersectionPannel extends JPanel {

    public IntersectionPannel() {

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(0, 300, 300, 300);
        g2d.drawLine(0, 500, 300, 500);
        g2d.drawLine(500, 300, 800, 300);
        g2d.drawLine(500, 500, 800, 500);
        g2d.drawLine(300, 300, 300, 0);
        g2d.drawLine(500, 300, 500, 0);
        g2d.drawLine(300, 500, 300, 800);
        g2d.drawLine(500, 500, 500, 800);

        g.drawRect(250, 200, 30, 80);
        g.drawRect(520, 520, 30, 80);

        g.drawRect(520, 260, 80, 30);
        g.drawRect(200, 520, 80, 30);

        g.drawOval(525, 265, 20, 20);
        g.drawOval(555, 265, 20, 20);


        g.drawOval(205, 525, 20, 20);
        g.drawOval(245, 525, 20, 20);

        g.drawOval(255, 205, 20, 20);
        g.drawOval(255, 245, 20, 20);

        g.drawOval(525, 565, 20, 20);
        g.drawOval(525, 525, 20, 20);

        float[] dashPattern = {5, 5};
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, dashPattern, 0));
        g2d.drawLine(0, 400, 800, 400);
        g2d.drawLine(400, 0, 400, 800);


    }
}

