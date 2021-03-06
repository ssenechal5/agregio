package com.agregio.park.repository;

import com.agregio.park.constant.MarketType;
import com.agregio.park.entity.Park;
import com.agregio.park.entity.Offer;
import com.agregio.park.entity.QPark;
import com.agregio.park.entity.QOffer;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class ParkRepositoryImpl extends QuerydslRepositorySupport implements ParkRepositoryCustom {

    public ParkRepositoryImpl() {
        super(Park.class);
    }

    @Override
    public List<Park> getParksByMarket(MarketType market) {
        QPark park = QPark.park;
        QOffer offer = QOffer.offer;

        Date start = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
        Date end = DateUtils.addDays(start, 1);

        BooleanBuilder where = new BooleanBuilder();
        if (ObjectUtils.allNotNull(market)) {
          where.and(offer.market.eq(market));
        }
        where.and(offer.day.between(start, end));

        return from(park).innerJoin(park.offers, offer).where(where).fetch();
    }
}
