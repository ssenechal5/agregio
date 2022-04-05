package com.agregio.park.controller;

import com.agregio.park.dto.market.MarketRequest;
import com.agregio.park.dto.park.ParkRegistrationRequest;
import com.agregio.park.entity.Park;
import com.agregio.park.service.ParkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/parks")
public record ParkController(ParkService parkService) {

    @PostMapping
    public Park registerPark(@RequestBody ParkRegistrationRequest parkRegistrationRequest) {
        log.info("New Park Registration {}", parkRegistrationRequest);
        return parkService.registerPark(parkRegistrationRequest);
    }

    @GetMapping
    public List<Park> getParks() {
        log.info("Get Parks ");
        return parkService.getParks();
    }

    @GetMapping(path = "/byMarket")
    public List<Park> getParksByMarket(@RequestBody MarketRequest marketRequest) {
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
