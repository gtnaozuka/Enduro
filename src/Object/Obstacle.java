package Object;

import Entity.Point;
import Util.GeomTransform;
import Util.Util;
import java.awt.Color;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Obstacle implements Runnable {

    private final double direction;
    private final Color color;
    private final boolean hasBody;
    private final Thread tUpdateObstacle;

    private List<Point> obstaclePoints, hoodPoints, windowPoints, lightPoints,
            tirePoints, bodyPoints, platePoints;
    private GeneralPath obstacle, hood, window, light, tire, body, plate;

    public Obstacle(double direction, Color color, boolean hasBody) {
        this.direction = direction;
        this.color = color;
        this.hasBody = hasBody;
        tUpdateObstacle = new Thread(this);

        init();
        update(true);
    }

    private void init() {
        initObstacle();
        initHood();
        initWindow();
        initLight();
        initTire();
        initBody();
        initPlate();
    }

    private void initObstacle() {
        obstaclePoints = new ArrayList<>();

        obstaclePoints.add(new Point(800.0, 300.0));
        obstaclePoints.add(new Point(815.0, 305.0));
        obstaclePoints.add(new Point(830.0, 300.0));
        obstaclePoints.add(new Point(828.0, 282.0));
        obstaclePoints.add(new Point(802.0, 282.0));
        obstaclePoints.add(new Point(800.0, 300.0));
    }

    private void initHood() {
        hoodPoints = new ArrayList<>();

        hoodPoints.add(new Point(805.0, 296.0));
        hoodPoints.add(new Point(825.0, 296.0));
        hoodPoints.add(new Point(825.0, 295.0));
        hoodPoints.add(new Point(805.0, 295.0));
        hoodPoints.add(new Point(805.0, 296.0));
    }

    private void initWindow() {
        windowPoints = new ArrayList<>();

        windowPoints.add(new Point(803.0, 284.0));
        windowPoints.add(new Point(827.0, 284.0));
        windowPoints.add(new Point(828.0, 290.0));
        windowPoints.add(new Point(802.0, 290.0));
        windowPoints.add(new Point(803.0, 284.0));
    }

    private void initLight() {
        lightPoints = new ArrayList<>();

        lightPoints.add(new Point(802.0, 297.0));
        lightPoints.add(new Point(806.0, 297.0));
        lightPoints.add(new Point(806.0, 294.0));
        lightPoints.add(new Point(802.0, 294.0));
        lightPoints.add(new Point(802.0, 297.0));

        lightPoints.add(new Point(828.0, 297.0));
        lightPoints.add(new Point(824.0, 297.0));
        lightPoints.add(new Point(824.0, 294.0));
        lightPoints.add(new Point(828.0, 294.0));
        lightPoints.add(new Point(828.0, 297.0));
    }

    private void initTire() {
        tirePoints = new ArrayList<>();

        tirePoints.add(new Point(801.0, 300.0));
        tirePoints.add(new Point(803.0, 305.0));
        tirePoints.add(new Point(806.0, 305.0));
        tirePoints.add(new Point(808.0, 299.0));
        tirePoints.add(new Point(801.0, 300.0));

        tirePoints.add(new Point(829.0, 300.0));
        tirePoints.add(new Point(827.0, 305.0));
        tirePoints.add(new Point(824.0, 305.0));
        tirePoints.add(new Point(822.0, 299.0));
        tirePoints.add(new Point(829.0, 300.0));
    }

    private void initBody() {
        bodyPoints = new ArrayList<>();

        bodyPoints.add(new Point(802.0, 290.0));
        bodyPoints.add(new Point(802.0, 275.0));
        bodyPoints.add(new Point(828.0, 275.0));
        bodyPoints.add(new Point(828.0, 290.0));
        bodyPoints.add(new Point(802.0, 290.0));
    }

    private void initPlate() {
        platePoints = new ArrayList<>();

        platePoints.add(new Point(812.0, 301.0));
        platePoints.add(new Point(818.0, 301.0));
        platePoints.add(new Point(818.0, 304.0));
        platePoints.add(new Point(812.0, 304.0));
        platePoints.add(new Point(812.0, 304.0));
    }

    private void update(boolean isInit) {
        updateObstacle();
        updateHood();
        updateWindow();
        updateLight();
        updateTire();
        updateBody();
        updatePlate();

        if (isInit) {
            scaleAll(0.5, 0.5);
            translateAll(Util.screensize.width * 0.5 - obstacle.getBounds2D().getCenterX(),
                    100.0 - obstacle.getBounds2D().getCenterY());
        }
    }

    private void updateObstacle() {
        obstacle = new GeneralPath();

        obstacle.moveTo(obstaclePoints.get(0).x, obstaclePoints.get(0).y);
        obstacle.quadTo(obstaclePoints.get(1).x, obstaclePoints.get(1).y,
                obstaclePoints.get(2).x, obstaclePoints.get(2).y);
        for (int i = 3; i < 6; i++) {
            obstacle.lineTo(obstaclePoints.get(i).x, obstaclePoints.get(i).y);
        }
    }

    private void updateHood() {
        hood = new GeneralPath();

        hood.moveTo(hoodPoints.get(0).x, hoodPoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            hood.lineTo(hoodPoints.get(i).x, hoodPoints.get(i).y);
        }
    }

    private void updateWindow() {
        window = new GeneralPath();

        getWindow().moveTo(windowPoints.get(0).x, windowPoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            getWindow().lineTo(windowPoints.get(i).x, windowPoints.get(i).y);
        }
    }

    private void updateLight() {
        light = new GeneralPath();

        getLight().moveTo(lightPoints.get(0).x, lightPoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            getLight().lineTo(lightPoints.get(i).x, lightPoints.get(i).y);
        }

        getLight().moveTo(lightPoints.get(5).x, lightPoints.get(5).y);
        for (int i = 6; i < 10; i++) {
            getLight().lineTo(lightPoints.get(i).x, lightPoints.get(i).y);
        }
    }

    private void updateTire() {
        tire = new GeneralPath();

        getTire().moveTo(tirePoints.get(0).x, tirePoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            getTire().lineTo(tirePoints.get(i).x, tirePoints.get(i).y);
        }

        getTire().moveTo(tirePoints.get(5).x, tirePoints.get(5).y);
        for (int i = 6; i < 10; i++) {
            getTire().lineTo(tirePoints.get(i).x, tirePoints.get(i).y);
        }
    }

    private void updateBody() {
        body = new GeneralPath();

        getBody().moveTo(bodyPoints.get(0).x, bodyPoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            getBody().lineTo(bodyPoints.get(i).x, bodyPoints.get(i).y);
        }
    }

    private void updatePlate() {
        plate = new GeneralPath();

        getPlate().moveTo(platePoints.get(0).x, platePoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            getPlate().lineTo(platePoints.get(i).x, platePoints.get(i).y);
        }
    }

    @Override
    public void run() {
        while (body.getBounds2D().getMinY() <= Util.screensize.height) {
            scaleAll(1.03, 1.03);
            
            double displacement = Util.calculateDisplacement(obstacle.getBounds2D().getCenterY());
            translateAll((Util.screensize.width * 0.5 - obstacle.getBounds2D().getCenterX()) + 
                    direction * displacement, 0.0);

            Util.sleep(100);
        }
    }

    private void scaleAll(double sx, double sy) {
        GeomTransform.scale(obstaclePoints, sx, sy);
        GeomTransform.scale(hoodPoints, sx, sy);
        GeomTransform.scale(windowPoints, sx, sy);
        GeomTransform.scale(lightPoints, sx, sy);
        GeomTransform.scale(tirePoints, sx, sy);
        GeomTransform.scale(bodyPoints, sx, sy);
        GeomTransform.scale(platePoints, sx, sy);
        update(false);
    }

    private void translateAll(double x, double y) {
        GeomTransform.translate(obstaclePoints, x, y);
        GeomTransform.translate(hoodPoints, x, y);
        GeomTransform.translate(windowPoints, x, y);
        GeomTransform.translate(lightPoints, x, y);
        GeomTransform.translate(tirePoints, x, y);
        GeomTransform.translate(bodyPoints, x, y);
        GeomTransform.translate(platePoints, x, y);
        update(false);
    }

    public Thread gettUpdateObstacle() {
        return tUpdateObstacle;
    }

    public Color getColor() {
        return color;
    }

    public GeneralPath getObstacle() {
        return obstacle;
    }

    public GeneralPath getHood() {
        return hood;
    }

    public GeneralPath getWindow() {
        return window;
    }

    public GeneralPath getLight() {
        return light;
    }

    public GeneralPath getTire() {
        return tire;
    }

    public GeneralPath getBody() {
        return body;
    }

    public GeneralPath getPlate() {
        return plate;
    }
    
    public boolean hasBody() {
        return hasBody;
    }
}
