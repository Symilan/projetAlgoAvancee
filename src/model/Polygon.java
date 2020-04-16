package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Polygon {
    private Integer vertexNumber;
    private ArrayList<Rope> ropeList;
    private HashMap<Integer, Dot> dotMap;
    private Double Minlength;

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
        return validateRope(dotMap.get(i),dotMap.get(j)) && i != ((j+1)%vertexNumber) && i!=j && i!=((j-1)%vertexNumber)
               && j != ((i+1)%vertexNumber) && j!=((i-1)%vertexNumber);
    }

    public void addDot(Integer x, Integer y) throws Exception {
        Dot dot = new Dot(x, y);
        if (dotMap.containsValue(dot))
        {
            Dot.nbInstance--;
            throw new Exception("On ne peut pas placer deux dots au même endroit.");
        }
        vertexNumber++;
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
        this.Minlength = 0.0 ;
    }

    public Polygon(HashMap<Integer,Dot> dotMap)
    {
        this.vertexNumber=dotMap.size();
        this.dotMap=dotMap;
        this.ropeList =new ArrayList<>();
        this.Minlength = 0.0 ;
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

    public double[] getAllX()
    {
        ArrayList<Dot> dotList = new ArrayList<>(getDotMap().values());
        double[] res = new double[dotList.size()];
        for (int i=0 ; i<dotList.size() ; i++)
        {
            res[i]=dotList.get(i).getX();
        }
        return res;
    }

    public double[] getAllY()
    {
        ArrayList<Dot> dotList = new ArrayList<>(getDotMap().values());
        double[] res = new double[dotList.size()];
        for (int i=0 ; i<dotList.size() ; i++)
        {
            res[i]=dotList.get(i).getY();
        }
        return res;
    }

    public void triangulationMin (){
        this.ropeList = new ArrayList<>();
        this.Minlength = 0.0;
        triangulationMinAux(new ArrayList<>(),0,0,0);
    }
    public void triangulationMinAux (ArrayList<Rope> C, int si, double currentLength,int numberRope){
        //newRope prend la valeur de la nouvelle corde que l'on veut rajouter qui est valide
        Rope newRope;
        //addition prend la nouvelle valeur de la longueur en ajoutant celle de newRope
        double addition;
        //newC est la nouvelle liste de corde que l'on obtient avec newRope
        ArrayList<Rope> newC = new ArrayList<>(C);
        //p est le polygon actuel sans nouvelle corde
        Polygon p = new Polygon(this.dotMap);
        p.setRopeList(C);
        p.setVertexNumber(this.vertexNumber);
        //Condition d'arrêt : si on atteint le dernier sommet à tester
        if(si == dotMap.size()) {
            //On remplace cette triangulation par celle trouvé avant si elle est de longueur plus petite
            //ou si c'est la première trouvé ( la longueur min est de 0 si c'est la première)
            if (((currentLength <= this.Minlength) || (this.Minlength == 0)) && (numberRope == (vertexNumber-3) )) {
                this.Minlength = currentLength;
                this.ropeList = C;
            }
        }
        else {
            //On test une corde pour chaque sommet du polygon à partir de si
            for (int i = 0; i < vertexNumber; i++) {
                if (p.validateRope(si, i)) {
                    newRope = new Rope(dotMap.get(si), dotMap.get(i));
                    addition = newRope.length() + currentLength;
                    newC.add(newRope);
                    //condition d'élagage: si la longueur des cordes dépasse déjà celui trouvé on arrête
                    if ((addition <= this.Minlength) || (this.Minlength == 0)) {
                        //On passe au prochains sommet avec newRope ajouté à C
                        triangulationMinAux(newC,(si+1), addition,(numberRope+1));
                    }
                    //On réinitialise newC
                    newC = new ArrayList<>(C);
                }
            }
            //On passe au prochains sommet sans créer de corde
            triangulationMinAux(C, (si + 1), currentLength, numberRope);
        }
    }

    public int nextSummit(Polygon polygon, Integer i)
    {
        return (i+1)%vertexNumber;
    }

    public ArrayList<double[][]> ropesToList()
    {
        ArrayList<double[][]> res = new ArrayList<>();
        for (Rope rope : ropeList)
        {
            double[] tempY = new double[2];
            double[] tempX = new double[2];
            tempX[0] = rope.getI().getX();
            tempX[1] = rope.getJ().getX();
            tempY[0] = rope.getI().getY();
            tempY[1] = rope.getJ().getY();
            res.add(new double[][]{tempX, tempY});
        }
        return res;
    }

    public double length(Dot i, Dot j)
    {
        Integer iX = i.getX();
        Integer iY = i.getY();
        Integer jX = j.getX();
        Integer jY = j.getY();
        Integer resSquare = (iX - jX)*(iX - jX) + (iY - jY)*(iY - jY);
        return Math.sqrt(resSquare);
    }

    public double length(int i, int j)
    {
        return length(getDotMap().get(i),getDotMap().get(j));
    }



}