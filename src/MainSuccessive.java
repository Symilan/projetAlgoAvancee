import model.*;
import visual.Drawing;

public class MainSuccessive {
    public static void main(String[] args) {
        Test test = new Test();
        //Polygon polygon = test.polygon1();
        //Polygon polygon = test.polygon2();
        Polygon polygon = test.polygon3();
        //Polygon polygon = test.polygon4();
        //Polygon polygon = test.polygon5();
        polygon.triangulationMin();
        Drawing.draw(polygon);
    }
}
