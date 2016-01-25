package Model;

import java.awt.*;

/**
 * Created by cassiehanyu on 2016-01-23.
 */
public abstract class GameElement {

    protected double pos_x, pos_y;
    protected double vx, vy;

    public GameElement(double x, double y, double vx, double vy) {
        this.pos_x = x;
        this.pos_y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public double getPos_x(){
        return pos_x;
    }

    public double getPos_y(){
        return pos_y;
    }

    public void setPos_x(double x) {
        pos_x = x;
    }

    public void setPos_y(double y) {
        pos_y = y;
    }

}

