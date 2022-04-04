package com.agregio.offer.service;

import com.agregio.constant.ChunkType;
import com.agregio.constant.MarketType;
import com.agregio.constant.ParkType;
import com.agregio.constant.dto.offer.OfferRegistrationRequest;
import com.agregio.offer.entity.Offer;
import com.agregio.offer.repository.OfferRepository;
import com.agregio.offer.service.OfferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Offer tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OfferServiceTest {

    @Mock
    OfferRepository offerRepository;

    OfferService offerService;

    @BeforeEach
    void setUp() {
        offerService = new OfferService(offerRepository);
    }

    @Test
    void getOffer() {
    }

    @Test
    void getOffersByMarket() {
    }

    @Test
    void updateOffer() {
    }

    @Test
    void deleteOffer() {
    }

    @Test
    void registerOffer() {
        OfferRegistrationRequest requestOffer = new OfferRegistrationRequest(new Date(), MarketType.PRIMARY,
                new BigDecimal(1000), new BigDecimal(100), ChunkType.TIME0TO3, 1L);
        Offer offer = Offer.builder()
                .day(requestOffer.day())
                .market(requestOffer.market())
                .quantity(requestOffer.quantity())
                .bottomPrice(requestOffer.bottomPrice())
                .chunk(requestOffer.chunk())
                .parkId(requestOffer.parkId())
                .build();

        when(offerRepository.saveAndFlush(ArgumentMatchers.any(Offer.class))).thenReturn(offer);
        assertTrue(offerService.registerOffer(requestOffer));
    }
}