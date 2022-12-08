public class _8_ComplexNumber {
}

    Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: ComplexNumber
        -----------------------------------------
        package classes_and_objects;

public class ComplexNumber {
    private int real;
    private int imaginary;

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public void print() {
        if (imaginary <= 0) {
            System.out.println(real + " - " + -imaginary + "i");
        } else {
            System.out.println(real + " + " + imaginary + "i");
        }
    }

    public void add(ComplexNumber c2) {
        this.real = this.real + c2.real;
        this.imaginary = this.imaginary + c2.imaginary;
    }

    public void multiply(ComplexNumber c2) {
        this.real = this.real * c2.real - this.imaginary * c2.imaginary;
        this.imaginary = this.imaginary * c2.real + this.real * c2.imaginary;
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }

    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c3) {
        int newReal = c1.real + c3.real;
        int newImaginary = c1.imaginary + c3.imaginary;
        ComplexNumber cn = new ComplexNumber(newReal, newImaginary);
        return cn;
    }
}
-----------------------------------------

        Create another class: ComplexNumberUse
        ----------------------------------------
        package classes_and_objects;

public class ComplexNumberUse {

    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(2, 3);
        c1.print();

        c1.setReal(10);
        c1.setImaginary(30);
        c1.print();

        ComplexNumber c2 = new ComplexNumber(1, 5);
        c1.add(c2);
        c1.print();
        c2.print();

        ComplexNumber c3 = new ComplexNumber(3, 2);
        c3.multiply(c2);
        c3.print();
        c2.print();

        ComplexNumber c4 = ComplexNumber.add(c1, c3);
        c1.print();
        c3.print();
        c4.print();

        ComplexNumber c5 = c1.conjugate();
        c5.print();
    }
}
----------------------------------------------
        output:
        2 + 3i
        10 + 30i
        11 + 35i
        1 + 5i
        -7 - 33i
        1 + 5i
        11 + 35i
        -7 - 33i
        4 + 2i
        11 - 35i


////////////////////////////////////////////////////////////////////


        Ques:- Complex Number Class
        ---------------------------
        A ComplexNumber class contains two data members : one is the real part (R) and the other is imaginary (I) (both integers).
        Implement the Complex numbers class that contains following functions -
        1. constructor
        You need to create the appropriate constructor.

        2. plus -
        This function adds two given complex numbers and updates the first complex number.
        e.g.
        if C1 = 4 + i5 and C2 = 3 +i1
        C1.plus(C2) results in:
        C1 = 7 + i6 and C2 = 3 + i1

        3. multiply -
        This function multiplies two given complex numbers and updates the first complex number.
        e.g.
        if C1 = 4 + i5 and C2 = 1 + i2
        C1.multiply(C2) results in:
        C1 = -6 + i13 and C2 = 1 + i2

        4. print -
        This function prints the given complex number in the following format :
        a + ib
        Note : There is space before and after '+' (plus sign) and no space between 'i' (iota symbol) and b.
        **********************************************************************************

        Solution:-


        Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: ComplexNumbers
        -----------------------------------------
        package classes_and_objects;

public class ComplexNumbers {
    private int real;
    private int imaginary;

    public ComplexNumbers(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public void print() {

        System.out.println(real + " + i" + imaginary);

    }

    public void plus(ComplexNumbers c) {
        this.real = this.real + c.real;
        this.imaginary = this.imaginary + c.imaginary;
    }

    public void multiply(ComplexNumbers c) {
        int newReal = this.real * c.real - this.imaginary * c.imaginary;
        int newImaginary = this.imaginary * c.real + this.real * c.imaginary;
        this.real = newReal;
        this.imaginary = newImaginary;
    }
}
-----------------------------------------

        Create another class: ComplexNumbersUse
        ----------------------------------------
        package classes_and_objects;

public class ComplexNumbersUse {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int real1 = s.nextInt();
        int imaginary1 = s.nextInt();

        int real2 = s.nextInt();
        int imaginary2 = s.nextInt();

        ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
        ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

        int choice = s.nextInt();

        if(choice == 1) {
            // Add
            c1.plus(c2);
            c1.print();
        }
        else if(choice == 2) {
            // Multiply
            c1.multiply(c2);
            c1.print();
        }
        else {
            return;
        }
    }
}
----------------------------------------------
        Sample Input 1 :
        4 5
        6 7
        1
        Sample Output 1 :
        10 + i12
        Sample Input 2 :
        4 5
        6 7
        2
        Sample Output 2 :
        -11 + i58