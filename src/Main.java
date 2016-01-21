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
                View ex = new View(model,controller);
                ex.initUI();
            }
        });
    }
}
