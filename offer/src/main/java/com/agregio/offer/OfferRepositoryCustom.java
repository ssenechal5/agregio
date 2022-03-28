package com.agregio.offer;

import com.agregio.constant.MarketType;
import com.agregio.entity.Offer;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface OfferRepositoryCustom {
    List<Offer> getOffersByMarket(MarketType market);
}
