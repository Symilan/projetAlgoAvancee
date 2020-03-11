package Model;

public class Rope {
    private Dot i;
    private Dot j;

    public Rope() {
    }

    public Rope(Dot i, Dot j) {
        this.i = i;
        this.j = j;
    }

    public Dot getI() {
        return i;
    }

    public void setI(Dot i) {
        this.i = i;
    }

    public Dot getJ() {
        return j;
    }

    public void setJ(Dot j) {
        this.j = j;
    }
}
