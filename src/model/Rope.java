package model;

public class Rope {
    private Dot i;
    private Dot j;
    private final double EPSILON = 0.01;

    public Boolean cross(Dot i1, Dot j1)
    {
        Boolean bool = false;
        // x et y du dot de croisement des deux droites des rope
        double xc = 0;
        double yc = 0;
        //coef de la droite de la rope sur laquelle on applique la méthode
        double b = 0;
        double a = 0;
        //coef de la droite de la rope qu'on test
        double a1 = 0;
        double b1 = 0;
        boolean parallel = false;
        if(i1.getX() == j1.getX()){
            // la rope que l'on test est verticale et donc n'a pas d'équation
            if(Math.abs(i.getX() - j.getX())<EPSILON){
                // les deux droites sont verticales et donc parrallèles
                parallel = true;
            }
            else {
                a = (i.getY() - j.getY()) / (i.getX() - j.getX());
                b = i.getY() - (a * i.getX());
                xc = i1.getX();
                yc = a * xc + b;
            }

        }
        else {
            a1 = (i1.getY() - j1.getY()) / (i1.getX() - j1.getX());
            b1 = i1.getY() - (a1 * i1.getX());
            if(i.getX() == j.getX()){
                // la rope sur laquelle on aplique cross est verticale et donc n'a pas d'équation
                xc = i.getX();
                yc = a1*xc + b1 ;
            }
            else {
                a = (i.getY() - j.getY()) / (i.getX() - j.getX());
                b = i.getY() - (a * i.getX());
                if(a == a1){
                    // les deux droites ont le même coef directeur, elles sont donc parrallèles
                    parallel = true ;
                }
                else {
                    // Aucune des droites est verticale ni parrallèle on calcule donc xc avec a*xc+b = a1*xc+b1
                    xc = (b - b1) / (a1 - a);
                    yc = a * xc + b;
                }
            }
        }
        boolean equalsi = (i.getX() == xc && i.getY() == yc);
        boolean equalsj = (j.getX() == xc && j.getY() == yc);
        boolean equalsi1 = (i1.getX() == xc && i1.getY() == yc);
        boolean equalsj1 = (j1.getX() == xc && j1.getY() == yc);
        //On verifie si xc est egale à un point d'une des rope ou si les rope sont parrallèle
        // si oui xc est une extrèmité du polygone ou les rope sont parrallèles alors les ropes ne se croisent
        if(!equalsi  && !equalsi1 && !equalsj && !equalsj1 && !parallel) {
            if (xc <= Double.max(j.getX(), i.getX()) && xc >= Double.min(j.getX(), i.getX())) {
                if (yc <= Double.max(i.getY(), j.getY()) && yc >= Double.min(i.getY(), j.getY())) {
                    bool = true;
                }
            }
        }

        return bool;
    }

    public Rope() {
    }

    public Rope(Dot i, Dot j) {
        this.i = i;
        this.j = j;
    }

    public Boolean equals(Dot i, Dot j)
    {
        return this.equals(i.getId(),j.getId());
    }

    public Boolean equals(Integer i, Integer j)
    {
        if((this.getI().getId()==i && this.getJ().getId()==j) || (this.getI().getId()==j && this.getJ().getId()==i))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Double length()
    {
        Integer iX = i.getX();
        Integer iY = i.getY();
        Integer jX = j.getX();
        Integer jY = j.getY();
        Integer resSquare = (iX - jX)*(iX - jX) + (iY - jY)*(iY - jY);
        return Math.sqrt(resSquare);
    }

    public Dot getI() {
        return i;
    }

    public void setI(Dot i) {
        this.i = i;
    }

    public Dot getJ() {
        return j;
    }

    public void setJ(Dot j) {
        this.j = j;
    }
}
