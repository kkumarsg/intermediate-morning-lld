package parkinglot.models;

import parkinglot.models.enums.PaymentStatus;

import java.util.Date;
import java.util.List;

public class Billing {

    private Date exitTime;
    private Ticket ticket;

    // Generally when you're storing amount, better to store it as 'int'
    // Because floats will have some precision.

    /*
    Google about why amount should be stored as int and not float/double
     */
    private Float billingAmount;
    private PaymentStatus billingStatus;
    private List<Payment> payments;
    private Gate exitGate;
    private String operator;



}
