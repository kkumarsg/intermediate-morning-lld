package parkinglot.strategies;

import parkinglot.models.enums.VehicleType;

public interface BillingStrategy {

    Float calculatingBillingAmount(VehicleType vehicleType, Long ticketId);
}
