package Frame;

import Object.Car;
import Object.Landscape;
import Object.Mountain;
import Object.Obstacle;
import Object.Sky;
import Object.Sun;
import Object.Track;
import Util.Util;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Enduro extends JPanel {

    private Landscape landscape;
    private Track track;
    private Sky sky;
    private Mountain mountain;
    private Sun sun;
    private Car car;
    private Obstacle[] obstacles;
    
    private int nextIndexOfObstacle, indexOfOlderObstacle;
    private static final int MAX_OBSTACLES = 20;
    
    private int scoreboard;
    private int randomTime;
    private boolean isInit, isGameOver;
    
    private Timer timer;
    private static Thread tCreateObstacle;

    private static KeyboardAction ka;

    public Enduro() {
        scoreboard = 0;
        isInit = false;
        ka = new Enduro.KeyboardAction();
        
        this.setPreferredSize(new Dimension(Util.screensize.width, Util.screensize.height));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (!isInit || isGameOver) {
            g2d.setColor(Color.black);
            g2d.setFont(new Font("default", Font.BOLD, 36));
            g2d.drawString("Pontuação: " + scoreboard, 50, 75);
            g2d.setFont(new Font("default", Font.BOLD, 50));
            if (!isInit) {
                g2d.drawString("PRESSIONE QUALQUER", (float) (Util.screensize.width * 0.5 - 275),
                        (float) (Util.screensize.height * 0.5 - 75));
                g2d.drawString("TECLA", (float) (Util.screensize.width * 0.5 - 75),
                        (float) (Util.screensize.height * 0.5 - 25));
            } else if (isGameOver) {
                g2d.drawString("GAME OVER", (float) (Util.screensize.width * 0.5 - 150),
                        (float) (Util.screensize.height * 0.5 - 50));
            }
            return;
        }

        g2d.setColor(new Color(44, 176, 55));
        g2d.draw(landscape.getGp());
        g2d.fill(landscape.getGp());

        g2d.setColor(Color.gray.darker());
        g2d.draw(track.getGp());
        g2d.fill(track.getGp());

        g2d.setColor(Color.yellow.darker());
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(track.getLine());
        
        g2d.setColor(new Color(135, 206, 250));
        g2d.setStroke(new BasicStroke(1));
        g2d.draw(sky.getGp());
        g2d.fill(sky.getGp());
        
        g2d.setColor(Color.yellow);
        g2d.draw(sun.getGp());
        g2d.fill(sun.getGp());
        
        g2d.setColor(new Color(90, 77, 65));
        g2d.draw(mountain.getGp());
        g2d.fill(mountain.getGp());
        
        for (int i = 0; i < getObstaclesSize(); i++) {
            g2d.setColor(obstacles[i].getColor());
            g2d.draw(obstacles[i].getGp());
            g2d.fill(obstacles[i].getGp());
        }

        g2d.setColor(Color.black);
        g2d.draw(car.getGp());
        g2d.fill(car.getGp());

        g2d.setFont(new Font("default", Font.BOLD, 36));
        g2d.drawString("Pontuação: " + scoreboard, 50, 75);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Enduro");
        f.add(new Enduro());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addKeyListener(ka);

        f.pack();
        f.setResizable(false);
        f.setLocation((Util.screensize.width - f.getWidth()) / 2,
                (Util.screensize.height - f.getHeight()) / 2);
        f.setLocationByPlatform(true);
        f.setBackground(Color.white);
        f.setVisible(true);
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
                Color color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
                switch (r.nextInt(3)) {
                    case 0:
                        obstacles[pos] = new Obstacle(-1.25, color);
                        break;
                    case 1:
                        obstacles[pos] = new Obstacle(0.0, color);
                        break;
                    case 2:
                        obstacles[pos] = new Obstacle(1.25, color);
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

        landscape = new Landscape();
        track = new Track();
        sky = new Sky();
        mountain = new Mountain();
        sun = new Sun();
        car = new Car();
        obstacles = new Obstacle[MAX_OBSTACLES];
        
        nextIndexOfObstacle = 0;
        indexOfOlderObstacle = 0;

        randomTime = 900;
        isGameOver = false;

        tCreateObstacle = new Thread(createObstacle());
        tCreateObstacle.start();

        Util.sleep(1000);
        ActionListener al = (ActionEvent ae) -> {
            repaint();

            if (car.getGp().intersects(obstacles[indexOfOlderObstacle].getGp().getBounds2D())) {
                isGameOver = true;
                timer.stop();
                finish();
            }

            double carHeight = car.getGp().getCurrentPoint().getY();
            double obstacleHeight = obstacles[indexOfOlderObstacle].getGp().getCurrentPoint().getY();
            if (carHeight < obstacleHeight && obstacleHeight < Util.screensize.height - 90) {
                scoreboard++;
                indexOfOlderObstacle = (indexOfOlderObstacle + 1) % MAX_OBSTACLES;
            }

        };
        timer = new Timer(100, al);
        timer.start();
    }

    private void finish() {
        ActionListener al = (ActionEvent ae) -> {
            repaint();
            timer.stop();

            scoreboard = 0;
            isInit = false;
            repaint();
        };
        timer = new Timer(3000, al);
        timer.start();
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
}
