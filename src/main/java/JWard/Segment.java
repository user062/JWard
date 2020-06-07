package JWard;

import java.awt.Graphics;
import JWard.Dot;


public class Segment{
    private Dot start, end;

    public Segment(int xS, int yS, int xE, int yE){
        this.start = new Dot(xS, yS);
        this.end   = new Dot(xE, yE);
    }

    public Segment(Dot start, Dot end){
        this.start = start;
        this.end   = end;
    }

    public Dot getStart(){
        return this.start;
    }

    public Dot getEnd(){
        return this.end;
    }

    public void drawSeg(Graphics g){
        g.drawLine(this.start.getX(), this.start.getY(), this.end.getX(), this.end.getY());
    }
}
