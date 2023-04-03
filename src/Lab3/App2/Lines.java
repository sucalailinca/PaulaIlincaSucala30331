package Lab3.App2;

import javax.swing.*;
import java.awt.*;

public class Lines extends JPanel{

    @Override
    public void paint(Graphics graphics){
        graphics.setColor(Color.BLACK);

        graphics.drawLine(0,150,400,150);
        graphics.drawLine(0,500,400,500);
        graphics.drawLine(650,150,1000,150);
        graphics.drawLine(650,500,1000,500);
        graphics.drawLine(400,250,650,250);
        graphics.drawLine(400,400,650,400);

        graphics.drawLine(400,150,400,250);
        graphics.drawLine(650,150,650,250);
        graphics.drawLine(400,400,400,500);
        graphics.drawLine(650,400,650,500);

        graphics.drawLine(350, 250,350,400);
        graphics.drawLine(700, 250,700,400);

        super.repaint();
    }

}
