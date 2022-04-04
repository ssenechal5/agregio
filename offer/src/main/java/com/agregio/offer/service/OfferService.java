package com.agregio.offer.service;

import com.agregio.constant.*;
import com.agregio.offer.entity.Offer;
import com.agregio.constant.dto.offer.OfferRegistrationRequest;
import com.agregio.offer.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record OfferService(OfferRepository offerRepository) {

    public boolean registerOffer(OfferRegistrationRequest request) {
        Offer offer = Offer.builder()
                .day(request.day())
                .market(request.market())
                .quantity(request.quantity())
                .bottomPrice(request.bottomPrice())
                .chunk(request.chunk())
                .parkId(request.parkId())
                .build();

        // TODO: Validate Request

        offerRepository.saveAndFlush(offer);
        return true;
    }

    public Optional<Offer> getOffer(Long id) {
        return offerRepository.findById(id);
    }

    public List<Offer> getOffersByMarket(MarketType market) {
        return offerRepository.getOffersByMarket(market);
    }

    public Offer updateOffer(Long id, Offer offerUpdated) {
        Optional<Offer> offer = getOffer(id);
        if (offer.isPresent()) {
            offerUpdated.setId(offer.get().getId());
            return offerRepository.saveAndFlush(offerUpdated);
        }
        return null;
    }

    public boolean deleteOffer(Long id) {
        Optional<Offer> offer = getOffer(id);
        if (offer.isPresent()) {
            offerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
