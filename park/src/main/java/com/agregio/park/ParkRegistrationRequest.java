package com.agregio.park;

import com.agregio.constant.ParkType;

public record ParkRegistrationRequest(
        String name,
        ParkType type) {
}
