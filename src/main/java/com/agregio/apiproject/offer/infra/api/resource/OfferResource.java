package com.agregio.apiproject.offer.infra.api.resource;

import java.util.List;

public class OfferResource {
    private String id;
    private List<HourlyBlockResource> hourlyBlocks;

    public String getId() {
        return id;
    }

    public List<HourlyBlockResource> getHourlyBlocks() {
        return hourlyBlocks;
    }

    public OfferResource setId(String id) {
        this.id = id;
        return this;
    }

    public OfferResource setHourlyBlocks(List<HourlyBlockResource> hourlyBlocks) {
        this.hourlyBlocks = hourlyBlocks;
        return this;
    }
}
