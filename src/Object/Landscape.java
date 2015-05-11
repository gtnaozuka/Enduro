package Object;

import Entity.Point;
import Util.Util;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Landscape {

    private List<Point> landscapePoints;
    private GeneralPath landscape;

    public Landscape() {
        init();
        update();
    }

    private void init() {
        landscapePoints = new ArrayList<>();

        landscapePoints.add(new Point(Util.screensize.width * 0.5 - 20.0, 100.0));
        landscapePoints.add(new Point(Util.screensize.width * 0.5 - 550.0, Util.screensize.height));
        landscapePoints.add(new Point(0.0, Util.screensize.height));
        landscapePoints.add(new Point(0.0, 100.0));
        landscapePoints.add(new Point(Util.screensize.width * 0.5 - 20.0, 100.0));

        landscapePoints.add(new Point(Util.screensize.width * 0.5 + 20.0, 100.0));
        landscapePoints.add(new Point(Util.screensize.width * 0.5 + 550.0, Util.screensize.height));
        landscapePoints.add(new Point(Util.screensize.width, Util.screensize.height));
        landscapePoints.add(new Point(Util.screensize.width, 100.0));
        landscapePoints.add(new Point(Util.screensize.width * 0.5 + 20.0, 100.0));
    }

    private void update() {
        landscape = new GeneralPath();

        landscape.moveTo(landscapePoints.get(0).x, landscapePoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            landscape.lineTo(landscapePoints.get(i).x, landscapePoints.get(i).y);
        }

        landscape.moveTo(landscapePoints.get(5).x, landscapePoints.get(5).y);
        for (int i = 5; i < landscapePoints.size(); i++) {
            landscape.lineTo(landscapePoints.get(i).x, landscapePoints.get(i).y);
        }
    }

    public GeneralPath getLandscape() {
        return landscape;
    }
}
