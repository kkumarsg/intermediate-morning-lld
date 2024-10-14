package parkinglot.controllers;

import parkinglot.dtos.IssueTicketRequest;
import parkinglot.dtos.IssueTicketResponse;
import parkinglot.exceptions.GateNotFoundException;
import parkinglot.exceptions.ParkingLotFullException;
import parkinglot.models.Ticket;
import parkinglot.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public IssueTicketResponse issueTicket(IssueTicketRequest ticketRequest) throws GateNotFoundException, ParkingLotFullException {

        Ticket ticket = ticketService.issueTicket(ticketRequest);
        return new IssueTicketResponse(ticket, 200, "Ticket Issued");

    }
}
