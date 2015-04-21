package Util;

import Entity.Point;
import java.util.List;

public class GeomTransform {

    public static void translate(List<Point> points, double x, double y) {
        points.stream().map((p) -> {
            p.x += x;
            return p;
        }).forEach((p) -> {
            p.y += y;
        });
    }

    public static void rotate(List<Point> points, double rad) {
        points.stream().forEach((p) -> {
            double x = p.x;
            double y = p.y;
            p.x = x * Math.cos(rad) - y * Math.sin(rad);
            p.y = x * Math.sin(rad) + y * Math.cos(rad);
        });
    }
    
    public static void scale(List<Point> points, double sx, double sy) {
        points.stream().map((p) -> {
            p.x *= sx;
            return p;
        }).forEach((p) -> {
            p.y *= sy;
        });
    }
}
