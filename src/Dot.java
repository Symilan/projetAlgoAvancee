public class Dot {

    private int id;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Point" + id + '(' + x + ';' + y + ')';
    }
}
