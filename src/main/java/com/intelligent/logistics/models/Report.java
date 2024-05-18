package com.intelligent.logistics.models;

public class Report {

    private long totalDeliveries;
    private long totalVehicles;
    private long totalDistanceTraveled;
    private double averageDeliveryTime;

    // Getters and Setters

    public long getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(long totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

    public long getTotalVehicles() {
        return totalVehicles;
    }

    public void setTotalVehicles(long totalVehicles) {
        this.totalVehicles = totalVehicles;
    }

    public long getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    public void setTotalDistanceTraveled(long totalDistanceTraveled) {
        this.totalDistanceTraveled = totalDistanceTraveled;
    }

    public double getAverageDeliveryTime() {
        return averageDeliveryTime;
    }

    public void setAverageDeliveryTime(double averageDeliveryTime) {
        this.averageDeliveryTime = averageDeliveryTime;
    }
}
