package com.agregio.offer;

import com.agregio.constant.MarketType;
import com.agregio.entity.Offer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public record OfferService(OfferRepository offerRepository, RestTemplate restTemplate) {

    public void registerOffer(OfferRegistrationRequest request) {
        Offer offer = Offer.builder()
                .day(request.day())
                .market(request.market())
                .quantity(request.quantity())
                .bottomPrice(request.bottomPrice())
                .chunk(request.chunk())
                .park(request.park())
                .build();

        // TODO: Validate Request

        offerRepository.saveAndFlush(offer);
    }

    public Optional<Offer> getOffer(Long id) {
        return offerRepository.findById(id);
    }

    public List<Offer> getOffersByMarket(MarketType market) {
        return offerRepository.getOffersByMarket(market);
    }

}
