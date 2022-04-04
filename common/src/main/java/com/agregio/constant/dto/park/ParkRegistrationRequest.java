package com.agregio.constant.dto.park;

import com.agregio.constant.ParkType;

public record ParkRegistrationRequest(
        String name,
        ParkType type) {
}
