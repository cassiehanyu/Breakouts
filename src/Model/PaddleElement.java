package Model;

/**
 * Created by cassiehanyu on 2016-01-23.
 */
public class PaddleElement extends GameElement{

    private double length;
    private double height;

    public PaddleElement(double x, double y, double vx) {
        super(x,y,vx,0);
        length = 50;
        height = 15;
    }

    public void move(boolean positive, int win_width){
        System.out.println("Width = " + win_width);
        int direction = 0;
        if(positive && pos_x < win_width - 1.5 * length) {
            direction = 1;
//            pos_x += vx;
        }else if(!positive && pos_x > 5){
            direction = -1;
//            pos_x -= vx;
        }
        for(int i = 0; i < 8; i++){
            pos_x += direction * vx;
        }
    }

    public double get_length(){
        return length;
    }

    public double get_height() {
        return height;
    }
}
