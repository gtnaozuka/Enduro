package Frame;

import Object.Car;
import Object.Obstacle;
import Util.Util;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Enduro extends Frame {

    private Obstacle[] obstacles;
    private int nextIndexOfObstacle, indexOfOlderObstacle;
    private static final int MAX_OBSTACLES = 20;

    private Car car;
    private int scoreboard;
    private int randomTime;
    private boolean isInit, isGameOver;

    private static Thread tCreateObstacle;
    private static Thread tRepaint;

    public Enduro() {
        super("Enduro");

        scoreboard = 0;
        isInit = false;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });
        this.addKeyListener(new Enduro.KeyboardAction());
        this.addMouseListener(new Enduro.MouseAction());
        this.pack();
        this.setResizable(false);
        this.setSize(Util.screensize.width, Util.screensize.height);
        this.setLocation((Util.screensize.width - this.getWidth()) / 2,
                (Util.screensize.height - this.getHeight()) / 2);
        this.setBackground(java.awt.Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.black);
        g.setFont(new Font("default", Font.BOLD, 36));
        g2d.drawString("Pontuação: " + scoreboard, 50, 100);
        if (!isInit) {
            g2d.setFont(new Font("default", Font.BOLD, 50));
            g2d.drawString("CLICK TO PLAY", (float) (Util.screensize.width * 0.5 - 200),
                    (float) (Util.screensize.height * 0.5 - 25));
            return;
        }
        if (isGameOver) {
            g2d.setFont(new Font("default", Font.BOLD, 50));
            g2d.drawString("GAME OVER", (float) (Util.screensize.width * 0.5 - 150),
                    (float) (Util.screensize.height * 0.5 - 25));
            return;
        }

        g2d.setColor(Color.red);
        for (int i = 0; i < getObstaclesSize(); i++) {
            g2d.draw(obstacles[i].getGp());
            g2d.fill(obstacles[i].getGp());
        }

        g2d.setColor(Color.blue);
        g2d.draw(car.getGp());
        g2d.fill(car.getGp());
    }

    public static void main(String[] args) {
        Enduro e = new Enduro();
        e.setVisible(true);
    }

    private int getObstaclesSize() {
        if (nextIndexOfObstacle < MAX_OBSTACLES) {
            return nextIndexOfObstacle;
        }
        return MAX_OBSTACLES;
    }

    private Runnable createObstacle() {
        return () -> {
            Random r = new Random();
            while (!isGameOver) {
                int pos = nextIndexOfObstacle % MAX_OBSTACLES;
                switch (r.nextInt(3)) {
                    case 0:
                        obstacles[pos] = new Obstacle(-1.0);
                        break;
                    case 1:
                        obstacles[pos] = new Obstacle(0.0);
                        break;
                    case 2:
                        obstacles[pos] = new Obstacle(1.0);
                        break;
                }
                obstacles[pos].gettUpdateObstacle().start();
                nextIndexOfObstacle++;

                if (pos == 0 && randomTime != 300) {
                    randomTime -= 100;
                }
                Util.sleep(r.nextInt(200) + randomTime);
            }
        };
    }

    private void start() {
        isInit = true;

        obstacles = new Obstacle[MAX_OBSTACLES];
        nextIndexOfObstacle = 0;
        indexOfOlderObstacle = 0;

        car = new Car();
        randomTime = 900;
        isGameOver = false;

        tCreateObstacle = new Thread(createObstacle());
        tRepaint = new Thread(new Animation(this));
        tCreateObstacle.start();
        tRepaint.start();
    }

    private class KeyboardAction extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (!isInit) {
                start();
                return;
            }

            int keyCode = e.getKeyCode();
            car.keyBoard(keyCode);
        }
    }

    private class MouseAction extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (!isInit) {
                start();
            }
        }
    }

    private class Animation extends Applet implements Runnable {

        private final Frame frame;

        public Animation(Frame frame) {
            this.frame = frame;
        }

        @Override
        public void run() {
            Util.sleep(1000);
            while (true) {
                frame.repaint();

                if (car.getGp().intersects(obstacles[indexOfOlderObstacle].getGp().getBounds2D())) {
                    isGameOver = true;
                    break;
                }

                double carHeight = car.getGp().getCurrentPoint().getY();
                double obstacleHeight = obstacles[indexOfOlderObstacle].getGp().getCurrentPoint().getY();
                if (carHeight < obstacleHeight && obstacleHeight < Util.screensize.height - 90) {
                    scoreboard++;
                    indexOfOlderObstacle = (indexOfOlderObstacle + 1) % MAX_OBSTACLES;
                }
                
                Util.sleep(100);
            }
            frame.repaint();
            Util.sleep(3000);

            scoreboard = 0;
            isInit = false;
            frame.repaint();
        }
    }
}
