package Model;

public class Rope {
    private Dot i;
    private Dot j;

    public Boolean cross(Dot i, Dot j)
    {
        return true;
    }

    public Rope() { }

    public Rope(Dot i, Dot j) {
        this.i = i;
        this.j = j;
    }

    public Boolean equals(Dot i, Dot j)
    {
        return this.equals(i.getId(),j.getId());
    }

    public Boolean equals(Integer i, Integer j)
    {
        if((this.getI().getId()==i && this.getJ().getId()==j) || (this.getI().getId()==j && this.getJ().getId()==i))
        {
            return true;
        }
        else
        {
            return false;
        }
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
