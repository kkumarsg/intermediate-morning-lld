package parkinglot.services;

import parkinglot.dtos.IssueTicketRequest;
import parkinglot.exceptions.GateNotFoundException;
import parkinglot.exceptions.ParkingLotFullException;
import parkinglot.models.*;
import parkinglot.models.enums.VehicleType;
import parkinglot.repositories.GateRepository;
import parkinglot.repositories.ParkingLotRepository;
import parkinglot.repositories.VehicleRepository;
import parkinglot.strategies.AllocationStrategy;

import java.util.Date;
import java.util.UUID;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;

    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public Ticket issueTicket(IssueTicketRequest ticketRequest) throws GateNotFoundException, ParkingLotFullException {

        Ticket ticket = createTicketEmpty();

        saveGate(ticketRequest, ticket);

        Vehicle vehicle = validateAndSaveVehicle(ticketRequest, ticket);

        allocateParkingSlot(ticketRequest, ticket, vehicle);

        ticketNumberAndSave(ticketRequest, ticket);

        return ticket;
    }

    private void ticketNumberAndSave(IssueTicketRequest ticketRequest, Ticket ticket) {
        ticket.setNumber(ticketRequest.getOwner()+ UUID.randomUUID());
        ticketRepository.save(ticket);
    }

    private void allocateParkingSlot(IssueTicketRequest ticketRequest, Ticket ticket, Vehicle vehicle) throws ParkingLotFullException {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotFromId(ticketRequest.getParkingLot());

        AllocationStrategy parkingSpaceAllocationStrategy = parkingLot.getAllocationStrategy();

        ParkingSlot parkingSlot =
                parkingSpaceAllocationStrategy.getParkingSlot(vehicle.getVehicleType(), ticketRequest.getParkingLot());

        ticket.setParkingSlot(parkingSlot);
    }

    private Vehicle validateAndSaveVehicle(IssueTicketRequest ticketRequest, Ticket ticket) {
        Vehicle vehicle = vehicleRepository.getVehicle(ticketRequest.getVehicleNumber());
        if(vehicle==null){
            vehicle = new Vehicle(ticketRequest.getVehicleNumber(),
                    getVehicleTypeEnumFromVehicleType(ticketRequest.getVehicleType()),
                    ticketRequest.getOwner());
        }

        ticket.setVehicle(vehicle);
        return vehicle;
    }

    private void saveGate(IssueTicketRequest ticketRequest, Ticket ticket) throws GateNotFoundException {
        Gate gate = gateRepository.finGateByGateId(ticketRequest.getGateId());
        ticket.setEntryGate(gate);
    }

    private static Ticket createTicketEmpty() {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        return ticket;
    }

    private VehicleType getVehicleTypeEnumFromVehicleType(String vehicleType) {
        // you need to implement this
        return VehicleType.CAR;
    }
}
