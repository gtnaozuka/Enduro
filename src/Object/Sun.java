
package Object;

import Util.Util;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class Sun {
    private final GeneralPath gp;
    
    public Sun() {
        gp = new GeneralPath(new Ellipse2D.Double(Util.screensize.width * 0.5 - 25,
                        30, 70, 70));
    }
    
    public GeneralPath getGp() {
        return gp;
    }
}
