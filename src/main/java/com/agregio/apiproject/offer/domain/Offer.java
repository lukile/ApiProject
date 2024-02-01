package com.agregio.apiproject.offer.domain;

import java.util.List;

public class Offer {

    private OfferId id;
    private List<HourlyBlock> hourlyBlocks;
    private MarketType marketType;

    public Offer(OfferId id, List<HourlyBlock> hourlyBlock, MarketType marketType) {
        this.id = id;
        this.hourlyBlocks = hourlyBlock;
        this.marketType = marketType;
    }

    public OfferId getId() {
        return id;
    }

    public List<HourlyBlock> getHourlyBlocks() {
        return hourlyBlocks;
    }

    public MarketType getMarketType() {
        return marketType;
    }
}
