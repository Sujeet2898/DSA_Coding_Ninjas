public class _18_FinalKeyword {
}

1. "Final" Function: Subclass can't override this function
        2. "Final" Class: No inheritance from this class

-----------------------------------------------------------


        Create Project: Object Oriented Programming

        Create Pakage: vehicle

        Create class: Vehicle
        -----------------------------------------
        package vehicle;

public final class Vehicle {               // final class
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

    public final void print() {     // final function
        System.out.println("Vehicle Color : " + color);
        System.out.println("Vehicle Speed : " + maxSpeed);
    }
}
------------------------------------------

        Create another class: Car
        ----------------------------------------
        package vehicle;

public class Car extends Vehicle {       // Car cannot extends Vehicle  i.e no inheritance
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

    public void print() {      // this subclass function can't be print fn
        super.print();
        System.out.println("Car numGears : " + numGears);
        System.out.println("Car isConvertible : " + isConvertible);
    }
}
