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
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.JColorChooser;


public class Canvas extends JPanel {
    private ArrayList<Segment> segments = new ArrayList<Segment>();

    public Canvas(JSpinner strokeSpinner, JColorChooser colorChooser){
        addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent event) {
                    Dot dot = new Dot(event.getX(), event.getY());
                    segments.add(new Segment(dot, dot, (int)strokeSpinner.getValue(), (Color)colorChooser.getColor()));
                    Canvas.super.repaint();
                }
            });

        addMouseMotionListener(new MouseAdapter() {
                public void mouseDragged(MouseEvent event) {
                    Dot dot = new Dot(event.getX(), event.getY());
                    segments.add(new Segment(segments.get(segments.size() - 1).getEnd(), dot, (int)strokeSpinner.getValue(),
                                                                                              (Color)colorChooser.getColor()));
                    Canvas.super.repaint();
                }
            });
    }
 
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Segment seg: this.segments)
            seg.drawSeg(g);
    }
}
