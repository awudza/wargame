package projet.modeles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Type;

public class Cellule extends Polygon{

    public static final int SIDES = 6;

    private Point[] points = new Point[SIDES];
    private Point center = new Point(0, 0);
    private int radius;
    private int rotation = 90;
    private int id;
    private boolean etat;
    private Terrain terrain;
    private TypeTerrain typeTerrain;

    /**
     *
     * @param center
     * @param radius
     */
    public  Cellule(Point center, int radius){
        npoints = SIDES;
        xpoints = new int[SIDES];
        ypoints = new int[SIDES];
        this.etat=false;
        this.center = center;
        this.radius = radius;
        modifierPoints();
    }

    public Cellule(int x, int y, int radius) {
        this(new Point(x, y), radius);
    }

    /**
     *
     * @return
     */
    public Point getCenter() {
        return center;
    }

    /**
     *
     * @return le terrain
     */

    public Terrain getTerrain() {
        return terrain;
    }

    /**
     *
     * @return l'id
     */

    public int getId() {
        return id;
    }

    /**
     *
     * @return le type du terrain
     */

    public TypeTerrain getTypeTerrain() {
        return typeTerrain;
    }

    /**
     *
     * @param terrain
     */

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    /**
     *
     * @param id
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param etat
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    /**
     *
     * @param typeTerrain
     */
    public void setTypeTerrain(TypeTerrain typeTerrain) {
        this.typeTerrain = typeTerrain;
    }

    /**
     *
     * @param fraction
     * @return
     */
    private double calculerAngle(double fraction) {
        return fraction * Math.PI * 2 + Math.toRadians((rotation + 180) % 360);
    }

    /**
     *
     * @param angle
     * @return
     */
    private Point calculerPoint(double angle) {
        int x = (int) (center.x + Math.cos(angle) * radius);
        int y = (int) (center.y + Math.sin(angle) * radius);

        return new Point(x, y);
    }

    /**
     *
     */
    protected void modifierPoints() {
        for (int p = 0; p < SIDES; p++) {
            double angle = calculerAngle((double) p / SIDES);
            Point point = calculerPoint(angle);
            xpoints[p] = point.x;
            ypoints[p] = point.y;
            points[p] = point;
//            System.out.printf("%d. (%d, %d)\n", p, point.x, point.y);
        }
    }

    public boolean contain(int x,int y){
        return contains(x,y);
    }
}
