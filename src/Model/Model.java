package Model;

import View.IView;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.List;

/**
 * Created by cassiehanyu on 2016-01-20.
 */
public class Model {

    private GameState gameState;

    //region gameElement
    private BallElement ball = new BallElement();
    private PaddleElement paddle = new PaddleElement();
    private List<BrickElement> bricks = new ArrayList<>(48);
    private List<Color> colors = new ArrayList<Color>(){{
        add(Color.WHITE);
        add(Color.CYAN);
        add(Color.GREEN);
        add(Color.MAGENTA);
        add(Color.BLUE);
        add(Color.ORANGE);
    }};
    private int gameScore;
    //endregion

    private double preWin_Width, preWin_Height;
    private double win_width, win_height;

    Timer move;

    public Model(){
        System.out.println(bricks.size());
        gameState = GameState.BEFORESTART;

//        paddle = new PaddleElement(0 ,0, win_width/10);

        setBricksPosAndSize();

        gameScore = 0;

        move = new Timer();
        move.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisionWithWall();
                checkCollisionWithPaddle();
                checkCollisionWithBricks();
                ball.move();
            }
        }, 0, 5);
    }




    //region Getter
    public BallElement getBall() {
        return ball;
    }

    public PaddleElement getPaddle()
    {
        return paddle;
    }

    public ArrayList<BrickElement> getBricks() {
        return (ArrayList)bricks;
    }

