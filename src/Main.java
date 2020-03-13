import Model.*;

public class Main {
    public static void main(String[] args) {
        Polygon polygon=new Polygon();
        try {
            polygon.addDot(0,0);
            polygon.addDot(0,1);
            polygon.addDot(1,0);
            polygon.addDot(1,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(polygon);
    }
}
