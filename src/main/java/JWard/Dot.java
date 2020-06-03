package JWard;

import java.awt.Graphics;


class Dot {
    private int x, y;

    public Dot(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void drawDot(Graphics g){
        g.drawLine(this.getX(), this.getY(), this.getX(), this.getY());
    }
}
