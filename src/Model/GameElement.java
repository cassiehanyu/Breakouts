package Model;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by cassiehanyu on 2016-01-23.
 */
public abstract class GameElement {

    protected double pos_x, pos_y;
    protected double vx, vy;

    public GameElement() {
        this.pos_x = 0;
        this.pos_y = 0;
        this.vx = 0;
        this.vy = 0;
    }

//    public void init(double x, double y, double vx, double vy){
//        this.pos_x = x;
//        this.pos_y = y;
//        this.vx = vx;
//        this.vy = vy;
//    }

    public double getPos_x(){
        return pos_x;
    }

    public double getPos_y(){
        return pos_y;
    }

    public double getVx(){
        return vx;
    }

    public double getVy() {
        return vy;
    }

    protected void setPos_x(double x) {
        pos_x = x;
    }

    protected void setPos_y(double y)
    {
        pos_y = y;
    }

    protected void setVx(double vx){
        this.vx = vx;
    }

    protected void setVy(double vy){
        this.vy = vy;
    }

    abstract Rectangle2D getShape();

}

