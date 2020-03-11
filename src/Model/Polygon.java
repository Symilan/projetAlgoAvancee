package Model;

import Model.Dot;

import java.util.ArrayList;

public class Polygon {
    private Integer vertexNumber;
    private ArrayList<Dot> vertexList;

    @Override
    public String toString() {
        return "Polygon{" +
                "vertexNumber=" + vertexNumber +
                ", vertexList=" + vertexList +
                '}';
    }

    public Polygon()
    {
        this.vertexNumber=0;
        this.vertexList=new ArrayList<>();
    }

    public Polygon(ArrayList<Dot> vertexList)
    {
        this.vertexNumber=vertexList.size();
        this.vertexList=vertexList;
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
