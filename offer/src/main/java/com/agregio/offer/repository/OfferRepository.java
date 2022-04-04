package com.agregio.offer.repository;

import com.agregio.offer.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long>, OfferRepositoryCustom {
}
