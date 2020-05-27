package JWard;

import javax.swing.JPanel;
import java.awt.Graphics;

public class Canvas extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("hello", 20, 50);
    }
}
