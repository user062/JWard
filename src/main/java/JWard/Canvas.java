package JWard;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;
import JWard.Dot;
import java.util.ArrayList;
import JWard.Segment;
import java.awt.event.MouseEvent;


public class Canvas extends JPanel {
    private ArrayList<Dot>     dots     = new ArrayList<Dot>(); 
    private ArrayList<Segment> segments = new ArrayList<Segment>();

    public Canvas(){
        addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent event) {
                    dots.add(new Dot(event.getX(), event.getY()));
                    Canvas.super.repaint();
                }
            });

        addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent event) {
                    Dot dot = new Dot(event.getX(), event.getY());
                    segments.add(new Segment(dot, dot));
                    Canvas.super.repaint();
                }
            });

        addMouseMotionListener(new MouseAdapter() {
                public void mouseDragged(MouseEvent event) {
                    Dot endPos = new Dot(event.getX(), event.getY());
                    segments.add(new Segment(segments.get(segments.size() - 1).getEnd(), endPos));
                    Canvas.super.repaint();
                }
            });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Dot dot: this.dots)
            dot.drawDot(g);

        for(Segment seg: this.segments)
            seg.drawSeg(g);
    }
}
