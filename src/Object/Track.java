package Object;

import Entity.Point;
import Util.Util;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<Point> trackPoints, linePoints;
    private GeneralPath track, line;

    public Track() {
        init();
        update();
    }

    private void init() {
        initTrack();
        initLine();
    }

    private void initLine() {
        linePoints = new ArrayList<>();

        linePoints.add(new Point(Util.screensize.width * 0.5 - 4, 130));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 8, 150));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 13, 170));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 21, 205));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 26, 225));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 39, 280));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 44, 300));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 57, 360));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 63, 380));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 80, 460));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 88, 490));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 109, 580));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 119, 620));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 142, 720));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 155, 770));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 183, 890));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 198, 950));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 230, Util.screensize.height));

        linePoints.add(new Point(Util.screensize.width * 0.5 + 4, 130));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 8, 150));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 13, 170));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 21, 205));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 26, 225));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 39, 280));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 44, 300));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 57, 360));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 63, 380));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 80, 460));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 88, 490));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 109, 580));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 119, 620));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 142, 720));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 155, 770));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 183, 890));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 198, 950));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 230, Util.screensize.height));

        linePoints.add(new Point(Util.screensize.width * 0.5 - 10, 100));
        linePoints.add(new Point(225, Util.screensize.height));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 10, 100));
        linePoints.add(new Point(Util.screensize.width - 225, Util.screensize.height));
    }

    private void initTrack() {
        trackPoints = new ArrayList<>();

        trackPoints.add(new Point(Util.screensize.width * 0.5 - 10, 100));
        trackPoints.add(new Point(225, Util.screensize.height));
        trackPoints.add(new Point(Util.screensize.width - 225, Util.screensize.height));
        trackPoints.add(new Point(Util.screensize.width * 0.5 + 10, 100));
        trackPoints.add(new Point(Util.screensize.width * 0.5 - 10, 100));
    }

    private void update() {
        updateTrack();
        updateLine();
    }

    private void updateLine() {
        line = new GeneralPath();
        for (int i = 0; i < linePoints.size(); i += 2) {
            line.moveTo(linePoints.get(i).x, linePoints.get(i).y);
            line.lineTo(linePoints.get(i + 1).x, linePoints.get(i + 1).y);
        }
    }

    private void updateTrack() {
        track = new GeneralPath();
        track.moveTo(trackPoints.get(0).x, trackPoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            track.lineTo(trackPoints.get(i).x, trackPoints.get(i).y);
        }
    }

    public GeneralPath getTrack() {
        return track;
    }

    public GeneralPath getLine() {
        return line;
    }
}
