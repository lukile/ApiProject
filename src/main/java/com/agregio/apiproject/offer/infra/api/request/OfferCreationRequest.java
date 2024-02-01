package com.agregio.apiproject.offer.infra.api.request;

import java.util.List;

public class OfferCreationRequest {
    private String marketType;
    private List<HourlyBlockRequest> hourlyBlocks;

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public List<HourlyBlockRequest> getHourlyBlocks() {
        return hourlyBlocks;
    }

    public void setHourlyBlocks(List<HourlyBlockRequest> hourlyBlocks) {
        this.hourlyBlocks = hourlyBlocks;
    }
}
