package model;

public class Rope {
    public static Integer nbInstance = 0;
    private Integer id;
    private Dot i;
    private Dot j;

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
        boolean parrallele = false;
        if(i1.getX() == j1.getX()){
            // la rope que l'on test est verticale et donc n'a pas d'équation
            if(i.getX() == j.getX()){
                // les deux droites sont verticales et donc parrallèles
                parrallele = true;
            }
            a = (i.getY() - j.getY()) / (i.getX() - j.getX());
            b = i.getY() - (a * i.getX());
            xc = i1.getX();
            yc = a*xc + b ;

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
                    parrallele = true ;
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
        if(!equalsi  && !equalsi1 && !equalsj && !equalsj1 && !parrallele) {
            if (xc <= Double.max(j.getX(), i.getX()) && xc >= Double.min(j.getX(), i.getX())) {
                if (yc <= Double.max(i.getY(), j.getY()) && yc >= Double.min(i.getY(), j.getY())) {
                    bool = true;
                }
            }
        }

        return bool;
    }

    public Rope() {
        this.id=nbInstance;
        nbInstance++;
    }

    public Rope(Dot i, Dot j) {
        this.id=nbInstance;
        nbInstance++;
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

    public Double lenght()
    {
        Integer iX = i.getX();
        Integer iY = i.getY();
        Integer jX = j.getX();
        Integer jY = j.getY();
        Integer resSquare = ((iX - iY) ^ 2) + ((jX - jY) ^ 2);
        System.out.println();
        return Double.valueOf(0);
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

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}