public class _2_AccessModifiersGetterSetters {
}

    Key Points:-
        1. Default means Within the Package
        2. Public means Anywhere
        3. Private means Only within the same class
-----------------------------------------------

        Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Student
        -----------------------------------------
        package classes_and_objects;

public class Student {
    public String name;
    private int rollNumber;

    public void setRollNumber(int rn) {
        rollNumber = rn;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}
-----------------------------------------

        Create another class: StudentUse
        ----------------------------------------
        package classes_and_objects;

public class StudentUse {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Sujeet Kumar";
        s1.setRollNumber(-11004);

        Student s2 = new Student();
        s2.name = "IIT Hyderabad";
        s2.setRollNumber(-8);

        System.out.println(s1.name);
        System.out.println(s1.getRollNumber());

        System.out.println(s2.name);
        System.out.println(s2.getRollNumber());
    }
}

output:
        Sujeet Kumar
        -11004
        IIT Hyderabad
        -8


        **************************************************

        Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Student
        -----------------------------------------
        package classes_and_objects;

public class Student {
    public String name;
    private int rollNumber;

    public void setRollNumber(int rn) {
        if (rn <= 0) {          // Benefit of setter
            return;            // Not allow negative rn
        }
        rollNumber = rn;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}
-----------------------------------------

        Create another class: StudentUse
        ----------------------------------------
        package classes_and_objects;

public class StudentUse {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Sujeet Kumar";
        s1.setRollNumber(11004);

        Student s2 = new Student();
        s2.name = "IIT Hyderabad";
        s2.setRollNumber(8);

        System.out.println(s1.name);
        System.out.println(s1.getRollNumber());

        System.out.println(s2.name);
        System.out.println(s2.getRollNumber());
    }
}

output:
        Sujeet Kumar
        11004
        IIT Hyderabad
        8

        ****************************************************

        Create Project: Object Oriented Programming

        Create Pakage: classes_and_objects

        Create class: Student
        -----------------------------------------
        package classes_and_objects;

public class Student {
    public String name;
    private int rollNumber;

    public void setRollNumber(int rn) {
        if (rn <= 0) {          // Benefit of setter
            return;            // Not allow negative rn
        }
        rollNumber = rn;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}
-----------------------------------------

        Create another class: StudentUse
        ----------------------------------------
        package classes_and_objects;

public class StudentUse {

    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1.name);
        System.out.println(s1.getRollNumber());

        s1.name = "Sujeet Kumar";
        s1.setRollNumber(-11004);

        Student s2 = new Student();
        s2.name = "IIT Hyderabad";
        s2.setRollNumber(-8);

        System.out.println(s1.name);
        System.out.println(s1.getRollNumber());

        System.out.println(s2.name);
        System.out.println(s2.getRollNumber());
    }
}

output:
        null
        0
        Sujeet Kumar
        0
        IIT Hyderabad
        0