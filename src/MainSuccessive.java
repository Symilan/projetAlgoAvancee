import model.*;

public class MainSuccessive {
    public static void main(String[] args) {
        Polygon polygon = new Polygon();
        try {
            polygon.addDot(0,0);
            polygon.addDot(5,-3);
            polygon.addDot(10,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
