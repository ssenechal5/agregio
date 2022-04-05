package com.agregio.offer.controller;

import com.agregio.offer.dto.market.MarketRequest;
import com.agregio.offer.dto.offer.OfferRegistrationRequest;
import com.agregio.offer.entity.Offer;
import com.agregio.offer.service.OfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/offers")
public record OfferController(OfferService offerService) {

    @PostMapping
    public Offer registerOffer(@RequestBody OfferRegistrationRequest offerRegistrationRequest) {
        log.info("New Offer Registration {}", offerRegistrationRequest);
        return offerService.registerOffer(offerRegistrationRequest);
    }

    @GetMapping
    public List<Offer> getOffers() {
        log.info("Get Offers");
        return offerService.getOffers();
    }

    @GetMapping(path = "/byMarket")
    public List<Offer> getOffersByMarket(@RequestBody MarketRequest offersRequest) {
        log.info("Get market Offers {}", offersRequest);
        return offerService.getOffersByMarket(offersRequest.market());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Offer> get(@PathVariable Long id) {
        return offerService.getOffer(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Offer update(@PathVariable Long id, @RequestBody Offer offer) {
        return offerService.updateOffer(id, offer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id) {
        return offerService.deleteOffer(id);
    }

}
