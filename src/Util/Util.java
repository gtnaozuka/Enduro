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
    
    public static double calculateDisplacement(double y) {
        double a1 = (Util.screensize.height - 100) / (235 - Util.screensize.width * 0.5);
        double b1 = Util.screensize.height - a1 * 225;
        double x1 = (y - b1) / a1;
        
        double a2 = (Util.screensize.height - 130) / (-226);
        double b2 = Util.screensize.height - a2 * (Util.screensize.width * 0.5 - 230);
        double x2 = (y - b2) / a2;
        
        double m = (x1 + x2) * 0.5;
        
        return Util.screensize.width * 0.5 - m;
    }
}
