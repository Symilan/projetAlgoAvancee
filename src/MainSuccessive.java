import model.*;
import visual.Drawing;

public class MainSuccessive {
    public static void main(String[] args) {
        Polygon polygon = new Polygon();
        try {
            polygon.addDot(0,0);
            polygon.addDot(2,0);
            polygon.addDot(3,1);
            polygon.addDot(5,4);
            polygon.addDot(4,8);
            polygon.addDot(2,9);
            polygon.addDot(1,9);
            polygon.addDot(-2,3);
            polygon.addDot(-1,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        polygon.triangulationMin();
        Drawing.draw(polygon);
    }
}
