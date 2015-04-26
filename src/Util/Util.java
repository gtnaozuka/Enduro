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
        double a0 = (screensize.height - 100) / (235 - screensize.width * 0.5);
        double b0 = screensize.height - a0 * 225;
        double x0 = (y - b0) / a0;
        
        double aF = (screensize.height - 130) / (-226);
        double bF = screensize.height - aF * (screensize.width * 0.5 - 230);
        double xF = (y - bF) / aF;
        
        double m = (x0 + xF) * 0.5;
        return screensize.width * 0.5 - m;
    }
}
