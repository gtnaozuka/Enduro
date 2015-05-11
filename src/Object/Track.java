package Object;

import Entity.Point;
import Util.Util;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<Point> trackPoints, linePoints, coastingPoints;
    private GeneralPath track, line, coasting;

    public Track() {
        init();
        update();
    }

    private void init() {
        initTrack();
        initLine();
        initCoasting();
    }

    private void initTrack() {
        trackPoints = new ArrayList<>();

        trackPoints.add(new Point(Util.screensize.width * 0.5 - 10.0, 100.0));
        trackPoints.add(new Point(Util.screensize.width * 0.5 - 425.0, Util.screensize.height));
        trackPoints.add(new Point(Util.screensize.width * 0.5 + 425.0, Util.screensize.height));
        trackPoints.add(new Point(Util.screensize.width * 0.5 + 10.0, 100.0));
        trackPoints.add(new Point(Util.screensize.width * 0.5 - 10.0, 100.0));
    }
    
    private void initLine() {
        linePoints = new ArrayList<>();

        linePoints.add(new Point(Util.screensize.width * 0.5 - 4.0, 130.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 8.0, 150.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 13.0, 170.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 21.0, 205.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 26.0, 225.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 39.0, 280.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 44.0, 300.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 57.0, 360.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 63.0, 380.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 80.0, 460.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 88.0, 490.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 109.0, 580.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 119.0, 620.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 142.0, 720.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 155.0, 770.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 183.0, 890.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 198.0, 950.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 230.0, Util.screensize.height));

        linePoints.add(new Point(Util.screensize.width * 0.5 + 4.0, 130.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 8.0, 150.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 13.0, 170.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 21.0, 205.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 26.0, 225.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 39.0, 280.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 44.0, 300.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 57.0, 360.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 63.0, 380.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 80.0, 460.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 88.0, 490.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 109.0, 580.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 119.0, 620.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 142.0, 720.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 155.0, 770.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 183.0, 890.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 198.0, 950.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 230.0, Util.screensize.height));

        linePoints.add(new Point(Util.screensize.width * 0.5 - 10.0, 100.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 - 425.0, Util.screensize.height));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 10.0, 100.0));
        linePoints.add(new Point(Util.screensize.width * 0.5 + 425.0, Util.screensize.height));
    }
    
    private void initCoasting() {
        coastingPoints = new ArrayList<>();
        
        coastingPoints.add(new Point(Util.screensize.width * 0.5 - 20.0, 100.0));
        coastingPoints.add(new Point(Util.screensize.width * 0.5 - 550.0, Util.screensize.height));
        coastingPoints.add(new Point(Util.screensize.width * 0.5 - 425.0, Util.screensize.height));
        coastingPoints.add(new Point(Util.screensize.width * 0.5 - 10.0, 100.0));
        coastingPoints.add(new Point(Util.screensize.width * 0.5 - 20.0, 100.0));
        
        coastingPoints.add(new Point(Util.screensize.width * 0.5 + 20.0, 100.0));
        coastingPoints.add(new Point(Util.screensize.width * 0.5 + 550.0, Util.screensize.height));
        coastingPoints.add(new Point(Util.screensize.width * 0.5 + 425.0, Util.screensize.height));
        coastingPoints.add(new Point(Util.screensize.width * 0.5 + 10.0, 100.0));
        coastingPoints.add(new Point(Util.screensize.width * 0.5 + 20.0, 100.0));
    }

    private void update() {
        updateTrack();
        updateLine();
        updateCoasting();
    }

    private void updateTrack() {
        track = new GeneralPath();
        track.moveTo(trackPoints.get(0).x, trackPoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            track.lineTo(trackPoints.get(i).x, trackPoints.get(i).y);
        }
    }
    
    private void updateLine() {
        line = new GeneralPath();
        for (int i = 0; i < linePoints.size(); i += 2) {
            line.moveTo(linePoints.get(i).x, linePoints.get(i).y);
            line.lineTo(linePoints.get(i + 1).x, linePoints.get(i + 1).y);
        }
    }
    
    private void updateCoasting() {
        coasting = new GeneralPath();
        
        coasting.moveTo(coastingPoints.get(0).x, coastingPoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            coasting.lineTo(coastingPoints.get(i).x, coastingPoints.get(i).y);
        }
        
        coasting.moveTo(coastingPoints.get(5).x, coastingPoints.get(5).y);
        for (int i = 6; i < 10; i++) {
            coasting.lineTo(coastingPoints.get(i).x, coastingPoints.get(i).y);
        }
    }

    public GeneralPath getTrack() {
        return track;
    }

    public GeneralPath getLine() {
        return line;
    }
    
    public GeneralPath getCoasting() {
        return coasting;
    }
}
