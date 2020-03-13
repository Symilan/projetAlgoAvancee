package Model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return Objects.equals(x, dot.x) &&
                Objects.equals(y, dot.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
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
