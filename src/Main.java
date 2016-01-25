import Controller.Controller;
import Model.Model;
import View.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cassiehanyu on 2016-01-20.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * initialize model and controller
         */
        Model model = new Model();
        Controller controller = new Controller(model);

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JFrame mainWindown = new JFrame();
                mainWindown.setPreferredSize(new Dimension(450,550));
                mainWindown.setMaximumSize(new Dimension(800,1000));
                mainWindown.setMinimumSize(new Dimension(400,550));
                mainWindown.setResizable(true);
                mainWindown.setVisible(true);

                View view = new View(model,controller);
                mainWindown.getContentPane().add(view);

                mainWindown.pack();
                mainWindown.setTitle("Breakouts");
                mainWindown.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                mainWindown.setLocationRelativeTo(null);

               view.initUI();
            }
        });
    }
}
