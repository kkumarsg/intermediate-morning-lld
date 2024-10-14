package parkinglot.strategies;

import parkinglot.exceptions.ParkingLotFullException;
import parkinglot.models.ParkingSlot;
import parkinglot.models.enums.VehicleType;

public interface AllocationStrategy {

    ParkingSlot getParkingSlot(VehicleType vehicleType, Long parkingLotId) throws ParkingLotFullException;
}
