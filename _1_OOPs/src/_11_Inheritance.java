public class _11_Inheritance {
}

    Component of OOPS
        -----------------------
        1.  Encapsulation
        -------------------
        Encapsulation is putting all the datas, all the functions altogether at one place.
        And Abstraction means as long as the inputs and outputs are same, we don't exactly care about what exactly going inside it like how function is working or not, it is just abstracted out for us.
        :- Two benefits firstly Everything at one place and secondly Abstraction.

        ----------------------
        2.  Inheritance
        -------------------
        Inheritance means A class can say who is my parent and everything of my parent like properties, functions are inherited to me.
        ----------------------
        3.  Polymorphism
        -------------------

    Create Project: Object Oriented Programming

        Create Pakage: vehicle

        Create class: Vehicle
        -----------------------------------------
        package vehicle;

public class Vehicle {
    String color;
    int maxSpeed;

    public void print() {
        System.out.println("Vehicle Color : " + color);
        System.out.println("Vehicle Speed : " + maxSpeed);
    }
}
-----------------------------------------

        Create another class: VehicleUse
        ----------------------------------------
        package vehicle;

public class VehicleUse {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.print();

        Car c = new Car();
        c.numGears = 10;
        c.color = "Black";
        c.print();
    }
}
------------------------------------------

        Create another class: Car
        ----------------------------------------
        package vehicle;

public class Car extends Vehicle {
    int numGears;
    boolean isConvertible;
}

output:
        Vehicle Color : null
        Vehicle Speed : 0
        Vehicle Color : Black
        Vehicle Speed : 0

        *****************************************************

        Create Project: Object Oriented Programming

        Create Pakage: vehicle

        Create class: Vehicle
        -----------------------------------------
        package vehicle;

public class Vehicle {
    String color;
    int maxSpeed;

    public void print() {
        System.out.println("Vehicle Color : " + color);
        System.out.println("Vehicle Speed : " + maxSpeed);
    }
}
-----------------------------------------

        Create another class: VehicleUse
        ----------------------------------------
        package vehicle;

public class VehicleUse {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.print();

        Car c = new Car();
        c.numGears = 10;
        c.color = "Black";
        c.print();

        c.printCar();
    }
}
------------------------------------------

        Create another class: Car
        ----------------------------------------
        package vehicle;

public class Car extends Vehicle {
    int numGears;
    boolean isConvertible;

    public void printCar() {
        System.out.println("Car Color : " + color);
        System.out.println("Car Speed : " + maxSpeed);
        System.out.println("Car numGears : " + numGears);
        System.out.println("Car isConvertible : " + isConvertible);
    }
}
----------------------
        output:
        Vehicle Color : null
        Vehicle Speed : 0
        Vehicle Color : Black
        Vehicle Speed : 0
        Car Color : Black
        Car Speed : 0
        Car numGears : 10
        Car isConvertible : false