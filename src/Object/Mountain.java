package Object;

import Entity.Point;
import Util.Util;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Mountain {

    private List<Point> mountainPoints;
    private GeneralPath mountain;

    public Mountain() {
        init();
        update();
    }

    private void init() {
        mountainPoints = new ArrayList<>();

        mountainPoints.add(new Point(Util.screensize.width * 0.5 - 150.0, 100.0));
        mountainPoints.add(new Point(Util.screensize.width * 0.5 - 50.0, 20.0));
        mountainPoints.add(new Point(Util.screensize.width * 0.5 + 50.0, 100.0));
        mountainPoints.add(new Point(Util.screensize.width * 0.5 - 150.0, 100.0));

        mountainPoints.add(new Point(Util.screensize.width * 0.5 - 50.0, 100.0));
        mountainPoints.add(new Point(Util.screensize.width * 0.5 + 50.0, 10.0));
        mountainPoints.add(new Point(Util.screensize.width * 0.5 + 150.0, 100.0));
        mountainPoints.add(new Point(Util.screensize.width * 0.5 - 50.0, 100.0));
    }

    private void update() {
        mountain = new GeneralPath();

        for (int i = 0; i < mountainPoints.size(); i += 4) {
            mountain.moveTo(mountainPoints.get(i).x, mountainPoints.get(i).y);
            mountain.quadTo(mountainPoints.get(i + 1).x, mountainPoints.get(i + 1).y,
                    mountainPoints.get(i + 2).x, mountainPoints.get(i + 2).y);
            mountain.lineTo(mountainPoints.get(i + 3).x, mountainPoints.get(i + 3).y);
        }
    }

    public GeneralPath getMountain() {
        return mountain;
    }
}
