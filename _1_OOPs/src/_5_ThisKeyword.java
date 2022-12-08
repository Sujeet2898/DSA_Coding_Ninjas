public class _5_ThisKeyword {
}

//  Access data member which has same name as a local variable

    Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Student
        -----------------------------------------
        package classes_and_objects;

public class Student {
    public String name;

    // Final data members can be initialized as soon as they are declared.
    private final int rollNumber;

    // Parametrized Constructor
    public Student(String name, int rollNumber) {

        // For printing reference of student
        System.out.println(this);

        this.name = name;
        this.rollNumber = rollNumber;

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

        // For printing reference of this student s1
        System.out.println(s1);

        s1.print();

        Student s2 = new Student("IIT Hyderabad", 8);

        // For printing reference of this student s1
        System.out.println(s2);

        s2.print();
    }
}

output:
        classes_and_objects.Student@65ab7765      // class student reference for s1
        classes_and_objects.Student@65ab7765      // class studentUse refernce for s2
        Sujeet Kumar : 11004
        classes_and_objects.Student@4dd8dc3       // class student reference for s1
        classes_and_objects.Student@4dd8dc3       // class studentUse refernce for s2
        IIT Hyderabad : 8