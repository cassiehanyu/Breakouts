package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by cassiehanyu on 2016-01-20.
 */
public class StartView extends JPanel {

    JLabel label_StartGame;
    JLabel label_HowToStart;

    JLabel start_img1;
    JLabel start_img2;

    public StartView(int width, int height) {
//        this.setFocusable(true);
        this.setSize(new Dimension(width, height));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.black);

        label_StartGame = new JLabel("Start Game");
//        label_StartGame.setPreferredSize(new Dimension(this.getWidth() * 4 / 5, this.getHeight() / 10));
//        label_StartGame.setForeground(Color.yellow);

        label_HowToStart = new JLabel("How To Play?");
//        label_HowToStart.setPreferredSize(new Dimension(this.getWidth() * 4 / 5, this.getHeight() / 10));
//        label_HowToStart.setForeground(Color.yellow);

        start_img1 = new JLabel();
//        start_img1.setIcon(new ImageIcon(new ImageIcon("pic/start.png").getImage().getScaledInstance(this.getWidth() * 1 / 10, this.getWidth() * 1 / 10, Image.SCALE_AREA_AVERAGING)));
//        start_img1.setBackground(Color.black);
//        start_img1.setOpaque(true);

        start_img2 = new JLabel();
//        start_img2.setIcon(new ImageIcon(new ImageIcon("pic/start.png").getImage().getScaledInstance(height * 1 / 10, height * 1 / 10, Image.SCALE_AREA_AVERAGING)));
//        start_img2.setBackground(Color.black);
//        start_img2.setOpaque(true);
//        start_img2.setVisible(false);

//        GridBagConstraints c = new GridBagConstraints();
//        c.gridx = 0;
//        c.gridy = 0;
//        c.insets = new Insets(0, width / 20, height / 30, 0);
//        add(start_img1, c);
//
//        c.gridx = 1;
//        c.gridy = 0;
//        c.insets = new Insets(0, width / 20, height / 30, 0);
//        add(label_StartGame, c);
//
//        c.gridx = 1;
//        c.gridy = 1;
//        c.insets = new Insets(0, width / 20, height / 30, 0);
//        add(label_HowToStart, c);
//
//        c.gridx = 0;
//        c.gridy = 1;
//        c.insets = new Insets(0, width / 20, height / 30, 0);
//        add(start_img2, c);

        label_StartGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("22222222b");
            }
        });

        label_HowToStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("2222222222B");
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        System.out.println("2222");
                        break;
                    case KeyEvent.VK_UP:
                        start_img1.setVisible(true);
                        start_img2.setVisible(false);
                        StartView.this.repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        start_img1.setVisible(false);
                        start_img2.setVisible(true);
                        StartView.this.revalidate();
                        System.out.println("222");
                        break;
                }
            }
        });
    }

   public void paintComponent(Graphics g) {
       super.paintComponent(g);

       label_StartGame.setPreferredSize(new Dimension(this.getWidth() * 4 / 5, this.getHeight() / 10));
       label_StartGame.setForeground(Color.yellow);

       label_HowToStart.setPreferredSize(new Dimension(this.getWidth() * 4 / 5, this.getHeight() / 10));
       label_HowToStart.setForeground(Color.yellow);

       start_img1.setIcon(new ImageIcon(new ImageIcon("pic/start.png").getImage().getScaledInstance(this.getWidth() * 1 / 10, this.getWidth() * 1 / 10, Image.SCALE_AREA_AVERAGING)));
       start_img1.setBackground(Color.black);
       start_img1.setOpaque(true);

       start_img2.setIcon(new ImageIcon(new ImageIcon("pic/start.png").getImage().getScaledInstance(this.getWidth() * 1 / 10, this.getWidth() * 1 / 10, Image.SCALE_AREA_AVERAGING)));
       start_img2.setBackground(Color.black);
       start_img2.setOpaque(true);
       start_img2.setVisible(false);

       GridBagConstraints c = new GridBagConstraints();
       c.gridx = 0;
       c.gridy = 0;
       c.insets = new Insets(0, this.getWidth() / 20, this.getHeight() / 30, 0);
       add(start_img1, c);

       c.gridx = 1;
       c.gridy = 0;
       c.insets = new Insets(0, this.getWidth() / 20, this.getHeight() / 30, 0);
       add(label_StartGame, c);

       c.gridx = 1;
       c.gridy = 1;
       c.insets = new Insets(0, this.getWidth() / 20, this.getHeight() / 30, 0);
       add(label_HowToStart, c);

       c.gridx = 0;
       c.gridy = 1;
       c.insets = new Insets(0, this.getWidth() / 20, this.getHeight() / 30, 0);
       add(start_img2, c);

   }
}
