package com.agregio.apiproject.offer.infra.repository;

import com.agregio.apiproject.offer.domain.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dataset {

    public static List<Offer> createListOffer() {
        return new ArrayList<>(List.of(
                new Offer(
                        OfferId.create(),
                        List.of(
                                new HourlyBlock(
                                        createDate(2023, Month.AUGUST, 15, 0, 0),
                                        createDate(2023, Month.AUGUST, 15, 3, 0),
                                        new EnergyQuantity(123),
                                        new Price(4321)
                                ),
                                new HourlyBlock(
                                        createDate(2023, Month.AUGUST, 15, 12, 0),
                                        createDate(2023, Month.AUGUST, 15, 15, 0),
                                        new EnergyQuantity(789),
                                        new Price(1543)
                                )
                        ), MarketType.QUICK_RESERVE
                ),
                new Offer(
                        OfferId.create(),
                        List.of(
                                new HourlyBlock(
                                        createDate(2023, Month.AUGUST, 15, 3, 0),
                                        createDate(2023, Month.AUGUST, 15, 6, 0),
                                        new EnergyQuantity(321),
                                        new Price(8765)
                                ),
                                new HourlyBlock(
                                        createDate(2023, Month.AUGUST, 15, 9, 0),
                                        createDate(2023, Month.AUGUST, 15, 12, 0),
                                        new EnergyQuantity(654),
                                        new Price(5678)
                                )
                        ), MarketType.PRIMARY_RESERVE
                ),
                new Offer(
                        OfferId.create(),
                        List.of(
                                new HourlyBlock(
                                        createDate(2023, Month.AUGUST, 16, 3, 0),
                                        createDate(2023, Month.AUGUST, 16, 6, 0),
                                        new EnergyQuantity(321),
                                        new Price(8765)
                                ),
                                new HourlyBlock(
                                        createDate(2023, Month.AUGUST, 16, 9, 0),
                                        createDate(2023, Month.AUGUST, 16, 12, 0),
                                        new EnergyQuantity(654),
                                        new Price(5678)
                                )
                        ), MarketType.PRIMARY_RESERVE
                ),
                new Offer(
                        OfferId.create(),
                        List.of(
                                new HourlyBlock(
                                        createDate(2023, Month.AUGUST, 15, 6, 0),
                                        createDate(2023, Month.AUGUST, 15, 9, 0),
                                        new EnergyQuantity(456),
                                        new Price(1234)
                                ),
                                new HourlyBlock(
                                        createDate(2023, Month.AUGUST, 15, 15, 0),
                                        createDate(2023, Month.AUGUST, 15, 18, 0),
                                        new EnergyQuantity(987),
                                        new Price(2468)
                                )
                        ), MarketType.SECONDARY_RESERVE
                )
        ));
    }

    private static Date createDate(int year, Month month, int dayOfMonth, int hour, int minute) {
        return Date.from(LocalDateTime.of(year, month, dayOfMonth, hour, minute).toInstant(ZoneOffset.UTC));
    }
}
