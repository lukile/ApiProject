package com.agregio.apiproject.offer.infra.api;

import com.agregio.apiproject.offer.domain.*;
import com.agregio.apiproject.offer.domain.exception.InvalidDateException;
import com.agregio.apiproject.offer.infra.api.request.HourlyBlockRequest;
import com.agregio.apiproject.offer.infra.api.request.OfferCreationRequest;
import com.agregio.apiproject.offer.infra.api.resource.MarketOfferResource;
import com.agregio.apiproject.offer.infra.api.resource.OfferResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/offers")
public class OfferApi {

    private final OfferService offerService;
    private final OfferResourceMapper offerResourceMapper;

    public OfferApi(OfferService offerService, OfferResourceMapper offerResourceMapper) {
        this.offerService = offerService;
        this.offerResourceMapper = offerResourceMapper;
    }

    @GetMapping
    public List<MarketOfferResource> offersByMarket() {
        Map<MarketType, List<Offer>> offersByMarketType = offerService.findAndGroupByMarketType();

        List<MarketOfferResource> marketOfferResources = new ArrayList<>();
        for (Map.Entry<MarketType, List<Offer>> entry : offersByMarketType.entrySet()) {
            MarketType marketType = entry.getKey();
            List<Offer> offers = entry.getValue();

            List<OfferResource> offersResource = new ArrayList<>();
            for (Offer offer : offers) {
                OfferResource offerResource = offerResourceMapper.toResource(offer);
                offersResource.add(offerResource);
            }

            marketOfferResources.add(new MarketOfferResource(marketType.name(), offersResource));
        }

        return marketOfferResources;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OfferCreationRequest offerRequest) {
        try {
            List<HourlyBlock> hourlyBlocks = new ArrayList<>();

            for (HourlyBlockRequest hourlyBlockRequest: offerRequest.getHourlyBlocks()) {
                HourlyBlock hourlyBlock = new HourlyBlock(
                        hourlyBlockRequest.getStartTime(),
                        hourlyBlockRequest.getEndTime(),
                        new EnergyQuantity(hourlyBlockRequest.getEnergyQuantity()),
                        new Price(hourlyBlockRequest.getFloorPrice()));

                hourlyBlocks.add(hourlyBlock);
            }
            Offer offer = offerService.create(MarketType.valueOf(
                    offerRequest.getMarketType()),
                    hourlyBlocks
            );

            return ResponseEntity.created(URI.create("/offers/" + offer.getId().getValue())).build();
        }
        catch (InvalidDateException dateException) {
            return ResponseEntity.badRequest().body(Map.of("message", dateException.getMessage()));
        }
    }
}
