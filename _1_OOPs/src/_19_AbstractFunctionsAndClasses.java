public class _19_AbstractFunctionsAndClasses {
}

Abstract class: class can decide whichever function it wants, but it doesn't know how to create, but it wants from anyone of its subclasses to make this function.
        -------------------------------------
        Key Points:
        1. Super class i.e Vehicle class has abstract function means this Vehicle class should be made abstract.
        2. Two Option for inheriting subclass i.e car class: First is- Subclass should make itself abstract And second is- To implement that abstract function of superclass in subclass to fulfill its completeness.
        ------------------------------------

        Create Project: Object Oriented Programming

        Create Pakage: vehicle

        Create class: Vehicle
        -----------------------------------------
        package vehicle;

public abstract class Vehicle { // this class is abstract because it has abstract function
    protected String color;
    private int maxSpeed;

    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        System.out.println("Vehicle Constructor");
    }

    public abstract boolean isMotorized();  // abstract i.e incomplete because vehicle can't say it is motorized or not

    public abstract String getCompany();

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
// We can't create object of abstract class

        package vehicle;

public class VehicleUse {
    public static void main(String[] args) {

        Vehicle v = new Car(10, 20) {
            @Override
            public String getCompany() {
                return null;
            }
        };

        v.print();
    }
}
------------------------------------------

        Create another class: Car
        ----------------------------------------
        package vehicle;

public abstract class Car extends Vehicle {
    int numGears;
    boolean isConvertible;

    public Car(){
        super(100);
    }

    public Car(int numGears, int maxSpeed) {
        super(maxSpeed);
        this.numGears = numGears;
        System.out.println("Car Constructor");
    }

    @Override
    public boolean isMotorized() {
        return false;
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
-----------------------------------------

        Create another class: BMW
        ----------------------------------------
        package vehicle;

public class BMW extends Car {
    @Override
    public String getCompany() {
        return null;
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
