package com.agregio.park.dto.park;

import com.agregio.park.constant.ParkType;

public record ParkRegistrationRequest(
        String name,
        ParkType type) {
}
