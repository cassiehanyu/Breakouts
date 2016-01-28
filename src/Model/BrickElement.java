package Model;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by cassiehanyu on 2016-01-25.
 */
public class BrickElement extends GameElement{

    private double height;
    private double width;
    private boolean destroyed;
    Color color = Color.black;

    public BrickElement(double x, double y, double width, double height, Color c){
        this.pos_x = x;
        this.pos_y = y;
        this.width = width;
        this.height = height;
        this.color = c;
        this.destroyed = false;
    }


    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Color getColor(){
        return color;
    }

    public boolean getDestoryed() {
        return destroyed;
    }

    protected void setDestroyed(boolean d){
        this.destroyed = d;
    }

    protected void setWidth(double width){
        this.width = width;
    }

    protected void setHeight(double height){
        this.height = height;
    }


    public Rectangle2D getShape()
    {
        return new Rectangle2D.Double(pos_x, pos_y, width, height);
    }

}
