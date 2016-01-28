package Model;

import javafx.scene.shape.Ellipse;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by cassiehanyu on 2016-01-23.
 */
public class BallElement extends GameElement {

    private double diameter;
    private boolean right, down;


    public BallElement() {
        super();
        diameter = 0;
        right = true;
        down = true;
    }

    public void bounceOffVerticalWall(){
        vx = - vx;
    }

    public void bounceOffHorizontalWall(){
        vy = -vy;
    }

//    public void paint(Graphics g){
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2d.setColor(Color.DARK_GRAY);
//        g2d.fillOval(rx,ry,radius,radius);
//    }


    public double getDiameter()
    {
        return diameter;
    }

    public void setDiameter(double dia){
        diameter = dia;
    }

    public void setRight(boolean right){
        this.right = right;
    }

    public void setDown(boolean down){
        this.down = down;
    }


    public void move(){
        int x;
        int y;
        x = (right) ? 1 : -1;
        y = (down) ? 1 : -1;

        pos_x += 1.5 * x * vx;
        pos_y += y * vy;
    }

    public Rectangle2D getShape()
    {
        return new Rectangle2D.Double(pos_x,pos_y,diameter,diameter);
    }


}
