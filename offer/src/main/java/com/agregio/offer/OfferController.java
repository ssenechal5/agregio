package com.agregio.offer;

import com.agregio.entity.Offer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/parks")
public record OfferController(OfferService offerService) {

    @PostMapping
    public boolean registerOffer(@RequestBody OfferRegistrationRequest offerRegistrationRequest) {
        log.info("New Offer Registration {}", offerRegistrationRequest);
        return offerService.registerOffer(offerRegistrationRequest);
    }

    @GetMapping
    public List<Offer> getOffersByMarket(MarketRequest offersRequest) {
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
