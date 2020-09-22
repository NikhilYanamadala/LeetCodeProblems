package DesignPatterns;

class Licence {
    public static boolean publicParking() {
        return false;
    }

    public static boolean privateParking() {
        return false;
    }
}

class ParkingStructure {
}

class PublicParkingStructure extends ParkingStructure {
}

class PrivateParkingStructure extends ParkingStructure {
}
// Creational Design Pattern
public class SingleTonDesignPattern {
    private static SingleTonDesignPattern s = null;

    private SingleTonDesignPattern() {

    }

    public static SingleTonDesignPattern getInstance() {
        if (s == null)
            return new SingleTonDesignPattern();
        return s;
    }

    public static ParkingStructure getParkingStructure(Licence licence) throws Exception{
        if (licence.publicParking()) {
            return new PublicParkingStructure();
        }
        else if (licence.privateParking()) {
            return new PrivateParkingStructure();
        }
        else
            throw new Exception("Invalid Structure");
    }
}
