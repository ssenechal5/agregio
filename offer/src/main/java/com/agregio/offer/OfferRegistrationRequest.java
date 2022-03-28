package com.agregio.offer;

import com.agregio.constant.ChunkType;
import com.agregio.constant.MarketType;
import com.agregio.entity.Park;

import java.math.BigDecimal;
import java.util.Date;

public record OfferRegistrationRequest(
        Date day,
        MarketType market,
        BigDecimal quantity,
        BigDecimal bottomPrice,
        ChunkType chunk,
        Park park) {
}
