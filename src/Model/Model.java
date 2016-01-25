package Model;

import View.IView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by cassiehanyu on 2016-01-20.
 */
public class Model {

    private BallElement ball;
    private PaddleElement paddle;

    private int win_width, win_height;

    Timer move;

    private List<IView> viewlist = new ArrayList<>();

    public Model(){
        ball = new BallElement(30,30,0.3,0.3);
        paddle = new PaddleElement(0 ,0, 5);



        move = new Timer();
        move.scheduleAtFixedRate(new TimerTask() {
            boolean keep_x = true, keep_y = true;
            @Override
            public void run() {
                if(ball.pos_x < 0){
                    keep_x = true;
                }
                if(ball.pos_x > win_width - ball.get_radius()){
                    keep_x = false;
                }
                if(ball.pos_y < 0){
                    keep_y = true;
                }
                if(ball.pos_y + ball.get_radius() == paddle.pos_y &&
                        ball.pos_x + ball.get_radius()/2 > paddle.pos_x &&
                        ball.pos_x + ball.get_radius()/2 < paddle.pos_x + paddle.get_length()){
                    keep_y = false;
                }
                if(ball.pos_y > win_height - ball.get_radius()){
                    keep_y = false;
                }
                ball.move(keep_x,keep_y);
            }
        }, 0, 5);
    }

    public BallElement get_Ball() {
        return ball;
    }

    public PaddleElement get_Paddle(){
        return paddle;
    }

    public int getWin_width() {
        return win_width;
    }

    public int getWin_height() {
        return win_height;
    }

    public void setWin_width(int width) {
        win_width = width;
    }

    public void setWin_height(int height){
        win_height = height;
    }

    public void movePaddle(boolean positive){
        paddle.move(positive,win_width);

    }

    public void addView(IView view){

    }

    public void removeView(IView view){

    }
}
