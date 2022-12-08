public class _15_InheritanceAndConstructors {
}

    Create Project: Object Oriented Programming

        Create Pakage: vehicle

        Create class: Vehicle
        -----------------------------------------
        package vehicle;

public class Vehicle {
    protected String color;
    private int maxSpeed;

    public Vehicle() {
        System.out.println("Vehicle Constructor");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

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
        Car c = new Car();  // Parent class object is created as well
        // due to default constructor
        // here, Vehicle is parent class
        c.numGears = 10;
        c.color = "Blue";
        c.setMaxSpeed(100);
    }
}
------------------------------------------

        Create another class: Car
        ----------------------------------------
        package vehicle;

public class Car extends Vehicle {
    int numGears;
    boolean isConvertible;

    public Car() {
        System.out.println("Car Constructor");
    }

    public void print() {
        super.print();
        System.out.println("Car numGears : " + numGears);
        System.out.println("Car isConvertible : " + isConvertible);
    }
}
-------------------------------------------
        output:
        Vehicle Constructor   // Parent class object is created as well
        Car Constructor

        ********************************************************

        Create Project: Object Oriented Programming

        Create Pakage: vehicle

        Create class: Vehicle
        -----------------------------------------
        package vehicle;

public class Vehicle {
    protected String color;
    private int maxSpeed;

    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        System.out.println("Vehicle Constructor");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

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
        Car c = new Car(10);  // Parent class object is not created
        // as default constructor is replaced with parametrised constructor

        c.color = "Blue";
        c.setMaxSpeed(100);
    }
}
------------------------------------------

        Create another class: Car
        ----------------------------------------
        package vehicle;

public class Car extends Vehicle {
    int numGears;
    boolean isConvertible;

    public Car(int numGears) {
        this.numGears = numGears;
        System.out.println("Car Constructor");
    }

    public void print() {
        super.print();
        System.out.println("Car numGears : " + numGears);
        System.out.println("Car isConvertible : " + isConvertible);
    }
}
-------------------------------------------
        output:
        error as default constructor does not exit.

        ********************************************************

        Key Point:-
        1. When we called derived class constructor, super class constructor is also called. Firstly super is called, then derived is called.
        2. When we have default constructor, then it is fine. Otherwise we have to call default constructor using Super Keyword.

        ----------------------------------------
        Create Project: Object Oriented Programming

        Create Pakage: vehicle

        Create class: Vehicle
        -----------------------------------------
        package vehicle;

public class Vehicle {
    protected String color;
    private int maxSpeed;

    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        System.out.println("Vehicle Constructor");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

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
        Car c = new Car(10,100);  // Parent class object is created as well
        // here, Vehicle is parent class

        c.color = "Blue";

    }
}

------------------------------------------

        Create another class: Car
        ----------------------------------------
        package vehicle;

public class Car extends Vehicle {
    int numGears;
    boolean isConvertible;

    public Car(int numGears, int maxSpeed) {
        super(maxSpeed);  // To call vehicle constructor
        this.numGears = numGears;
        System.out.println("Car Constructor");
    }

    public void print() {
        super.print();
        System.out.println("Car numGears : " + numGears);
        System.out.println("Car isConvertible : " + isConvertible);
    }
}
-------------------------------------------
        output:
        Vehicle Constructor
        Car Constructor