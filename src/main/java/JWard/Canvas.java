package JWard;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import JWard.Dot;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private ArrayList<Dot> dots = new ArrayList<Dot>(); 

    public Canvas(){
        addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent event) {
                    dots.add(new Dot(event.getX(), event.getY()));
                    Canvas.super.repaint();
                }
            });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Dot dot: this.dots)
            dot.drawDot(g);

    }
}
