package OODesign;

import java.util.ArrayList;
import java.util.Random;


enum VehicleType {
    MOTORCYCLE, CAR, VAN
}

abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    protected int spotsNeeded;
    protected VehicleType type;

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleType getType() {
        return type;
    }

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
}

class Car extends Vehicle {
    public Car() {
        spotsNeeded = 1;
        type = VehicleType.CAR;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == type;
    }
}

class MotorCycle extends Vehicle {
    public MotorCycle() {
        spotsNeeded = 1;
        type = VehicleType.MOTORCYCLE;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == type;
    }

}

class ParkingSpot {
    private Vehicle vehicle;
    private VehicleType spotSize;
    private int spotNumber;

    public ParkingSpot(int n, VehicleType vehicleType) {
        spotNumber = n;
        spotSize = vehicleType;
    }

    public boolean isAvailable(Vehicle vehicle) {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable(vehicle) && vehicle.canFitInSpot(this);
    }

    public VehicleType getSize() {
        return spotSize;
    }

    public boolean park(Vehicle v) {
        if (!canFitVehicle(v)) {
            return false;
        }
        v.parkInSpot(this);
        return true;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

}

class ParkService {
    private ParkingSpot[] spots;
    private int availableSpots;
    private int bikeSpotsAvailable;
    private int carSpotsAvailable;
    private int vanSpotsAvailable;

    public ParkService(int numberSpots) {
        availableSpots = numberSpots;
        spots = new ParkingSpot[numberSpots];
        vanSpotsAvailable = numberSpots / 4;
        carSpotsAvailable = numberSpots / 2;
        bikeSpotsAvailable = numberSpots - vanSpotsAvailable - carSpotsAvailable;
    }

    public int getAvailableSpots() {
        return availableSpots;

    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (getAvailableSpots() < vehicle.getSpotsNeeded())
            return false;
        int spotNumber = findAvailableSpot(vehicle);
        if(spotNumber <0)
            return false;
       return false;
    }
    public int findAvailableSpot(Vehicle vehicle){

        return new Random().nextInt(10);
    }}

public class ParkingLotTest {
    /*public void parkVehicle(VehicleType vehicleType, ParkingLot parkingLot) {
        switch (vehicleType) {
            case CAR:
                int availableCarSpots = parkingLot.getCarSpots();
                parkingLot.setCarSpots(availableCarSpots--);
                System.out.println("Car is parked");
                break;
            case VAN:
                int availableVanSpots = parkingLot.getCarSpots();
                parkingLot.setVanSpots(availableVanSpots--);
                System.out.println("Van is parked");
                break;
            case MOTORCYCLE:
                int availableMotorcycleSpots = parkingLot.getCarSpots();
                parkingLot.setMotorCycleSpots(availableMotorcycleSpots--);
                System.out.println("MotorCycle is parked");
                break;
            default:
                System.out.println("Invalid Vehicle Type");
        }
    }
*/
    public static void main(String[] args) {
        /*ParkingLot parkingLot = new ParkingLot(20, 5, 10, 5);
        ParkingLotTest parkingLotTest = new ParkingLotTest();
        parkingLotTest.parkVehicle(VehicleType.MOTORCYCLE, parkingLot);
        parkingLotTest.parkVehicle(VehicleType.CAR, parkingLot);
        parkingLotTest.parkVehicle(VehicleType.VAN, parkingLot);

        System.out.println("Avialable Car Spots" + parkingLot.getCarSpots());
        System.out.println("Avialable Van Spots" + parkingLot.getVanSpots());
        System.out.println("Avialable Motor Spots" + parkingLot.getMotorCycleSpots());*/
    }
}
