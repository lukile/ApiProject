package com.agregio.apiproject.offer.domain;

import java.util.List;

public interface OfferRepository {
    List<Offer> findAll();

    Offer insert(Offer offer);
}
