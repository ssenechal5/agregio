package com.agregio.offer;

import com.agregio.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long>, OfferRepositoryCustom {
}
