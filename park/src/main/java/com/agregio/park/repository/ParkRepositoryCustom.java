package com.agregio.park.repository;

import com.agregio.constant.MarketType;
import com.agregio.park.entity.Park;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ParkRepositoryCustom {
    List<Park> getParksByMarket(MarketType market);
}
