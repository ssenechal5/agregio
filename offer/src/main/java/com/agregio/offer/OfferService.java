package com.agregio.offer;

import com.agregio.constant.MarketType;
import com.agregio.entity.Offer;
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
                .park(request.park())
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
