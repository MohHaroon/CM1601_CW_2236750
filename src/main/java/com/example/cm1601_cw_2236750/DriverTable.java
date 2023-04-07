package com.example.cm1601_cw_2236750;

public class DriverTable {
    private String driverName;
    private String driverAge;
    private String driverTeam;
    private String driverCar;
    private String driverPoints;


    public DriverTable(String driverName, String driverAge, String driverTeam, String driverCar, String driverPoints) {
        this.driverName = driverName;
        this.driverAge = driverAge;
        this.driverTeam = driverTeam;
        this.driverCar = driverCar;
        this.driverPoints = driverPoints;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverAge() {
        return driverAge;
    }

    public String getDriverTeam() {
        return driverTeam;
    }

    public String getDriverCar() {
        return driverCar;
    }

    public String getDriverPoints() {
        return driverPoints;
    }
}
