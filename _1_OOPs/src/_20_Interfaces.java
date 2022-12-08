public class _20_Interfaces {
}

    Create Project: Recursion

        Create Package: interfaces

        Create interface: VehicleInterface
        ----------------------------------
        package interfaces;

public class Car extends Vehicle implements CarInterface{
    @Override
    public void print() {

    }

    @Override
    public int getMaxSpeed() {
        return 0;
    }

    @Override
    public String getCompany() {
        return null;
    }
}
----------------------------------

        Create interface: CarInterface
        -------------------------------
        package interfaces;

public interface CarInterface extends VehicleInterface{
    public String getCompany();
}
--------------------------------

        Create class: Vehicle
        ----------------------
        package interfaces;

public class Vehicle {
}
----------------------

        Create class: Car
        -----------------
        package interfaces;

public class Car extends Vehicle implements CarInterface{
    @Override
    public void print() {

    }

    @Override
    public int getMaxSpeed() {
        return 0;
    }

    @Override
    public String getCompany() {
        return null;
    }
}