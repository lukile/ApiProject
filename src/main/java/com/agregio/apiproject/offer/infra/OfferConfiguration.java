package com.agregio.apiproject.offer.infra;

import com.agregio.apiproject.offer.domain.OfferService;
import com.agregio.apiproject.offer.infra.repository.Dataset;
import com.agregio.apiproject.offer.infra.repository.InMemoryOfferRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferConfiguration {

    @Bean
    public OfferService offerService() {
        InMemoryOfferRepository offerRepository = new InMemoryOfferRepository(Dataset.createListOffer());
        return new OfferService(offerRepository);
    }
}
