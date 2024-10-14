package parkinglot.dtos;

public class IssueTicketRequest {

    private String vehicleType;
    private String vehicleNumber;
    private String owner;
    private Long gateId;
    private Long parkingLot;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public Long getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(Long parkingLot) {
        this.parkingLot = parkingLot;
    }
}
