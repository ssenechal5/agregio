package com.agregio.park;

import com.agregio.constant.MarketType;
import com.agregio.entity.Park;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record ParkService(ParkRepository parkRepository) {

    public boolean registerPark(ParkRegistrationRequest request) {
        Park park = Park.builder()
                .name(request.name())
                .type(request.type())
                .build();

        // TODO: Validate Request
        parkRepository.saveAndFlush(park);
        return true;
    }

    public Optional<Park> getPark(Long id) {
        return parkRepository.findById(id);
    }

    public List<Park> getParksByMarket(MarketType market) {
        return parkRepository.getParksByMarket(market);
    }

    public Park updatePark(Long id, Park parkUpdated) {
        Optional<Park> park = getPark(id);
        if (park.isPresent()) {
            parkUpdated.setId(park.get().getId());
            return parkRepository.saveAndFlush(parkUpdated);
        }
        return null;
    }

    public boolean deletePark(Long id) {
        Optional<Park> park = getPark(id);
        if (park.isPresent()) {
            parkRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
