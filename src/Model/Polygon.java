package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Polygon {
    private Integer vertexNumber;
    private ArrayList<Rope> ropeList;
    private HashMap<Integer, Dot> dotMap;

    public void addRope(Dot i, Dot j)
    {
        if(validateRope(i,j))
        {
            ropeList.add(new Rope(i,j));
        }
    }

    public void addRope(Integer i, Integer j)
    {
        Dot dotI=dotMap.get(i);
        Dot dotJ=dotMap.get(j);
        if(validateRope(dotI,dotJ))
        {
            ropeList.add(new Rope(dotI, dotJ));
        }
    }

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

    public Boolean validateRope(Integer i, Integer j)
    {
        return validateRope(dotMap.get(i),dotMap.get(j));
    }

    public void addDot(Integer x, Integer y) throws Exception {
        Dot dot = new Dot(x, y);
        if (dotMap.containsValue(dot))
        {
            Dot.nbInstance--;
            throw new Exception("On ne peut pas placer deux dots au même endroit.");
        }
        dotMap.put(dot.getId(),dot);
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
