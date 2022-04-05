package com.agregio.offer.dto.offer;

import com.agregio.offer.constant.ChunkType;
import com.agregio.offer.constant.MarketType;

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
