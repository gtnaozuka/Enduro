package Object;

import Entity.Point;
import Util.Util;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Sky {

    private List<Point> points;
    private GeneralPath gp;

    public Sky() {
        initPoints();
        update();
    }

    private void initPoints() {
        points = new ArrayList<>();

        points.add(new Point(0, 0));
        points.add(new Point(Util.screensize.width, 0));
        points.add(new Point(Util.screensize.width, 100));
        points.add(new Point(0, 100));
        points.add(new Point(0, 0));
    }

    private void update() {
        gp = new GeneralPath();

        gp.moveTo(points.get(0).x, points.get(0).y);
        for (int i = 1; i < points.size(); i++) {
            gp.lineTo(points.get(i).x, points.get(i).y);
        }
    }

    public GeneralPath getGp() {
        return gp;
    }
}
