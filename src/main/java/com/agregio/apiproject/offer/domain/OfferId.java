package com.agregio.apiproject.offer.domain;

import java.util.Objects;
import java.util.UUID;

public class OfferId {
    private String value;

    private OfferId(UUID value) {
        this.value = value.toString();
    }

    public String getValue() {
        return value;
    }

    public static OfferId create() {
        return new OfferId(UUID.randomUUID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferId offerId = (OfferId) o;
        return Objects.equals(value, offerId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
