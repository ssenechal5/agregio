package com.agregio.constant.dto.offer;

import com.agregio.constant.ChunkType;
import com.agregio.constant.MarketType;

import java.math.BigDecimal;
import java.util.Date;

public record OfferRegistrationRequest(
        Date day,
        MarketType market,
        BigDecimal quantity,
        BigDecimal bottomPrice,
        ChunkType chunk,
        Long parkId) {
}
