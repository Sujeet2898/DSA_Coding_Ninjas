public class _16_Polymorphism {
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

        Vehicle v = new Car(10,20);   // Polymorphism

        v.print();
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
        super(maxSpeed);
        this.numGears = numGears;
        System.out.println("Car Constructor");
    }

    public boolean isConvertible() {
        return isConvertible;
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
        Vehicle Color : null
        Vehicle Speed : 20
        Car numGears : 10
        Car isConvertible : false