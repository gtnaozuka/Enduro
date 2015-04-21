package Object;

import Entity.Point;
import Util.GeomTransform;
import Util.Util;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Obstacle implements Runnable {
    
    private double factor;
    private final Thread tUpdateObstacle;
    
    private List<Point> points;
    private GeneralPath gp;
    
    public Obstacle(double factor) {
        this.factor = factor;
        tUpdateObstacle = new Thread(this);
        
        initPoints();
        update();
    }
    
    private void initPoints() {
        points = new ArrayList<>();
        points.add(new Point(Util.screensize.width*0.5 - 3, 100));
        points.add(new Point(Util.screensize.width*0.5 + 3, 100));
        points.add(new Point(Util.screensize.width*0.5 + 3, 106));
        points.add(new Point(Util.screensize.width*0.5 - 3, 106));
        points.add(new Point(Util.screensize.width*0.5 - 3, 100));
    }
    
    private void update() {
        gp = new GeneralPath();
        gp.moveTo(points.get(0).x, points.get(0).y);
        for (int i = 1; i < 5; i++) {
            gp.lineTo(points.get(i).x, points.get(i).y);
        }
    }
    
    @Override
    public void run() {
        while (gp.getCurrentPoint().getY() <= Util.screensize.height) {
            factor *= 1.03;
            GeomTransform.scale(points, 1.03, 1.03);
            
            double newCenter = (points.get(1).x + points.get(0).x)*0.5;
            double oldCenter = gp.getBounds2D().getCenterX();
            GeomTransform.translate(points, oldCenter-newCenter+factor, 0);
            update();
            
            Util.sleep(100);
        }
    }
    
    public GeneralPath getGp() {
        return gp;
    }

    public Thread gettUpdateObstacle() {
        return tUpdateObstacle;
    }
}
