package parkinglot.repositories;

import parkinglot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {

    private Map<String, Vehicle> vehicles = new HashMap<>();

    public Vehicle getVehicle(String vehicleNumber){
        if (vehicles.containsKey(vehicleNumber)) {
            return vehicles.get(vehicleNumber);
        }
        return null;
    }
}
