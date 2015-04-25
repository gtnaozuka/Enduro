package Object;

import Entity.Point;
import Util.Util;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<Point> points;
    private GeneralPath gp, line;

    public Track() {
        initPoints();
        update();
    }

    private void initPoints() {
        points = new ArrayList<>();

        points.add(new Point(Util.screensize.width * 0.5 - 10, 100));
        points.add(new Point(225, Util.screensize.height));
        points.add(new Point(Util.screensize.width - 225, Util.screensize.height));
        points.add(new Point(Util.screensize.width * 0.5 + 10, 100));
        
        points.add(new Point(Util.screensize.width * 0.5 - 4, 130));
        points.add(new Point(Util.screensize.width * 0.5 - 8, 150));
        points.add(new Point(Util.screensize.width * 0.5 - 13, 170));
        points.add(new Point(Util.screensize.width * 0.5 - 21, 205));
        points.add(new Point(Util.screensize.width * 0.5 - 26, 225));
        points.add(new Point(Util.screensize.width * 0.5 - 39, 280));
        points.add(new Point(Util.screensize.width * 0.5 - 44, 300));
        points.add(new Point(Util.screensize.width * 0.5 - 57, 360));
        points.add(new Point(Util.screensize.width * 0.5 - 63, 380));
        points.add(new Point(Util.screensize.width * 0.5 - 80, 460));
        points.add(new Point(Util.screensize.width * 0.5 - 88, 490));
        points.add(new Point(Util.screensize.width * 0.5 - 109, 580));
        points.add(new Point(Util.screensize.width * 0.5 - 119, 620));
        points.add(new Point(Util.screensize.width * 0.5 - 142, 720));
        points.add(new Point(Util.screensize.width * 0.5 - 155, 770));
        points.add(new Point(Util.screensize.width * 0.5 - 183, 890));
        points.add(new Point(Util.screensize.width * 0.5 - 198, 950));
        points.add(new Point(Util.screensize.width * 0.5 - 210, 1000));

        points.add(new Point(Util.screensize.width * 0.5 + 4, 130));
        points.add(new Point(Util.screensize.width * 0.5 + 8, 150));
        points.add(new Point(Util.screensize.width * 0.5 + 13, 170));
        points.add(new Point(Util.screensize.width * 0.5 + 21, 205));
        points.add(new Point(Util.screensize.width * 0.5 + 26, 225));
        points.add(new Point(Util.screensize.width * 0.5 + 39, 280));
        points.add(new Point(Util.screensize.width * 0.5 + 44, 300));
        points.add(new Point(Util.screensize.width * 0.5 + 57, 360));
        points.add(new Point(Util.screensize.width * 0.5 + 63, 380));
        points.add(new Point(Util.screensize.width * 0.5 + 80, 460));
        points.add(new Point(Util.screensize.width * 0.5 + 88, 490));
        points.add(new Point(Util.screensize.width * 0.5 + 109, 580));
        points.add(new Point(Util.screensize.width * 0.5 + 119, 620));
        points.add(new Point(Util.screensize.width * 0.5 + 142, 720));
        points.add(new Point(Util.screensize.width * 0.5 + 155, 770));
        points.add(new Point(Util.screensize.width * 0.5 + 183, 890));
        points.add(new Point(Util.screensize.width * 0.5 + 198, 950));
        points.add(new Point(Util.screensize.width * 0.5 + 210, 1000));
        
        points.add(new Point(Util.screensize.width * 0.5 - 10, 100));
        points.add(new Point(225, Util.screensize.height));
        points.add(new Point(Util.screensize.width * 0.5 + 10, 100));
        points.add(new Point(Util.screensize.width - 225, Util.screensize.height));
    }

    private void update() {
        gp = new GeneralPath();
        gp.moveTo(points.get(0).x, points.get(0).y);
        for (int i = 1; i < 4; i++) {
            gp.lineTo(points.get(i).x, points.get(i).y);
        }
        
        line = new GeneralPath();
        for (int i = 4; i < points.size(); i += 2) {
            line.moveTo(points.get(i).x, points.get(i).y);
            line.lineTo(points.get(i + 1).x, points.get(i + 1).y);
        }
    }

    public GeneralPath getGp() {
        return gp;
    }
    
    public GeneralPath getLine() {
        return line;
    }
}
