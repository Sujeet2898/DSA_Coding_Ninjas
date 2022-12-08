public class _13_FunctionOverloading {
}

    Create Project: Object Oriented Programming

        Create Pakage: vehicle

        Create class: Vehicle
        -----------------------------------------
        package vehicle;

public class Vehicle {
    String color;
    private int maxSpeed;

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
        Vehicle v = new Vehicle();
        v.color = "Black";
        v.setMaxSpeed(10);
        v.print();

        Car c = new Car();
        c.numGears = 10;
        c.color = "Black";
        c.setMaxSpeed(100);
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

    public void print() {      // print function is override as it is used in                                      // Vehicle class as well.
        System.out.println("Car Color : " + color);
        System.out.println("Car Speed : " + maxSpeed);
        System.out.println("Car numGears : " + numGears);
        System.out.println("Car isConvertible : " + isConvertible);
    }
}
----------------------
        output:
        Vehicle Color : Black
        Vehicle Speed : 10
        Car Color : Black
        Car Speed : 100
        Car numGears : 10
        Car isConvertible : false