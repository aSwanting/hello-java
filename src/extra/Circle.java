package extra;

import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class Circle extends JPanel {

    int circleR = 30;
    int xPos = 100;
    int yPos = 0;
    int xDir = 3;
    int yDir = 3;

    private void moveCircle() {

    if (xPos < 0) xDir *= -1;
    if (xPos > getWidth() - circleR) xDir *= -1;

    if (yPos < 0) yDir *= -1;
    if (yPos > getHeight() - circleR) yDir *= -1;

    xPos = xPos + xDir;
    yPos = yPos + yDir;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillOval(xPos,yPos,circleR,circleR);

    }

    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame();
        Circle circle = new Circle();
        frame.add(circle);

        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            circle.moveCircle();
            circle.repaint();
            Thread.sleep(10);
        }
    }
}