package Model;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by cassiehanyu on 2016-01-23.
 */
public class PaddleElement extends GameElement{

    private double length;
    private double height;

    public PaddleElement() {
        super();
        length = 0;
        height = 0;
    }

    public void move(boolean positive, double win_width){
        System.out.println("Width = " + win_width);
        int direction = 0;
        if(positive) {
            if(pos_x <= win_width - 1.5 * length)
                direction = 1;
            else
                pos_x = win_width-length;
        }else if(!positive){
            if( pos_x >= length)
                direction = -1;
            else
                pos_x = 0;
        }
        if(direction != 0) {
            for (int i = 0; i < 10; i++) {
                pos_x += direction * vx / 10;
            }
        }
    }

    public double get_length(){
        return length;
    }

    public double get_height() {
        return height;
    }

    protected void setLength(double length){
        this.length = length;
    }

    protected void setHeight(double height){
        this.height = height;
    }


    public Rectangle2D getShape(){
        return new Rectangle2D.Double(pos_x,pos_y,length,height);


    }
}
