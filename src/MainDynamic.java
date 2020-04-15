import model.Polygon;


public class MainDynamic {
    public static void main(String[] args) {

        double MAX = 1000.0;

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

        double[][] table = new double[n][n];

        if (n<3)
        {
            System.out.println("Un polygome soit avoir au moins 3 points.");
            System.exit(1);
        }

        for (int diff=0 ; diff<n ; diff++)
        {
            for (int startDot = 0 ; startDot+diff < n ; startDot++)
            {
                int endDot=startDot+diff;
                if (endDot < startDot + 2)
                {
                    table[startDot][endDot] = 0.0;
                }
                else
                {
                    table[startDot][endDot] = MAX;
                    for (int interDot = startDot+1 ; interDot<endDot ; interDot++)
                    {
                        double cost = table[startDot][interDot] + table[interDot][endDot] + polygon.length(startDot,endDot) + polygon.length(startDot, interDot) +polygon.length(interDot,endDot);
                        if (table[startDot][endDot]>cost)
                        {
                            table[startDot][endDot] = cost;
                        }
                    }
                }

            }
        }
        System.out.println(table[0][n-1]);
    }
}
