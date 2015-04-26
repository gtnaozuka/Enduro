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

    private List<Point> carPoints, yellowLightPoints, redLightPoints, rearPoints,
            platePoints, tirePoints, windowPoints;
    private GeneralPath car, yellowLight, redLight, rear, plate, tire, window;

    public Car() {
        currentPos = Position.CENTER;
        init();
        update(true);
    }

    private void init() {
        initCar();
        initYellowLight();
        initRedLight();
        initRear();
        initPlate();
        initTire();
        initWindow();
    }

    private void initCar() {
        carPoints = new ArrayList<>();

        carPoints.add(new Point(900, 940));
        carPoints.add(new Point(1000, 940));
        carPoints.add(new Point(1010, 930));
        carPoints.add(new Point(1010, 915));
        carPoints.add(new Point(890, 915));
        carPoints.add(new Point(890, 930));
        carPoints.add(new Point(900, 940));

        carPoints.add(new Point(885, 915));
        carPoints.add(new Point(895, 900));
        carPoints.add(new Point(1004, 900));
        carPoints.add(new Point(1014, 915));
        carPoints.add(new Point(885, 915));

        carPoints.add(new Point(900, 900));
        carPoints.add(new Point(920, 875));
        carPoints.add(new Point(980, 875));
        carPoints.add(new Point(1000, 900));
        carPoints.add(new Point(900, 900));
    }

    private void initYellowLight() {
        yellowLightPoints = new ArrayList<>();

        yellowLightPoints.add(new Point(897, 910));
        yellowLightPoints.add(new Point(900, 905));
        yellowLightPoints.add(new Point(920, 905));
        yellowLightPoints.add(new Point(920, 910));
        yellowLightPoints.add(new Point(897, 910));

        yellowLightPoints.add(new Point(1002, 910));
        yellowLightPoints.add(new Point(1000, 905));
        yellowLightPoints.add(new Point(979, 905));
        yellowLightPoints.add(new Point(979, 910));
        yellowLightPoints.add(new Point(1002, 910));
    }

    private void initRedLight() {
        redLightPoints = new ArrayList<>();

        redLightPoints.add(new Point(897, 910));
        redLightPoints.add(new Point(920, 910));
        redLightPoints.add(new Point(920, 915));
        redLightPoints.add(new Point(895, 915));
        redLightPoints.add(new Point(897, 910));

        redLightPoints.add(new Point(1002, 910));
        redLightPoints.add(new Point(979, 910));
        redLightPoints.add(new Point(979, 915));
        redLightPoints.add(new Point(1005, 915));
        redLightPoints.add(new Point(1002, 910));
    }

    private void initRear() {
        rearPoints = new ArrayList<>();

        rearPoints.add(new Point(920, 915));
        rearPoints.add(new Point(920, 905));
        rearPoints.add(new Point(979, 907));
        rearPoints.add(new Point(920, 907));
        rearPoints.add(new Point(920, 909));
        rearPoints.add(new Point(979, 909));
        rearPoints.add(new Point(979, 911));
        rearPoints.add(new Point(920, 911));
        rearPoints.add(new Point(920, 913));
        rearPoints.add(new Point(979, 913));
        rearPoints.add(new Point(979, 915));
        rearPoints.add(new Point(979, 905));
    }

    private void initPlate() {
        platePoints = new ArrayList<>();

        platePoints.add(new Point(940, 925));
        platePoints.add(new Point(960, 925));
        platePoints.add(new Point(960, 935));
        platePoints.add(new Point(940, 935));
        platePoints.add(new Point(940, 925));
    }

    private void initTire() {
        tirePoints = new ArrayList<>();

        tirePoints.add(new Point(900, 940));
        tirePoints.add(new Point(905, 945));
        tirePoints.add(new Point(925, 945));
        tirePoints.add(new Point(930, 940));
        tirePoints.add(new Point(900, 940));

        tirePoints.add(new Point(1000, 940));
        tirePoints.add(new Point(995, 945));
        tirePoints.add(new Point(975, 945));
        tirePoints.add(new Point(970, 940));
        tirePoints.add(new Point(1000, 940));
    }

    private void initWindow() {
        windowPoints = new ArrayList<>();

        windowPoints.add(new Point(910, 900));
        windowPoints.add(new Point(925, 880));
        windowPoints.add(new Point(975, 880));
        windowPoints.add(new Point(990, 900));
        windowPoints.add(new Point(910, 900));

        windowPoints.add(new Point(940, 880));
        windowPoints.add(new Point(950, 885));
        windowPoints.add(new Point(960, 880));
        windowPoints.add(new Point(940, 880));
    }

    private void update(boolean isInit) {
        updateCar();
        updateYellowLight();
        updateRedLight();
        updateRear();
        updatePlate();
        updateTire();
        updateWindow();

        if (isInit) {
            scaleAll(0.75, 0.75);
            translateAll(Util.screensize.width * 0.5 - car.getBounds2D().getCenterX(),
                    Util.screensize.height - 150 - car.getBounds2D().getCenterY());
        }
    }

    private void updateCar() {
        car = new GeneralPath();
        car.moveTo(carPoints.get(0).x, carPoints.get(0).y);
        for (int i = 1; i < 7; i++) {
            car.lineTo(carPoints.get(i).x, carPoints.get(i).y);
        }

        car.moveTo(carPoints.get(7).x, carPoints.get(7).y);
        for (int i = 8; i < 12; i++) {
            car.lineTo(carPoints.get(i).x, carPoints.get(i).y);
        }

        car.moveTo(carPoints.get(12).x, carPoints.get(12).y);
        for (int i = 13; i < 17; i++) {
            car.lineTo(carPoints.get(i).x, carPoints.get(i).y);
        }
    }

    private void updateYellowLight() {
        yellowLight = new GeneralPath();
        yellowLight.moveTo(yellowLightPoints.get(0).x, yellowLightPoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            yellowLight.lineTo(yellowLightPoints.get(i).x, yellowLightPoints.get(i).y);
        }

        yellowLight.moveTo(yellowLightPoints.get(5).x, yellowLightPoints.get(5).y);
        for (int i = 6; i < 10; i++) {
            yellowLight.lineTo(yellowLightPoints.get(i).x, yellowLightPoints.get(i).y);
        }
    }

    private void updateRedLight() {
        redLight = new GeneralPath();
        redLight.moveTo(redLightPoints.get(0).x, redLightPoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            redLight.lineTo(redLightPoints.get(i).x, redLightPoints.get(i).y);
        }

        redLight.moveTo(redLightPoints.get(5).x, redLightPoints.get(5).y);
        for (int i = 6; i < 10; i++) {
            redLight.lineTo(redLightPoints.get(i).x, redLightPoints.get(i).y);
        }
    }

    private void updateRear() {
        rear = new GeneralPath();
        for (int i = 0; i < 12; i += 2) {
            rear.moveTo(rearPoints.get(i).x, rearPoints.get(i).y);
            rear.lineTo(rearPoints.get(i + 1).x, rearPoints.get(i + 1).y);
        }
    }

    private void updatePlate() {
        plate = new GeneralPath();
        plate.moveTo(platePoints.get(0).x, platePoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            plate.lineTo(platePoints.get(i).x, platePoints.get(i).y);
        }
    }

    private void updateTire() {
        tire = new GeneralPath();
        tire.moveTo(tirePoints.get(0).x, tirePoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            tire.lineTo(tirePoints.get(i).x, tirePoints.get(i).y);
        }

        tire.moveTo(tirePoints.get(5).x, tirePoints.get(5).y);
        for (int i = 6; i < 10; i++) {
            tire.lineTo(tirePoints.get(i).x, tirePoints.get(i).y);
        }
    }

    private void updateWindow() {
        window = new GeneralPath();

        window.moveTo(windowPoints.get(0).x, windowPoints.get(0).y);
        for (int i = 1; i < 5; i++) {
            window.lineTo(windowPoints.get(i).x, windowPoints.get(i).y);
        }

        window.moveTo(windowPoints.get(5).x, windowPoints.get(5).y);
        for (int i = 6; i < 9; i++) {
            window.lineTo(windowPoints.get(i).x, windowPoints.get(i).y);
        }
    }

    public void keyBoard(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                if (currentPos != Position.LEFT) {
                    translateAll(-235, 0);
                    currentPos = getLeftPosition(currentPos);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (currentPos != Position.RIGHT) {
                    translateAll(235, 0);
                    currentPos = getRightPosition(currentPos);
                }
                break;
        }
    }
    
    private void scaleAll(double sx, double sy) {
        GeomTransform.scale(carPoints, sx, sy);
        GeomTransform.scale(yellowLightPoints, sx, sy);
        GeomTransform.scale(redLightPoints, sx, sy);
        GeomTransform.scale(rearPoints, sx, sy);
        GeomTransform.scale(platePoints, sx, sy);
        GeomTransform.scale(tirePoints, sx, sy);
        GeomTransform.scale(windowPoints, sx, sy);
        update(false);
    }

    private void translateAll(double x, double y) {
        GeomTransform.translate(carPoints, x, y);
        GeomTransform.translate(yellowLightPoints, x, y);
        GeomTransform.translate(redLightPoints, x, y);
        GeomTransform.translate(rearPoints, x, y);
        GeomTransform.translate(platePoints, x, y);
        GeomTransform.translate(tirePoints, x, y);
        GeomTransform.translate(windowPoints, x, y);
        update(false);
    }

    public GeneralPath getCar() {
        return car;
    }

    public GeneralPath getRedLight() {
        return redLight;
    }

    public GeneralPath getYellowLight() {
        return yellowLight;
    }

    public GeneralPath getRear() {
        return rear;
    }

    public GeneralPath getPlate() {
        return plate;
    }

    public GeneralPath getTire() {
        return tire;
    }

    public GeneralPath getWindow() {
        return window;
    }
}
