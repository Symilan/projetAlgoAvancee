package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Polygon {
    private Integer vertexNumber;
    private ArrayList<Rope> ropeList;
    private HashMap<Integer, Dot> dotMap;

    public Boolean validateRope(Dot i, Dot j)
    {
        for(Rope rope : ropeList)
        {
            if (rope.equals(i,j) || rope.cross(i,j))
            {
                return false;
            }
        }
        return true;
    }

    public void addDot(Integer x, Integer y)
    {

    }

    @Override
    public String toString() {
        return "Polygon{" +
                "vertexNumber=" + vertexNumber +
                ", ropeList=" + ropeList +
                '}';
    }

    public Polygon()
    {
        this.vertexNumber=0;
        this.ropeList=new ArrayList<>();
    }

    public Polygon(ArrayList<Rope> ropeList)
    {
        this.vertexNumber=ropeList.size();
        this.ropeList=ropeList;
    }

    public Integer getVertexNumber() {
        return vertexNumber;
    }

    public void setVertexNumber(Integer vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public ArrayList<Rope> getropeList() {
        return ropeList;
    }

    public void setropeList(ArrayList<Rope> ropeList) {
        this.ropeList = ropeList;
    }
}
