package Object;

import Entity.Point;
import Util.Util;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Sky {

    private List<Point> skyPoints;
    private GeneralPath sky;

    public Sky() {
        init();
        update();
    }

    private void init() {
        skyPoints = new ArrayList<>();

        skyPoints.add(new Point(0.0, 0.0));
        skyPoints.add(new Point(Util.screensize.width, 0.0));
        skyPoints.add(new Point(Util.screensize.width, 100.0));
        skyPoints.add(new Point(0.0, 100.0));
        skyPoints.add(new Point(0.0, 0.0));
    }

    private void update() {
        sky = new GeneralPath();

        sky.moveTo(skyPoints.get(0).x, skyPoints.get(0).y);
        for (int i = 1; i < skyPoints.size(); i++) {
            sky.lineTo(skyPoints.get(i).x, skyPoints.get(i).y);
        }
    }

    public GeneralPath getSky() {
        return sky;
    }
}
