import model.Polygon;
/*import visual.Drawing;*/


public class MainDynamic {
    public static void main(String[] args) {

        double MAX = 1000.0;

        Polygon polygon = new Polygon();
        try {
            polygon.addDot(4,1);
            polygon.addDot(2,3);
            polygon.addDot(3,5);
            polygon.addDot(5,4);
            polygon.addDot(6,2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int n = polygon.getVertexNumber();

        double[][] tableCost = new double[n][n];
        int[][] tableTrig = new int[n][n];
        for (int i = 0 ; i<n ; i++)
        {
            for (int j = 0 ; j < n ; j++)
            {
                tableTrig[i][j] = -1;
            }
        }

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
        System.out.println(tableCost[0][n-1]);
        for (int i = 0 ; i<n ; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (tableTrig[i][j] != -1)
                {
                    polygon.addRope(i,tableTrig[i][j]);
                    polygon.addRope(j,tableTrig[i][j]);
                    polygon.addRope(i,j);
                }
            }
        }
       /* Drawing.draw(polygon);*/
    }
}
