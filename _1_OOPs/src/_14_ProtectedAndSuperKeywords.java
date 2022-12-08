public class _14_ProtectedAndSuperKeywords {
}

Protected:  Accessable Within the Package as well as SubClass of other Package.
        -----------------------------------

        Create Project: Object Oriented Programming

        Create Pakage: vehicle

        Create class: Vehicle
        -----------------------------------------
        package vehicle;

public class Vehicle {
    protected String color;
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
        import vehicle_temp.Truck;

public class VehicleUse {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.color = "Black";
        v.setMaxSpeed(10);
        v.print();

        Car c = new Car();
        c.numGears = 10;
        c.color = "Blue";
        c.setMaxSpeed(100);
        c.print();

        Truck t = new Truck();
        t.color = "Grey";
        t.setMaxSpeed(90);
        t.print();
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
-------------------------------------
        Create another Package: vehicle_temp
        --------------------------------------
        Create another class: Truck
        ----------------------------------------
        Package vehicle_temp;

        import vehicle.Vehicle;

public class Truck extends Vehicle {
    int maxLoadingCapacity;
    public void print() {
        System.out.println("Truck capacity: " + maxLoadingCapacity);
        System.out.println("Truck color: " + color);    // Accessible due to Protected String color
        System.out.println("Truck speed: " + getMaxSpeed());
    }
}
----------------------
        output:
        Vehicle Color : Black
        Vehicle Speed : 10
        Car Color : Blue
        Car Speed : 100
        Car numGears : 10
        Car isConvertible : false
        Truck capacity: 0
        Truck color: Grey
        Truck speed: 90

        **************************************************

        Super Keyword:
        ----------------
        This approach makes us write less code as both the classes inherited several
        properties and functions from the superclass, thus we didn’t have to re-write them.
        ----------------------

        Create Project: Object Oriented Programming

        Create Pakage: vehicle

        Create class: Vehicle
        -----------------------------------------
        package vehicle;

public class Vehicle {
    protected String color;
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
        import vehicle_temp.Truck;

public class VehicleUse {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.color = "Black";
        v.setMaxSpeed(10);
        v.print();

        Car c = new Car();
        c.numGears = 10;
        c.color = "Blue";
        c.setMaxSpeed(100);
        c.print();

        Truck t = new Truck();
        t.color = "Grey";
        t.setMaxSpeed(90);
        t.print();
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
        super.print();     // super is parent object
        // internally it print Vehicle class
        // Additionally it print else
        System.out.println("Car numGears : " + numGears);
        System.out.println("Car isConvertible : " + isConvertible);
    }
}
-------------------------------------
        Create another Package: vehicle_temp
        --------------------------------------
        Create another class: Truck
        ----------------------------------------
        Package vehicle_temp;

        import vehicle.Vehicle;

public class Truck extends Vehicle {
    int maxLoadingCapacity;
    public void print() {
        System.out.println("Truck capacity: " + maxLoadingCapacity);
        System.out.println("Truck color: " + color);    // Accessible due to Protected String color
        System.out.println("Truck speed: " + getMaxSpeed());
    }
}
----------------------
        output:
        Vehicle Color : Black
        Vehicle Speed : 10
        Vehicle Color : Blue        // due to super keyword
        Vehicle Speed : 100         // due to super keyword
        Car numGears : 10
        Car isConvertible : false
        Truck capacity: 0
        Truck color: Grey
        Truck speed: 90