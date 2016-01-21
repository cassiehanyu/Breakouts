package View;


import Controller.Controller;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class View implements IView {

    Model model;
    Controller controller;

    JFrame mainFrame;
    JPanel panel;

    JLabel label_StartGame;
    JLabel label_HowToStart;

    StartView startView;



    public View(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;
    }

    public void initUI() {
        mainFrame = new JFrame();
        /**
         * set size of the frame
         * preferred size is the default size
         * min, max size if the restricted size
         */
        mainFrame.setPreferredSize(new Dimension(700,400));
        mainFrame.setMaximumSize(new Dimension(800,600));
        mainFrame.setMinimumSize(new Dimension(400,200));
        mainFrame.setResizable(true);
        mainFrame.setVisible(true);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.black);

        label_StartGame = new JLabel("Start Game");
        label_StartGame.setPreferredSize(new Dimension(100,50));
        label_StartGame.setForeground(Color.yellow);

        label_HowToStart = new JLabel("How To Start?");
        label_HowToStart.setPreferredSize(new Dimension(100,50));
        label_HowToStart.setForeground(Color.blue);

        startView = new StartView(mainFrame.getWidth() * 2/3,mainFrame.getHeight() * 2/3);
        startView.setFocusable(true); //set focus on startView

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(startView, c);

        mainFrame.getContentPane().add(panel);

        mainFrame.pack();
        mainFrame.setTitle("Breakouts");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_ENTER:
                        System.out.println("enter");
                        break;
                    case KeyEvent.VK_UP:
                        System.out.println("up");

                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("left");

                        break;
                    case KeyEvent.VK_RIGHT:
                        System.out.println("right");

                        break;
                    default:
                        break;
                }
            }
        });

//        mainFrame.setVisible(true);

    }

    @Override
    public void updateView(){

    }
}
