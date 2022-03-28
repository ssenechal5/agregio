package com.agregio.park;

import com.agregio.constant.MarketType;
import com.agregio.entity.Park;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ParkRepositoryCustom {
    List<Park> getParksByMarket(MarketType market);
}
