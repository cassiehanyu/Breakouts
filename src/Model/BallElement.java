package Model;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by cassiehanyu on 2016-01-23.
 */
public class BallElement extends GameElement {

    private final double radius;

    Timer move;

    public BallElement(double x, double y, double vx, double vy) {
        super(x,y,vx,vy);
        radius = 15;
//
//        move = new Timer();
//        move.scheduleAtFixedRate(new TimerTask() {
//            int x = 1, y = 1;
//            @Override
//            public void run() {
//                if(pos_x < 0){
//                    x = 1;
//                }
//                if(pos_x > 700 - 15){
//                    x = -1;
//                }
//                if(pos_y < 0){
//                    y = 1;
//                }
//                if(pos_y > 400 - 15){
//                    y = -1;
//                }
//                pos_x = pos_x + x;
//                pos_y = pos_y + y;
//            }
//        }, 0, 5);
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


    public double get_radius(){
        return radius;
    }

    public void move(boolean keep_x, boolean keep_y){
        int x;
        int y;
        x = (keep_x) ? 1 : -1;
        y = (keep_y) ? 1 : -1;

        pos_x += x * vx;
        pos_y += y * vy;
    }


}
