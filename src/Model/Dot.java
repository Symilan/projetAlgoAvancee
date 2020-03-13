package Model;

public class Dot {
    public static Integer nbInstance = 0;
    private Integer id;
    private Integer x;
    private Integer y;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dot(Integer x, Integer y)
    {
        this.id=nbInstance;
        this.x = x;
        this.y = y;
        nbInstance++;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point" + id + '(' + x + ';' + y + ')';
    }
}
