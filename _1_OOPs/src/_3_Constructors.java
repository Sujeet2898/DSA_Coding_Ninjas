public class _3_Constructors {
}

    Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Student
        -----------------------------------------
        package classes_and_objects;

public class Student {
    public String name;
    private int rollNumber;

    // Parametrized Constructor
    public Student(String n, int rn) {
        name = n;
        rollNumber = rn;
    }

    public void setRollNumber(int rn) {
        if (rn <= 0) {          // Benefit of setter
            return;            // Not allow negative rn
        }
        rollNumber = rn;
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
    }
}

output:
        Sujeet Kumar : 11004
        IIT Hyderabad : 8

        *******************************************************

        Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Student
        -----------------------------------------
        package classes_and_objects;

public class Student {
    public String name;
    private int rollNumber;

    // Parametrized Constructor
    public Student(String n) {
        name = n;
    }

    public Student(String n, int rn) {
        name = n;
        rollNumber = rn;
    }

    public void setRollNumber(int rn) {
        if (rn <= 0) {          // Benefit of setter
            return;            // Not allow negative rn
        }
        rollNumber = rn;
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

        Student s2 = new Student("IIT Hyderabad");
        s2.print();
    }
}

output:
        Sujeet Kumar : 11004
        IIT Hyderabad : 0