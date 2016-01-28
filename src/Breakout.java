import Model.Model;
import View.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cassiehanyu on 2016-01-20.
 */
public class Breakout extends JFrame{

    private int Frame_Width = 450;
    private int Frame_Height = 550;

    public Breakout(){
        Model model = new Model();

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Breakout.this.setPreferredSize(new Dimension(Frame_Width,Frame_Height));
                Breakout.this.setMaximumSize(new Dimension(800,1000));
                Breakout.this.setMinimumSize(new Dimension(400,550));
                Breakout.this.setResizable(true);
                Breakout.this.setVisible(true);

                View view = new View(model);
                Breakout.this.getContentPane().add(view);

                Breakout.this.pack();
                Breakout.this.setTitle("Breakouts");
                Breakout.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                mainWindown.setLocationRelativeTo(null);

                view.initUI();
            }
        });
    }


    public static void main(String[] args) {

        /**
         * initialize model and controller
         */
        Breakout breakout = new Breakout();
    }
}
