import model.*;

public class Test {


    public Polygon polygon1(){
        Polygon polygon = new Polygon();
        try {
            polygon.addDot(0,0);
            polygon.addDot(1,0);
            polygon.addDot(2,1);
            polygon.addDot(1,2);
            polygon.addDot(0,2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return polygon;
    }


    public Polygon polygon2(){
        Polygon polygon = new Polygon();
        try {
            polygon.addDot(0,0);
            polygon.addDot(2,0);
            polygon.addDot(4,2);
            polygon.addDot(2,5);
            polygon.addDot(1,5);
            polygon.addDot(0,4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return polygon;
    }


    public Polygon polygon3(){
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
        return polygon;
    }


    public Polygon polygon4(){
        Polygon polygon = new Polygon();
        try {
            polygon.addDot(1,0);
            polygon.addDot(5,5);
            polygon.addDot(3,9);
            polygon.addDot(1,10);
            polygon.addDot(-1,5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return polygon;
    }



    public Polygon polygon5(){
        Polygon polygon = new Polygon();
        try {
            polygon.addDot(5,0);
            polygon.addDot(7,4);
            polygon.addDot(5,11);
            polygon.addDot(2,5);
            polygon.addDot(1,3);
            polygon.addDot(2,0);
        } catch (Exception e) {
        e.printStackTrace();
        }
        return polygon;
        }


}
