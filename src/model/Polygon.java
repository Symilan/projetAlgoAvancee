package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Polygon {
    private Integer vertexNumber;
    private ArrayList<Rope> ropeList;
    private HashMap<Integer, Dot> dotMap;

    public void addRope(Dot i, Dot j)
    {
        if(validateRope(i,j))
        {
            Rope rope = new Rope(i,j);
            ropeList.add(rope);
        }
    }

    public void addRope(Integer i, Integer j)
    {
        Dot dotI=dotMap.get(i);
        Dot dotJ=dotMap.get(j);
        Rope rope = new Rope(dotI,dotJ);
        if(validateRope(dotI,dotJ))
        {
            ropeList.add(rope);
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
                ", dotMap=" + dotMap +
                '}';
    }

    public Polygon()
    {
        this.vertexNumber=0;
        this.ropeList =new ArrayList<>();
        this.dotMap=new HashMap<>();
    }

    public Polygon(HashMap<Integer,Dot> dotMap)
    {
        this.vertexNumber=dotMap.size();
        this.dotMap=dotMap;
        this.ropeList =new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygon polygon = (Polygon) o;
        return Objects.equals(vertexNumber, polygon.vertexNumber) &&
                Objects.equals(ropeList, polygon.ropeList) &&
                Objects.equals(dotMap, polygon.dotMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexNumber, ropeList, dotMap);
    }

    public Integer getVertexNumber() {
        return vertexNumber;
    }

    public void setVertexNumber(Integer vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public ArrayList<Rope> getRopeList() {
        return ropeList;
    }

    public void setRopeList(ArrayList<Rope> ropeList) {
        this.ropeList = ropeList;
    }

    public HashMap<Integer, Dot> getDotMap() {
        return dotMap;
    }

    public void setDotMap(HashMap<Integer, Dot> dotMap) {
        this.dotMap = dotMap;
    }

    public double[] toList()
    {
        ArrayList<Dot> dotList = new ArrayList<>(dotMap.values());

        double[] res = new double[dotList.size()*2];

        for (int i=0 ; i<dotList.size() ; i++)
        {
            res[2*i]  =dotList.get(i).getX();
            res[2*i+1]=dotList.get(i).getY();
        }

        return res;
    }
}