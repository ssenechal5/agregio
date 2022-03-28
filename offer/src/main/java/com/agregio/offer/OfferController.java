package com.agregio.offer;

import com.agregio.entity.Offer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/parks")
public record OfferController(OfferService offerService) {

    @PostMapping
    public void registerOffer(@RequestBody OfferRegistrationRequest offerRegistrationRequest) {
        log.info("New Offer Registration {}", offerRegistrationRequest);
        offerService.registerOffer(offerRegistrationRequest);
    }

    @GetMapping
    public List<Offer> getOffersByMarket(MarketRequest offersRequest) {
        log.info("Get market Offers {}", offersRequest);
        return offerService.getOffersByMarket(offersRequest.market());
    }
}
