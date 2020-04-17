import model.Dot;
import model.Polygon;
import visual.Drawing;

import java.sql.SQLInput;
import java.util.ArrayList;

public class MainGlutton {
    //Liste indiquant les sommets qui sont encore disponibles pour tracer des cordes
    private ArrayList<Integer> remainingVertex;
    //polygone sur lequel on va travailler
    private Polygon polygon;

    public static void main(String[] args) {
        Test test = new Test();
        Polygon polygon = test.polygon1();
        //Polygon polygon = test.polygon2();
        //Polygon polygon = test.polygon3();
        //Polygon polygon = test.polygon4();
        //Polygon polygon = test.polygon5();
        MainGlutton mainGlutton = new MainGlutton(polygon);
        mainGlutton.gluttony();
        Drawing.draw(polygon);
    }

    /**
     * Constructeur qui récupère le polygone dont il extrait les sommets qu'il met dans remainingVertex
     * @param polygon
     */
    public MainGlutton(Polygon polygon)
    {
        this.polygon=polygon;
        remainingVertex =new ArrayList<>();
        for (Dot dot : polygon.getDotMap().values())
        {
            remainingVertex.add(dot.getId());
        }
    }

    /**
     * Renvoie l'id du prochain sommet pour lequel il est possible de tracer une corde le reliant au sommet d'id i
     * @param i
     * @return id d'un sommet
     */
    public int getFollowingRemainingVertex(int i)
    {
        int iIndex = remainingVertex.indexOf(i);
        if (iIndex==remainingVertex.size()-1)
        {
            return remainingVertex.get(1);
        }
        else if (iIndex==remainingVertex.size()-2)
        {
            return remainingVertex.get(0);
        }
        else
        {
            return remainingVertex.get(iIndex+2);
        }
    }

    /**
     * Renvoie la longueur de la corde partant de i allant vers getFollowingRemainingVertex(i)
     * @param i
     * @return longueur
     */
    public double ropeLenghtFrom(int i)
    {
        int j = getFollowingRemainingVertex(i);
        return polygon.length(i,j);
    }

    /**
     * Renvoie l'id du sommet qui suit le sommet 1
     * @param i
     * @return id d'un sommet
     */
    public int getDirectFollowingRemainingVertex(int i)
    {
        int iIndex = remainingVertex.indexOf(i);
        if (iIndex==remainingVertex.size()-1)
        {
            return remainingVertex.get(0);
        }
        else
        {
            return remainingVertex.get(iIndex+1);
        }
    }

    /**
     * Cherche la corde à ajouter en suivant la méthode gloutonne, l'ajoute, et renvoie sa longueur
     * @return longueur de la corde ajoutée
     */
    public double addRope()
    {
        double actionCost=ropeLenghtFrom(remainingVertex.get(0));
        int vertexMemo=remainingVertex.get(0);
        for (int dotId : remainingVertex)
        {
            double length = ropeLenghtFrom(dotId);
            if (length<actionCost)
            {
                actionCost=length;
                vertexMemo=dotId;
            }
        }
        polygon.addRope(vertexMemo,getFollowingRemainingVertex(vertexMemo));
        remainingVertex.remove(Integer.valueOf(getDirectFollowingRemainingVertex(vertexMemo)));
        return actionCost;
    }

    /**
     * Fonction mettant en place la méthode gloutonne pour la triangulation d'un polygone
     */
    public void gluttony()
    {
        double totalCost=0;

        if (polygon.getVertexNumber()<4)
        {
            System.out.println("Il faut au moins 4 côtés pour pouvoir tracer une corde");
            System.exit(1);
        }

        for (int iterate=0 ; iterate < polygon.getVertexNumber()-3 ; iterate++)
        {
            totalCost+=addRope();
        }
        System.out.println("Longueur totale : "+totalCost);
    }

    @Override
    public String toString() {
        return "MainGlutton{" +
                "remainingVertex=" + remainingVertex +
                ", polygon=" + polygon +
                '}';
    }
}
