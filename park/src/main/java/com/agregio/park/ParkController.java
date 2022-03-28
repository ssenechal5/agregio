package com.agregio.park;

import com.agregio.entity.Park;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/parks")
public record ParkController(ParkService parkService) {

    @PostMapping
    public boolean registerPark(@RequestBody ParkRegistrationRequest parkRegistrationRequest) {
        log.info("New Park Registration {}", parkRegistrationRequest);
        return parkService.registerPark(parkRegistrationRequest);
    }

    @GetMapping
    public List<Park> getParksByMarket(MarketRequest marketRequest) {
        log.info("Get market Parks {}", marketRequest);
        return parkService.getParksByMarket(marketRequest.market());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Park> get(@PathVariable Long id) {
        return parkService.getPark(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Park update(@PathVariable Long id, @RequestBody Park park) {
        return parkService.updatePark(id, park);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id) {
        return parkService.deletePark(id);
    }
}
