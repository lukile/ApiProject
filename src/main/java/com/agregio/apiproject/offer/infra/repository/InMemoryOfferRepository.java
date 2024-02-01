package com.agregio.apiproject.offer.infra.repository;

import com.agregio.apiproject.offer.domain.Offer;
import com.agregio.apiproject.offer.domain.OfferRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOfferRepository implements OfferRepository {

    private final List<Offer> database;

    public InMemoryOfferRepository(List<Offer> database) {
        this.database = database;
    }

    @Override
    public List<Offer> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public Offer insert(Offer offer) {
        database.add(offer);
        return offer;
    }
}
