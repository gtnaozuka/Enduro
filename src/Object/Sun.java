package Object;

import Util.Util;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class Sun {

    private final GeneralPath sun;

    public Sun() {
        sun = new GeneralPath(new Ellipse2D.Double(Util.screensize.width * 0.5 - 25.0,
                30.0, 70.0, 70.0));
    }

    public GeneralPath getSun() {
        return sun;
    }
}
