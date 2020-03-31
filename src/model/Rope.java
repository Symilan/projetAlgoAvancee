package model;

public class Rope {
    public static Integer nbInstance = 0;
    private Integer id;
    private Dot i;
    private Dot j;

    public Boolean cross(Dot i, Dot j)
    {
        return true;
    }

    public Rope() {
        this.id=nbInstance;
        nbInstance++;
    }

    public Rope(Dot i, Dot j) {
        this.id=nbInstance;
        nbInstance++;
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

    public Double lenght()
    {
        Integer iX = i.getX();
        Integer iY = i.getY();
        Integer jX = j.getX();
        Integer jY = j.getY();
        Integer resSquare = ((iX - iY) ^ 2) + ((jX - jY) ^ 2);
        System.out.println();
        return Double.valueOf(0);
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

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
