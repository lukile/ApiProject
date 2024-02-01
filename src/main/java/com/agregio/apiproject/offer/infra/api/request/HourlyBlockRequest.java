package com.agregio.apiproject.offer.infra.api.request;

import java.util.Date;

public class HourlyBlockRequest {
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
}
