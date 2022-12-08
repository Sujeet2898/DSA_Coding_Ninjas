public class _4_FinalKeyword {
}

1st Way of using Final keyword:-
        ----------------------------------------



        Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Student
        -----------------------------------------
        package classes_and_objects;

public class Student {
    public String name;

    private final int rollNumber;

    // Parametrized Constructor
    public Student(String n, int rn) {
        name = n;
        rollNumber = rn;
    }

//  We can't set the roll number in 'final' keyword.

//    public void setRollNumber(int rn) {
//        if (rn <= 0) {          // Benefit of setter
//            return;            // Not allow negative rn
//        }
//        rollNumber = rn;
//    }

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

        ******************************************************************

        2nd Way of using Final keyword:-
        ----------------------------------------


        Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Student
        -----------------------------------------
        package classes_and_objects;

public class Student {
    public String name;

    // Final data members can be initialized as soon as they are declared.
    private final int rollNumber = 101010;

    // Parametrized Constructor
    public Student(String n, int rn) {
        name = n;
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
        Sujeet Kumar : 101010
        IIT Hyderabad : 101010