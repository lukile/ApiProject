package com.agregio.apiproject.offer.domain;

import com.agregio.apiproject.offer.domain.exception.InvalidDateException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class HourlyBlockTest {
    @Test
    void should_throw_exception_when_startTime_is_null() {
        Assertions.assertThatThrownBy(() ->
                new HourlyBlock(
                        null,
                        new Date(),
                        new EnergyQuantity(0),
                        new Price(10)
                )
        ).isInstanceOf(InvalidDateException.class);
    }

    @Test
    void should_throw_exception_when_endTime_is_null() {
        Assertions.assertThatThrownBy(() ->
                new HourlyBlock(
                        new Date(),
                        null,
                        new EnergyQuantity(0),
                        new Price(10)
                )
        ).isInstanceOf(InvalidDateException.class);
    }

    @Test
    void should_throw_exception_when_startTime_is_after_endTime() {
        Assertions.assertThatThrownBy(() ->
                new HourlyBlock(
                        Date.from(Instant.now().plus(5, ChronoUnit.MINUTES)),
                        new Date(),
                        new EnergyQuantity(0),
                        new Price(10)
                )
        ).isInstanceOf(InvalidDateException.class);
    }
}