//    public double getWin_width() {
//        return win_width;
//    }
//
//    public double getWin_height() {
//        return win_height;
//    }

    public GameState getGameState() {
        return gameState;
    }

    public int getGameScore(){
        return gameScore;
    }
    //endregion

    //region setter
    public void setWin_width(int width) {
        win_width = width;
    }

    public void setWin_height(int height)
    {
        win_height = height;
    }



    public void movePaddle(boolean positive){
        paddle.move(positive,win_width);
    }
    //endregion

    //region GameElement Initialization
    public void sizeHandler(int curWin_Width, int curWin_Height){
        System.out.println("try to resize window");
        preWin_Width = win_width;
        preWin_Height = win_height;
        win_width = curWin_Width;
        win_height = curWin_Height;
        setPaddlePosAndSize();
        setBallPosAndSize();
        setBricksPosAndSize();
    }

    private void setBallPosAndSize(){
        ball.setDiameter(win_height/35);
        if(ball.getPos_x() == 0 && ball.getPos_y() == 0) {
            ball.setPos_x(paddle.getShape().getCenterX() - ball.getDiameter() / 2);
            ball.setPos_y(paddle.getPos_y() - ball.getDiameter() - 3);
            ball.setVx(0);
            ball.setVy(0);
        }
    }

    private void setPaddlePosAndSize(){
        paddle.setLength(win_width/10);
        paddle.setHeight(win_height/30);
        if(paddle.getPos_x() == 0 && paddle.getPos_y() == 0) {
            paddle.setPos_x((win_width - paddle.get_length()) / 2);
            System.out.println(paddle.getPos_x());
        }else{
            paddle.setPos_x(paddle.getPos_x()/preWin_Width * win_width);
        }
        paddle.setPos_y(win_height*19/20 - paddle.get_height());
        paddle.setVx(win_width/10);
    }

    private void setBricksPosAndSize() {
        double start_x = win_width/25;
        double start_y = win_height/25;
        double height = (win_height-2*start_y)/18;
        double width = (win_width-2*start_x)/8;
        double h_gap = width/10;
        double v_gap = height/5;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 8; j++){
                int index = i*8+j;
                if(bricks.size() < 48){
                    System.out.println(bricks.size());
                    bricks.add(new BrickElement(start_x+j*width,start_y+i*height,width-h_gap,height-v_gap,colors.get(i)));
                }
                else{
                    bricks.get(index).setPos_x(start_x + j*width);
                    bricks.get(index).setPos_y(start_y + i*height);
                    bricks.get(index).setWidth(width - h_gap);
                    bricks.get(index).setHeight(height - v_gap);
                }
            }
        }
    }
    //endregion

    //region checkCollision
    public void checkCollisionWithWall() {
        if(ball.pos_x < 0){
            ball.setRight(true);
//                    right = true;
        }
        if(ball.pos_x >= win_width - ball.getDiameter()){
            ball.setRight(false);
//                    right = false;
        }
        if(ball.pos_y <= 0){
            ball.setDown(true);
//                    down = true;
        }
        //needs to change to end of game, add game state to control this
        if(ball.pos_y > win_height - ball.getDiameter()){
            ball.setDown(false);
//                    down = false;
        }
    }

    public void checkCollisionWithPaddle() {
        if(ball.getShape().intersects(paddle.getShape())){
            ball.setDown(false);
//                    down = false;
        }
    }

    public void checkCollisionWithBricks() {
        for(BrickElement brick : bricks){
            if(brick.getShape().intersects(ball.getShape()) && !brick.getDestoryed()){
                System.out.println(brick.getShape().getX());
                System.out.println(brick.getShape().getX() + brick.getShape().getWidth());
                System.out.println(brick.getShape().getY());
                System.out.println(brick.getShape().getY() + brick.getShape().getHeight());
                System.out.println();
//                        Rectangle2D brickRect = ball.getShape();

                double ballLeft =  ball.getShape().getMinX();
                System.out.println("ballLeft: " + ballLeft);
                double ballHeight =  ball.getShape().getHeight();
                System.out.println("BallHeight: " + ballHeight);
                double ballWidth =  ball.getShape().getWidth();
                System.out.println("BallWidth: " + ballWidth);
                double ballTop =  ball.getShape().getMinY();
                System.out.println("Balltop: " + ballTop);
                double ballXCenter = ball.getShape().getCenterX();
                double ballYCenter = ball.getShape().getCenterY();

                Point.Double pointRightTop = new Point.Double(ballLeft + ballWidth + 1, ballTop);
                Point.Double pointRightCenter = new Point.Double(ballLeft + ballWidth, ballYCenter);
                Point.Double pointLeftTop = new Point.Double(ballLeft - 1, ballTop);
                Point.Double pointLeftCenter = new Point.Double(ballLeft - 1, ballYCenter);
                Point.Double pointTopCenter = new Point.Double(ballLeft, ballTop - 1);
                Point.Double pointLeftBottom = new Point.Double(ballLeft, ballTop + ballHeight + 1);
                Point.Double pointRightBottom = new Point.Double(ballLeft + ballWidth, ballTop + ballHeight);
                Point.Double pointBottomCenter = new Point.Double(ballXCenter, ballTop+ballHeight);

                if(brick.getShape().contains(pointRightTop) && brick.getShape().getMinX() > ballXCenter){
                    System.out.println("checked0: " + brick.getShape().getX());
                    ball.setRight(false);
//                            right = false;
                } else if(brick.getShape().contains(pointLeftTop) && brick.getShape().getMaxX() < ballXCenter) {
                    ball.setRight(true);
//                            right = true;
                }

//                        if (brick.getShape().contains(pointTopCenter)){
                if (brick.getShape().contains(pointTopCenter) ||
                        (brick.getShape().contains(pointRightTop) && brick.getShape().getMaxY() < ballYCenter) ||
                        (brick.getShape().contains(pointLeftTop) && brick.getShape().getMaxY() < ballYCenter)){// || brick.getShape().contains(pointLeftTop)) {
                    ball.setDown(true);
//                            down = true;
                } else if (brick.getShape().contains(pointBottomCenter) ||
                        (brick.getShape().contains(pointRightBottom) && brick.getShape().getMinX() > ballXCenter) ||
                        (brick.getShape().contains(pointLeftTop) && brick.getShape().getMaxX() > ballXCenter)) {
                    ball.setDown(false);
//                            down = false;
                }
                brick.setDestroyed(true);
                gameScore++;
            }

        }
    }
    //endregion

    //region game state change
    public void startGame(){
        if(gameState == GameState.BEFORESTART)
            gameState = GameState.START;
    }

    public void readSpec(){
        if(gameState == GameState.BEFORESTART)
            gameState = GameState.READSPEC;
    }

    public void runGame(){
        if(gameState == GameState.START){
            gameState = GameState.RUNNING;
            ball.setVx(0.5);
            ball.setVy(0.5);
        }

    }
    public void loseGame(){
        if(gameState == GameState.RUNNING) {
            gameState = GameState.ENDLOSE;
        }
    }

    public void winGame() {
        if(gameState == GameState.RUNNING){
            gameState = GameState.ENDWIN;
        }
    }




    //endregion
}
