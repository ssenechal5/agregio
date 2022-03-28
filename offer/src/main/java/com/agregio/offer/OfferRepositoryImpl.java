package com.agregio.offer;

import com.agregio.constant.MarketType;
import com.agregio.entity.Offer;
import com.agregio.entity.QOffer;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class OfferRepositoryImpl extends QuerydslRepositorySupport implements OfferRepositoryCustom {

    public OfferRepositoryImpl() {
        super(Offer.class);
    }

    @Override
    public List<Offer> getOffersByMarket(MarketType market) {
        QOffer offer = QOffer.offer;

        Date start = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
        Date end = DateUtils.addDays(start, 1);

        BooleanBuilder where = new BooleanBuilder();
        if (ObjectUtils.allNotNull(market)) {
          where.and(offer.market.eq(market));
        }
        where.and(offer.day.between(start, end));

        return from(offer).where(where).fetch();
    }
}
