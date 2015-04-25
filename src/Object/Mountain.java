package Object;

import Entity.Point;
import Util.Util;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Mountain {

    private List<Point> points;
    private GeneralPath gp;

    public Mountain() {
        initPoints();
        update();
    }

    private void initPoints() {
        points = new ArrayList<>();
        
        points.add(new Point(Util.screensize.width * 0.5 - 150, 101));
        points.add(new Point(Util.screensize.width * 0.5 - 50, 20));
        points.add(new Point(Util.screensize.width * 0.5 + 50, 101));
        
        points.add(new Point(Util.screensize.width * 0.5 - 50, 101));
        points.add(new Point(Util.screensize.width * 0.5 + 50, 10));
        points.add(new Point(Util.screensize.width * 0.5 + 150, 101));
    }

    private void update() {
        gp = new GeneralPath();

        for (int i = 0; i < points.size(); i += 3) {
            gp.moveTo(points.get(i).x, points.get(i).y);
            gp.quadTo(points.get(i + 1).x, points.get(i + 1).y, 
                    points.get(i + 2).x, points.get(i + 2).y);
        }
    }
    
    public GeneralPath getGp() {
        return gp;
    }
}
