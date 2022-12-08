public class _6_StaticKeywordStaticFunction {
}

// Static functions are those which do not depend upon OBJECTS, says s1, s2, etc.


    Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Student
        -----------------------------------------
        package classes_and_objects;

public class Student {
    public String name;

    // Final data members can be initialized as soon as they are declared.
    private final int rollNumber;

    static int numStudents;

    // Parametrized Constructor
    public Student(String name, int rollNumber) {

        this.name = name;
        this.rollNumber = rollNumber;
        numStudents++;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void print() {
        System.out.println(name + " : " + rollNumber);
    }
}
-----------------------------------------

        Create another class: StudentUse
        ----------------------------------------
        package classes_and_objects;

public class StudentUse {

    public static void main(String[] args) {
        Student s1 = new Student("Sujeet Kumar", 11004);
        s1.print();

        Student s2 = new Student("IIT Hyderabad", 8);
        s2.print();

        System.out.println(Student.numStudents);
        Student.numStudents = 10;
        System.out.println(s1.name);
    }
}

output:
        Sujeet Kumar : 11004
        IIT Hyderabad : 8
        2
        Sujeet Kumar

        *********************************************************

        Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Student
        -----------------------------------------
        package classes_and_objects;

public class Student {
    public String name;

    // Final data members can be initialized as soon as they are declared.
    private final int rollNumber;

    private static int numStudents;
    public static int getNumStudents() {
        return numStudents;
    }

    // Parametrized Constructor
    public Student(String name, int rollNumber) {

        this.name = name;
        this.rollNumber = rollNumber;
        numStudents++;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void print() {
        System.out.println(name + " : " + rollNumber);
    }
}
-----------------------------------------

        Create another class: StudentUse
        ----------------------------------------
        package classes_and_objects;

public class StudentUse {

    public static void main(String[] args) {
        Student s1 = new Student("Sujeet Kumar", 11004);
        s1.print();

        Student s2 = new Student("IIT Hyderabad", 8);
        s2.print();

        System.out.println(Student.getNumStudents());
        System.out.println(s1.name);
    }
}

output:
        Sujeet Kumar : 11004
        IIT Hyderabad : 8
        2
        Sujeet Kumar