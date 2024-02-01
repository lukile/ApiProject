package com.agregio.apiproject.offer.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferService {

    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Map<MarketType, List<Offer>> findAndGroupByMarketType() {
        List<Offer> offers = offerRepository.findAll();

        return groupByMarketType(offers);
    }

    private Map<MarketType, List<Offer>> groupByMarketType(List<Offer> offers) {
        Map<MarketType, List<Offer>> offersByMarketType = new HashMap<>();
        for (Offer offer : offers) {
            MarketType marketType = offer.getMarketType();

            List<Offer> mapOffers = offersByMarketType.getOrDefault(marketType, new ArrayList<>());
            mapOffers.add(offer);

            offersByMarketType.put(marketType, mapOffers);
        }
        return offersByMarketType;
    }

    public Offer create(MarketType marketType, List<HourlyBlock> hourlyBlocks) {
        Offer offer = new Offer(OfferId.create(), hourlyBlocks, marketType);
        return offerRepository.insert(offer);
    }
}
