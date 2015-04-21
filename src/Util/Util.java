package Util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {

    public static final Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

    public static void sleep(int time) {
        try {
            java.lang.Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
