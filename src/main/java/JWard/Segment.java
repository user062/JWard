package JWard;

import java.awt.Graphics;
import JWard.Dot;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.Color;


public class Segment{
    private Dot   start, end;
    private int   stroke;
    private Color color;

    public Segment(Dot start, Dot end, int stroke, Color color){
        this.start  = start;
        this.end    = end;
        this.stroke = stroke;
        this.color  = color;
    }

    public Dot getStart(){
        return this.start;
    }

    public Dot getEnd(){
        return this.end;
    }

    public void drawSeg(Graphics g){
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D)g).setStroke(new BasicStroke(this.stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        ((Graphics2D)g).setPaint(this.color);
        g.drawLine(this.start.getX(), this.start.getY(), this.end.getX(), this.end.getY());
    }
}
