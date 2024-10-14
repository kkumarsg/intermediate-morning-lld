package parkinglot.dtos;

import parkinglot.models.Ticket;

public class IssueTicketResponse {

    private Ticket ticket;
    private int statusCode;
    private String message;


    public IssueTicketResponse(Ticket ticket, int statusCode, String message) {
        this.ticket = ticket;
        this.statusCode = statusCode;
        this.message = message;
    }
}
