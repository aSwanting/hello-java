package extra;

import javax.swing.*;
import java.awt.*;

public class AnimationTesting extends JPanel {
    int circleNumber = 50;
    int frameSize = 300;
    int[] circlesR = new int[circleNumber];
    int[] circlesX = new int[circleNumber];
    int[] circlesY = new int[circleNumber];
    int[] circlesVX = new int[circleNumber];
    int[] circlesVY = new int[circleNumber];


    public AnimationTesting() {
        for (int i = 0; i < circleNumber; i++) {
            circlesR[i] = (int) (Math.random() * 30) + 10;
            circlesX[i] = (int) (Math.random() * (frameSize - circlesR[i]));
            circlesY[i] = (int) (Math.random() * (frameSize - circlesR[i]));
            circlesVX[i] = (int) (Math.random() * 8) + 1;
            circlesVY[i] = (int) (Math.random() * 8) + 1;
        }
    }

    public void moveCircle() {
        for (int i = 0; i < circleNumber; i++) {
            if (circlesX[i] < 0 || circlesX[i] > getWidth() - circlesR[i]) circlesVX[i] *= -1;
            if (circlesY[i] < 0 || circlesY[i] > getHeight() - circlesR[i]) circlesVY[i] *= -1;
            circlesX[i] += circlesVX[i];
            circlesY[i] += circlesVY[i];
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0, 50, 20, 50));

        for (int i = 0; i < circleNumber; i++) {
            g2d.fillOval(circlesX[i], circlesY[i], circlesR[i], circlesR[i]);
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Create testFrame and testPanel
        JFrame testFrame = new JFrame("test frame");
        AnimationTesting testPanel = new AnimationTesting();

//        Add panel to frame, set desired size and pack frame around it
        testFrame.add(testPanel);
        testPanel.setPreferredSize(new Dimension(testPanel.frameSize, testPanel.frameSize));
        testFrame.pack();

//        Make frame visible, exit on close
        testFrame.setVisible(true);
        testFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        while (true) {
            testPanel.moveCircle();
            testPanel.repaint();
            Thread.sleep(16);
        }
    }
}
