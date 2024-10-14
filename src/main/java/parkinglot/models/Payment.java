package parkinglot.models;

import parkinglot.models.enums.PaymentStaus;
import parkinglot.models.enums.PaymentMode;

import java.util.Date;

public class Payment {

    private PaymentMode mode;
    private float amount;
    private String refNumber;
    private Date time;
    private PaymentStaus paymentStatus;
}
