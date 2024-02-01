package com.agregio.apiproject.offer.domain;

import com.agregio.apiproject.offer.domain.exception.InvalidDateException;

import java.util.Date;

public class HourlyBlock {
    private Date startTime;
    private Date endTime;
    private EnergyQuantity energyQuantity;
    private Price floorPrice;

    public HourlyBlock(
            Date startTime,
            Date endTime,
            EnergyQuantity energyQuantity,
            Price floorPrice
    ) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.energyQuantity = energyQuantity;
        this.floorPrice = floorPrice;
        if (!areDatesValid()) {
            throw new InvalidDateException();
        }
    }

    public boolean areDatesValid() {
        return startTime != null
                && endTime != null
                && startTime.before(endTime);
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public EnergyQuantity getEnergyQuantity() {
        return energyQuantity;
    }

    public Price getFloorPrice() {
        return floorPrice;
    }

    public double getFloorPriceValue() {
        return floorPrice.getAmount();
    }

    public double getEnergyQuantityValue() {
        return energyQuantity.getAmount();
    }
}
