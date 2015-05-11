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
        double a0 = (screensize.height - 100.0) / (-415.0);
        double b0 = screensize.height - a0 * (screensize.width * 0.5 - 425.0);
        double x0 = (y - b0) / a0;
        
        double aF = -5.0;
        double bF = 150.0 - aF * (screensize.width * 0.5 - 8.0);
        double xF = (y - bF) / aF;
        
        double m = (x0 + xF) * 0.5;
        return screensize.width * 0.5 - m;
    }
}
