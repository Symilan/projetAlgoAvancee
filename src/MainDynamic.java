import model.Polygon;
import visual.Drawing;


public class MainDynamic {
    public static void main(String[] args) {

        //On définit une constante qui représente une longueur qui ne pourra pas être atteinte afin de faciliter les calculs
        final double MAX = Double.MAX_VALUE;

        //On crée le polygone que l'on va étudier et récupère son nombre de sommets
        Polygon polygon = new Polygon();
        try {
            polygon.addDot(0,0);
            polygon.addDot(1,0);
            polygon.addDot(2,1);
            polygon.addDot(1,2);
            polygon.addDot(0,2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int n = polygon.getVertexNumber();

        //tableCost[i][j] contiendra le poid d'une triangulation entre i et j (c'est à dire la longueure de ses côtés)
        double[][] tableCost = new double[n][n];
        //tableTrig[i][j] contientra k si le triangle k,i,j est dans la triangulation optimale, -1 sinon
        int[][] tableTrig = new int[n][n];
        for (int i = 0 ; i<n ; i++)
        {
            for (int j = 0 ; j < n ; j++)
            {
                tableTrig[i][j] = -1;
            }
        }

        //Test de cas limite
        if (n<3)
        {
            System.out.println("Un polygone doit avoir au moins 3 points.");
            System.exit(1);
        }


        for (int diff=0 ; diff<n ; diff++)
        {
            for (int startDot = 0 ; startDot+diff < n ; startDot++)
            {
                int endDot=startDot+diff;
                if (endDot < startDot + 2)
                {
                    tableCost[startDot][endDot] = 0.0;
                }
                else
                {
                    tableCost[startDot][endDot] = MAX;
                    for (int interDot = startDot+1 ; interDot<endDot ; interDot++)
                    {
                        double cost = tableCost[startDot][interDot] + tableCost[interDot][endDot] + polygon.length(startDot,endDot) + polygon.length(startDot, interDot) +polygon.length(interDot,endDot);
                        if (tableCost[startDot][endDot]>cost)
                        {
                            tableCost[startDot][endDot] = cost;
                            tableTrig[startDot][endDot] = interDot;
                        }
                    }
                }
            }
        }
        double totalLength = tableCost[0][n-1];
        double perim = polygon.length(n-1,0);
        for (int i=0 ; i<n-1 ; i++)
        {
            perim+=polygon.length(i,i+1);
        }
        double res = totalLength-perim;
        res/=2;
        System.out.println("Longueur de la triangulation minimale : "+res);
        for (int i = 0 ; i<n ; i++)
        {
            for (int j = 0; j < n; j++)
            {
                    System.out.print("i = "+i);
                    System.out.print(", j = "+j);
                    System.out.println(", t = "+tableCost[i][j]);
                    /*polygon.addRope(i,tableTrig[i][j]);
                    polygon.addRope(j,tableTrig[i][j]);
                    polygon.addRope(i,j);*/
            }
        }
       Drawing.draw(polygon);
    }
}
