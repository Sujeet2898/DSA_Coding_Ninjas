public class _1_ClassesAndObjects {
}

    Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Student
        -----------------------------------------
        package classes_and_objects;

public class Student {
    String name;
    int rollNumber;
}
-----------------------------------------

        Create another class: StudentUse
        ----------------------------------------
        package classes_and_objects;

public class StudentUse {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.name = "Sujeet Kumar";
        s1.rollNumber = 11004;

        Student s2 = new Student();
        s2.name = "IIT Hyderabad";
        s2.rollNumber = 8;

        System.out.println(s1);
        System.out.println(s1.name);
        System.out.println(s1.rollNumber);

        System.out.println(s2.name);
        System.out.println(s2.rollNumber);
    }
}
output:
        classes_and_objects.Student@3feba861
        Sujeet Kumar
        11004
        IIT Hyderabad
        8
        ----------------------------------------

        Create another package: temp
        create class: StudentUse2
        ----------------------------------------

        package temp;

        import classes_and_objects.Student;

public class StudentUse2 {
    public static void main(String[] args) {
        Student s2 = new Student();
        s2.name = "IIT Hyderabad";
        s2.rollNumber = 8;

        System.out.println(s2.name);
        System.out.println(s2.rollNumber);
    }
}
// StudentUse2 is in different package. To use the Student class, we have make its properties public.

//     package classes_and_objects;

//     public class Student {
//     public String name;
//     public int rollNumber;
//   }

output:
        IIT Hyderabad
        8
        ------------------------------------------

        Key Points:-
        1. Default means Within the Package
        2. Public means Anywhere
        3. Private means Only within the same class
