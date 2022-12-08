public class _17_ExceptionHandling {
}

    Exceptions are a way of a function to tell you that you are doing something wrong.
        ----------------------------------------------------------------------------------
        Exceptions are of three types:-
        1. Runtime Exceptions: Don't need to handle this code.
        e.g ArrayIndexOutOfBoundsException
        2. Errors: Don't occur generally, otherwise big problem.
        3. Named Exception:
        ---------------------------------------------------------------------

        **************************************************
        If we set Denominator as zero, then use "try and catch function" in FrctionUse class. Otherwise it throw ZeroDenominatorException
        -------------------------------------------
        Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Fraction
        -----------------------------------------
        package classes_and_objects;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            // to do error out
        }
        this.denominator = denominator;
        simplify();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int n) {
        this.numerator = n;
        simplify();
    }

    public void setDenominator(int d) throws ZeroDenominatorException {
        if (d == 0) {
            ZeroDenominatorException e = new ZeroDenominatorException("Denominator can't be 0");
            throw e;
        }
        this.denominator = d;
        simplify();
    }

    public void print() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }

    private void simplify() {
        int gcd = 1;
        int smaller = Math.min(numerator, denominator);
        for (int i = 2; i <= smaller; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }
        numerator = numerator/gcd;
        denominator = denominator/gcd;
    }

    public static Fraction add(Fraction f1, Fraction f2) {
        int newNum = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        int newDen = f1.denominator * f2.denominator;
        Fraction f = new Fraction(newNum, newDen);
        return f;
    }

    public void add(Fraction f2) {
        this.numerator = this.numerator * f2.denominator + this.denominator * f2.numerator;
        this.denominator = this.denominator * f2.denominator;
        simplify();
    }

    public void multiply(Fraction f2) {
        this.numerator = this.numerator * f2.numerator;
        this.denominator = this.denominator * f2.denominator;
        simplify();
    }
}
-----------------------------------------

        Create another class: ZeroDenominatorException
        ----------------------------------------------
        package classes_and_objects;

public class ZeroDenominatorException extends Exception{
    public ZeroDenominatorException(String s) {
    }
}
--------------------------------------------

        Create another class: FractionUse
        ----------------------------------------
        package classes_and_objects;

public class FractionUse {
    public static void main(String[] args) throws ZeroDenominatorException { // to handle Exception
        Fraction f1 = new Fraction(20,30);
        f1.print();
        // 2/3

        f1.setNumerator(12);
        // 4/1

        int d = f1.getDenominator();
        System.out.println(d);
        f1.print();
//
        f1.setNumerator(10);

        try {
            f1.setDenominator(0);
        } catch(ZeroDenominatorException e) {
            System.out.println("Hey don't input 0 as denominator");
        }

        // 1/3

        f1.print();
//
        Fraction f2 = new Fraction(3,4);
        f1.add(f2);
        f1.print();
        // f1 => 13/12

        f2.print();
        // f2 => 3/4
//
        Fraction f3 = new Fraction(4,5);
        f3.multiply(f2);
        f3.print();
        // f3 => 3/5

        f2.print();
        // f2 => 3/4
        //
        Fraction f4 = Fraction.add(f1, f3);
        f1.print();
        f3.print();
    }

}
----------------------------------------
        output:
        2/3
        1
        4
        Hey don't input 0 as denominator
        10
        43/4
        3/4
        3/5
        3/4
        43/4
        3/5