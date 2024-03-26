package extra;

import java.awt.*;
import javax.swing.*;

class GeometricShape extends JPanel{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new GeometricShape());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(940,240);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {

        int xPos = 0;
        int yPos = 0;

        for (int i = 0; i < 50; i++) {
            xPos += 16 ;
            yPos += 2 ;
            g.drawOval(xPos,yPos,2 * i  ,2 * i);
        }

    }
}