public class _10_PolynomialClass {
}

    Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Polynomial
        -----------------------------------------
        package classes_and_objects;

public class Polynomial {

    DynamicArray coefficients;
    private int poly[];
    private int maxDegree;

    public Polynomial() {
        poly = new int[10];
        maxDegree = 0;
    }

    public void setCoefficients(int deg, int coeff) {
        while (deg > poly.length-1)
        {
            doubleCapacity();
        }
        if (maxDegree<deg)
        {
            maxDegree=deg;
        }
        poly[deg]=coeff;
    }
    private void doubleCapacity()
    {
        int[] temp = poly;
        poly = new int[2 * temp.length];
        for (int i = 0; i < temp.length; i++)
        {
            poly[i] = temp[i];
        }
    }

    public int getCoefficient(int deg) {
        return poly[deg];
    }

    public int degree() {

    }

    public void print() {
        for (int i=0;i<=maxDegree;i++)
        {
            if (poly[i] != 0)
            {
                System.out.print(poly[i]+"x"+i+" ");
            }
        }
    }

    public void add(Polynomial p) {
        int degree1=this.maxDegree;
        int degree2=p.maxDegree;
        int limit;
        if (degree1>degree2)
        {
            limit=degree1;
        }
        else
        {
            limit=degree2;
        }

        Polynomial polysum = new Polynomial(limit+1);

        for (int i=0;i<=limit;i++)
        {
            int sum=0;
            if (i<=degree1)
            {
                sum=sum+(this.poly[i]);
            }
            if (i<=degree2)
            {
                sum=sum+(p.poly[i]);
            }
            polysum.setCoefficients(i,sum);
        }
    }

    public void subtract(Polynomial p) {

    }

    public void multiply(Polynomial p) {

    }

    public int evaluate(int x) {

    }

    public static Polynomial add(Polynomial p1, Polynomial p2) {

    }
}

-----------------------------------------

        Create another class: PolynomialUse
        ----------------------------------------
        package classes_and_objects;

public class PolynomialUse {

    public static void main(String [] args) {
        Polynomial p1 = new Polynomial();
        p1.setCoefficients(0, 3);
        p1.setCoefficients(2, 2);
        p1.print();

        Polynomial p2 = new Polynomial();
        p2.setCoefficients(0, 3);
        p2.setCoefficients(2, 2);
        p2.setCoefficients(1, 4);
        p2.setCoefficients(2, 5);
        p2.print();

        p1.add(p2);
        p1.print();
        p2.print();

        p2.multiply(p1);
        p2.print();
        p1.print();

        Polynomial p3 = Polynomial.add(p1, p2);
        p3.print();
        p1.print();
        p2.print();

        int ans = p2.evaluate(10);
        System.out.println(ans);
    }
}

----------------------------------------------
        output: