package View;


import Controller.Controller;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.Timer;


public class View extends JPanel implements IView {

    Model model;
    Controller controller;

    StartView startView;

    java.util.Timer move;

    public View(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;

//        model.addView(this);



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

        model.setWin_width(this.getWidth());
        model.setWin_height(this.getHeight());

        model.get_Paddle().setPos_x((this.getWidth()- model.get_Paddle().get_length())/2);
        model.get_Paddle().setPos_y(this.getHeight() - model.get_Paddle().get_height());

        System.out.println(this.getHeight());

        this.setBackground(Color.black);
        this.setLayout(new GridBagLayout());

//        startView = new StartView(this.getWidth() * 2/3,this.getHeight() * 2/3);
        this.setFocusable(true); //set focus on startView
//


//        GridBagConstraints c = new GridBagConstraints();
////        c.anchor = GridBagConstraints.CENTER;
//        c.gridx = 1;
//        c.gridy = 1;
//        c.fill = GridBagConstraints.HORIZONTAL;
//        this.add(startView, c);



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
                    default:
                        break;
                }
            }
        });


//        mainFrame.setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillOval((int)model.get_Ball().getPos_x(), (int)model.get_Ball().getPos_y(),
                (int)model.get_Ball().get_radius(), (int)model.get_Ball().get_radius());
        g.fillRect((int)model.get_Paddle().getPos_x(), (int)model.get_Paddle().getPos_y(),
                (int)model.get_Paddle().get_length(), (int)model.get_Paddle().get_height());



//        startView = new StartView(this.getWidth() * 2/5,this.getHeight() * 3/7);
//        startView.setFocusable(true); //set focus on startView
//
//        GridBagConstraints c = new GridBagConstraints();
//        c.anchor = GridBagConstraints.CENTER;
//        c.gridx = 1;
//        c.gridy = 1;
//        c.fill = GridBagConstraints.HORIZONTAL;
//        this.add(startView, c);


    }
    @Override
    public void updateView(){
        repaint();
    }
}
