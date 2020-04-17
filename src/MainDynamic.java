import model.Polygon;
import visual.Drawing;


public class MainDynamic {
    public static void main(String[] args) {

        //On définit une constante qui représente une longueur qui ne pourra pas être atteinte afin de faciliter les calculs
        final double MAX = Double.MAX_VALUE;

        //On crée le polygone que l'on va étudier et récupère son nombre de sommets
        Test test = new Test();
        //Polygon polygon = test.polygon1();
        //Polygon polygon = test.polygon2();
        Polygon polygon = test.polygon3();
        //Polygon polygon = test.polygon4();
        //Polygon polygon = test.polygon5();
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

        //début de la fonction dynamique, on fait une boucle if gérant l'écart entre les points startDot et endDot qui vont parcourir le polygone
        for (int diff=0 ; diff<n ; diff++)
        {
            //création du point startDot qui va parcourir le triangle
            for (int startDot = 0 ; startDot+diff < n ; startDot++)
            {
                int endDot=startDot+diff;
                //condition d'arrêt
                if (endDot < startDot + 2)
                {
                    tableCost[startDot][endDot] = 0.0;
                }
                else
                {
                    tableCost[startDot][endDot] = MAX;
                    int choosenSummit=-1;
                    //tentative de création d'un triangle avec pour base le segment [startDot,endDot] et comme sommet interDot, qui va parcourir tous les sommets du polygone entre startDot et endDot exclus
                    for (int interDot = startDot+1 ; interDot<endDot ; interDot++)
                    {
                        //comparaison du poid du triangle tracé
                        double cost = tableCost[startDot][interDot] + tableCost[interDot][endDot] + polygon.length(startDot,endDot) + polygon.length(startDot, interDot) +polygon.length(interDot,endDot);
                        if (tableCost[startDot][endDot]>cost)
                        {
                            tableCost[startDot][endDot] = cost;
                            choosenSummit=interDot;
                        }
                    }
                    tableTrig[startDot][endDot] = choosenSummit;
                }
            }
        }
        //récupération de la longueur des côtés des triangles pour en extraire le bon résultat (la longueur totale des cordes)
        double totalLength = tableCost[0][n-1];
        double perim = polygon.length(n-1,0);
        for (int i=0 ; i<n-1 ; i++)
        {
            perim+=polygon.length(i,i+1);
        }
        double res = totalLength-perim;
        res/=2;
        System.out.println("Longueur de la triangulation minimale : "+res);
        //Dessin du polygone
       Drawing.draw(polygon);
    }
}
