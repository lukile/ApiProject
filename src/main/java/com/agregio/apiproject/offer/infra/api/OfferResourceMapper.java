package com.agregio.apiproject.offer.infra.api;

import com.agregio.apiproject.offer.domain.HourlyBlock;
import com.agregio.apiproject.offer.domain.Offer;
import com.agregio.apiproject.offer.infra.api.resource.HourlyBlockResource;
import com.agregio.apiproject.offer.infra.api.resource.OfferResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OfferResourceMapper {

    public OfferResource toResource(Offer offer) {
        List<HourlyBlockResource> hourlyBlockResources = new ArrayList<>();

        for (HourlyBlock hourlyBlock: offer.getHourlyBlocks()) {
            HourlyBlockResource hourlyBlockResource = new HourlyBlockResource()
                    .setStartTime(hourlyBlock.getStartTime())
                    .setEndTime(hourlyBlock.getEndTime())
                    .setEnergyQuantity(hourlyBlock.getEnergyQuantityValue())
                    .setFloorPrice(hourlyBlock.getFloorPriceValue());

            hourlyBlockResources.add(hourlyBlockResource);

        }

        return new OfferResource()
                .setId(offer.getId().getValue())
                .setHourlyBlocks(hourlyBlockResources);
    }
}
