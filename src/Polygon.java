import java.util.ArrayList;

public class Polygon {
    private Integer vertexNumber;
    private ArrayList<Dot> vertexList;

    public Polygon() {
    }

    public Integer getVertexNumber() {
        return vertexNumber;
    }

    public void setVertexNumber(Integer vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public ArrayList<Dot> getVertexList() {
        return vertexList;
    }

    public void setVertexList(ArrayList<Dot> vertexList) {
        this.vertexList = vertexList;
    }
}
