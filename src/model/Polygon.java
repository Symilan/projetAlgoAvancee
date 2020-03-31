package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Polygon {
    private Integer vertexNumber;
    private HashMap<Integer, Rope> ropeMap;
    private HashMap<Integer, Dot> dotMap;

    public void addRope(Dot i, Dot j)
    {
        if(validateRope(i,j))
        {
            Rope rope = new Rope(i,j);
            ropeMap.put(rope.getId(),rope);
        }
    }

    public void addRope(Integer i, Integer j)
    {
        Dot dotI=dotMap.get(i);
        Dot dotJ=dotMap.get(j);
        Rope rope = new Rope(dotI,dotJ);
        if(validateRope(dotI,dotJ))
        {
            ropeMap.put(rope.getId(),rope);
        }
    }

    public Boolean validateRope(Dot i, Dot j)
    {
        for(Rope rope : ropeMap.values())
        {
            if (rope.equals(i,j) || rope.cross(i,j))
            {
                Rope.nbInstance--;
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
                ", ropeList=" + ropeMap +
                ", dotMap=" + dotMap +
                '}';
    }

    public Polygon()
    {
        this.vertexNumber=0;
        this.ropeMap =new HashMap<>();
        this.dotMap=new HashMap<>();
    }

    public Polygon(HashMap<Integer,Dot> dotMap)
    {
        this.vertexNumber=dotMap.size();
        this.dotMap=dotMap;
        this.ropeMap =new HashMap<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygon polygon = (Polygon) o;
        return Objects.equals(vertexNumber, polygon.vertexNumber) &&
                Objects.equals(ropeMap, polygon.ropeMap) &&
                Objects.equals(dotMap, polygon.dotMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexNumber, ropeMap, dotMap);
    }

    public Integer getVertexNumber() {
        return vertexNumber;
    }

    public void setVertexNumber(Integer vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public HashMap<Integer, Rope> getRopeMap() {
        return ropeMap;
    }

    public void setRopeMap(HashMap<Integer, Rope> ropeMap) {
        this.ropeMap = ropeMap;
    }

    public HashMap<Integer, Dot> getDotMap() {
        return dotMap;
    }

    public void setDotMap(HashMap<Integer, Dot> dotMap) {
        this.dotMap = dotMap;
    }
}
