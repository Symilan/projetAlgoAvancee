package Model;

import java.util.ArrayList;

public class Polygon {
    private Integer vertexNumber;
    private ArrayList<Rope> ropeList;

    public Boolean validateRope(Integer i, Integer j)
    {
        for(Rope rope : ropeList)
        {
            if (rope.equals(i,j))
            {
                return false;
            }
        }
        return true;
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
