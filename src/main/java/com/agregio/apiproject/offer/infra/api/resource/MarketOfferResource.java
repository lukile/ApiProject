package com.agregio.apiproject.offer.infra.api.resource;

import java.util.List;

public class MarketOfferResource {

    private String marketType;
    private List<OfferResource> offers;

    public MarketOfferResource(String marketType, List<OfferResource> offers) {
        this.marketType = marketType;
        this.offers = offers;
    }

    public String getMarketType() {
        return marketType;
    }

    public List<OfferResource> getOffers() {
        return offers;
    }
}

