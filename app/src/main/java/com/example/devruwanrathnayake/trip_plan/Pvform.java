package com.example.devruwanrathnayake.trip_plan;

public class Pvform {

    private String NIC;
    private String customerName;
    private String email;
    private String tp;
    private String arrivaldate;
    private String depaturedate;
    private String facilities;

    public Pvform() {
        this.NIC = NIC;
        this.customerName = customerName;
        this.email = email;
        this.tp = tp;
        this.arrivaldate = arrivaldate;
        this.depaturedate = depaturedate;
        this.facilities = facilities;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(String arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public String getDepaturedate() {
        return depaturedate;
    }

    public void setDepaturedate(String depaturedate) {
        this.depaturedate = depaturedate;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }
}
