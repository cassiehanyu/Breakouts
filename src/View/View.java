package View;


import Model.Model;
import Model.BrickElement;
import Model.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.Timer;


public class View extends JPanel implements IView {

    Model model;

    StartView startView;

    JLabel label_StartGame = new JLabel("Start Game");
    JLabel label_HowToStart = new JLabel("How To Play?");
    JLabel label_Return = new JLabel("Return");
    JLabel label_score = new JLabel("");
    java.util.Timer move;

    public View(Model model) {
        this.model = model;
//        this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));

//        model.addView(this);
        setDoubleBuffered(true);

        move = new Timer();
        move.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                View.this.repaint();
            }
        }, 0, 5);

    }

    public void initUI() {
        System.out.println(this.getWidth());
        System.out.println(this.getHeight());


//        model.sizeHandler(this.getWidth(), this.getHeight());

        System.out.println(this.getHeight());

        this.setLayout(new BorderLayout());
//        this.setLayout(new GridBagLayout());
        this.setBackground(Color.black);


        Box horBox = Box.createHorizontalBox();
        Box verBox = Box.createVerticalBox();
        this.add(horBox);
//        this.add(verBox);
        horBox.add(Box.createHorizontalGlue());
        horBox.add(verBox);
        verBox.add(Box.createHorizontalGlue());
        verBox.add(label_StartGame);
        verBox.add(Box.createVerticalStrut(this.getHeight()/15));
        verBox.add(label_HowToStart);
        label_StartGame.setForeground(Color.yellow);
        label_HowToStart.setForeground(Color.yellow);
//        horBox.add(Box.createHorizontalStrut(1));

        Box southBox = Box.createHorizontalBox();
        this.add(label_score,BorderLayout.SOUTH);
//        southBox.add(label_score);
        label_score.setForeground(Color.white);
        this.setFocusable(true); //set focus on startView

        /**
         * enter: start game/how to play
         * down: move down to how to play
         * up: move up to start game
         */
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_ENTER:
                        System.out.println("enter");
                        View.this.repaint();
                        break;
                    case KeyEvent.VK_UP:
                        System.out.println("up");
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("left");
                        model.movePaddle(false);
                        break;
                    case KeyEvent.VK_RIGHT:
                        System.out.println("right");
                        model.movePaddle(true);
                        break;
                    case KeyEvent.VK_SPACE:
                        System.out.println("space");
                        model.runGame();
                    default:
                        break;
                }
            }
        });

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                model.sizeHandler(View.this.getWidth(), View.this.getHeight());
            }
        });

        label_StartGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                model.startGame();
                model.sizeHandler(View.this.getWidth(), View.this.getHeight());
                System.out.println("22222222b");
            }
        });

        label_HowToStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                model.readSpec();
                System.out.println("2222222222B");
            }
        });



//        mainFrame.setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        label_StartGame.setVisible(false);
        label_HowToStart.setVisible(false);
        label_score.setVisible(true);
        label_Return.setVisible(false);
        if(model.getGameState() == GameState.BEFORESTART){
//            System.out.println("check paint");
            label_StartGame.setVisible(true);
            label_HowToStart.setVisible(true);
        }else if(model.getGameState() == GameState.READSPEC){


        }
        else if(model.getGameState() == GameState.START || model.getGameState() == GameState.RUNNING) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.DARK_GRAY);
            Shape ball = new Ellipse2D.Double(model.getBall().getPos_x(), model.getBall().getPos_y(),
                    model.getBall().getDiameter(), model.getBall().getDiameter());
            g2d.draw(ball);
//        g2d.fillOval((int)model.getBall().getPos_x(), (int)model.getBall().getPos_y(),
//                (int)model.getBall().getDiameter(), (int)model.getBall().getDiameter());
            Shape paddle = new Rectangle2D.Double(model.getPaddle().getPos_x(), model.getPaddle().getPos_y(),
                    model.getPaddle().get_length(), model.getPaddle().get_height());

//        g.fillRect((int)model.getPaddle().getPos_x(), (int)model.getPaddle().getPos_y(),
//                (int)model.getPaddle().get_length(), (int)model.getPaddle().get_height());
            g2d.draw(paddle);
//        g.fillRect(0,0,30,10);

            ArrayList<BrickElement> bricks = model.getBricks();
            for (BrickElement brick : bricks) {
                g2d.setColor(brick.getColor());
//            System.out.println(brick.getWidth());
                if (!brick.getDestoryed()) {
                    Shape b = new Rectangle2D.Double(brick.getPos_x(), brick.getPos_y(), brick.getWidth(), brick.getHeight());
                    ((Graphics2D) g).draw(b);
                }
            }
            label_score.setText("Socre: " + model.getGameScore());
            label_score.setVisible(true);
//        startView = new StartView(this.getWidth() * 2/5,this.getHeight() * 3/7);
//        startView.setFocusable(true); //set focus on startView
//
//        GridBagConstraints c = new GridBagConstraints();
//        c.anchor = GridBagConstraints.CENTER;
//        c.gridx = 1;
//        c.gridy = 1;
//        c.fill = GridBagConstraints.HORIZONTAL;
//        this.add(startView, c);
        }else if(model.getGameState() == GameState.END){

        }


    }
    @Override
    public void updateView(){
        repaint();
    }
}
