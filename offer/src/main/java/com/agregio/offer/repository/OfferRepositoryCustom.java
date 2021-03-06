package com.agregio.offer.repository;

import com.agregio.offer.constant.MarketType;
import com.agregio.offer.entity.Offer;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface OfferRepositoryCustom {
    List<Offer> getOffersByMarket(MarketType market);
}
