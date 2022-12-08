public class _12_InheritanceAndPrivateMembers {
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
        c.print();
        c.setMaxSpeed(100);
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
        Vehicle Color : Black
        Vehicle Speed : 10
        Vehicle Color : Black
        Vehicle Speed : 0
        Car Color : Black
        Car Speed : 100
        Car numGears : 10
        Car isConvertible : false