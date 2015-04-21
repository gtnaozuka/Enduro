package Object;

import Entity.Point;
import Util.GeomTransform;
import Util.Util;
import java.awt.event.KeyEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Car {

    private Position currentPos;

    private enum Position {

        LEFT, CENTER, RIGHT;
    }

    private Position getLeftPosition(Position currentPos) {
        if (currentPos == Position.RIGHT) {
            return Position.CENTER;
        }
        return Position.LEFT;
    }

    private Position getRightPosition(Position currentPos) {
        if (currentPos == Position.LEFT) {
            return Position.CENTER;
        }
        return Position.RIGHT;
    }

    private List<Point> points;
    private GeneralPath gp;

    public Car() {
        currentPos = Position.CENTER;
        initPoints();
        update();
    }

    private void initPoints() {
        points = new ArrayList<>();
        points.add(new Point(Util.screensize.width * 0.5 - 50, Util.screensize.height - 100));
        points.add(new Point(Util.screensize.width * 0.5 + 50, Util.screensize.height - 100));
        points.add(new Point(Util.screensize.width * 0.5 + 50, Util.screensize.height - 150));
        points.add(new Point(Util.screensize.width * 0.5 - 50, Util.screensize.height - 150));
        points.add(new Point(Util.screensize.width * 0.5 - 50, Util.screensize.height - 100));
    }

    private void update() {
        gp = new GeneralPath();
        gp.moveTo(points.get(0).x, points.get(0).y);
        for (int i = 1; i < 5; i++) {
            gp.lineTo(points.get(i).x, points.get(i).y);
        }
    }

    public void keyBoard(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                if (currentPos != Position.LEFT) {
                    GeomTransform.translate(points, -200, 0);
                    update();
                    currentPos = getLeftPosition(currentPos);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (currentPos != Position.RIGHT) {
                    GeomTransform.translate(points, 200, 0);
                    update();
                    currentPos = getRightPosition(currentPos);
                }
                break;
        }
    }

    public GeneralPath getGp() {
        return gp;
    }
}
