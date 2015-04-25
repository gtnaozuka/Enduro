package Object;

import Entity.Point;
import Util.Util;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Landscape {

    private List<Point> points;
    private GeneralPath gp;

    public Landscape() {
        initPoints();
        update();
    }

    private void initPoints() {
        points = new ArrayList<>();

        points.add(new Point(Util.screensize.width * 0.5 - 10, 100));
        points.add(new Point(225, Util.screensize.height));
        points.add(new Point(0, Util.screensize.height));
        points.add(new Point(0, 100));
        points.add(new Point(Util.screensize.width * 0.5 - 10, 100));

        points.add(new Point(Util.screensize.width * 0.5 + 10, 100));
        points.add(new Point(Util.screensize.width - 225, Util.screensize.height));
        points.add(new Point(Util.screensize.width, Util.screensize.height));
        points.add(new Point(Util.screensize.width, 100));
        points.add(new Point(Util.screensize.width * 0.5 + 10, 100));
    }

    private void update() {
        gp = new GeneralPath();

        gp.moveTo(points.get(0).x, points.get(0).y);
        for (int i = 1; i < 5; i++) {
            gp.lineTo(points.get(i).x, points.get(i).y);
        }

        gp.moveTo(points.get(5).x, points.get(5).y);
        for (int i = 5; i < points.size(); i++) {
            gp.lineTo(points.get(i).x, points.get(i).y);
        }
    }

    public GeneralPath getGp() {
        return gp;
    }
}
