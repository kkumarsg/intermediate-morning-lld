package parkinglot.strategies;

import parkinglot.exceptions.ParkingLotFullException;
import parkinglot.models.ParkingFloor;
import parkinglot.models.ParkingLot;
import parkinglot.models.ParkingSlot;
import parkinglot.models.enums.ParkingStatus;
import parkinglot.models.enums.VehicleType;
import parkinglot.repositories.ParkingLotRepository;

public class EmptySpotAllocationStrategy implements AllocationStrategy{

    private ParkingLotRepository parkingLotRepository;

    @Override
    public ParkingSlot getParkingSlot(VehicleType vehicleType, Long parkingLotId) throws ParkingLotFullException {

        // Get the parking lot from the id
        // go through each of the floor
            // for every floor
            // if you find an empty spot for that vehicle type, return it

        ParkingLot parkingLot = parkingLotRepository.getParkingLotFromId(parkingLotId);

        for(ParkingFloor floor: parkingLot.getFloors() ){
            for(ParkingSlot parkingSlot: floor.getParkingSlots()){
                if(parkingSlot.getVehicleType().equals(vehicleType)){
                    if(parkingSlot.getParkingStatus().equals(ParkingStatus.EMPTY)){
                        return parkingSlot;
                    }
                }
            }
        }
        throw new ParkingLotFullException();
    }
}
