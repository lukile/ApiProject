package com.agregio.apiproject.offer.infra.api.resource;

import java.util.Date;

public class HourlyBlockResource {
    private Date startTime;
    private Date endTime;
    private double energyQuantity;
    private double floorPrice;

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public double getEnergyQuantity() {
        return energyQuantity;
    }

    public double getFloorPrice() {
        return floorPrice;
    }

    public HourlyBlockResource setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public HourlyBlockResource setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public HourlyBlockResource setEnergyQuantity(double energyQuantity) {
        this.energyQuantity = energyQuantity;
        return this;
    }

    public HourlyBlockResource setFloorPrice(double floorPrice) {
        this.floorPrice = floorPrice;
        return this;
    }
}
