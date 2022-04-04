package com.agregio.park.repository;

import com.agregio.park.entity.Park;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkRepository extends JpaRepository<Park, Long>, ParkRepositoryCustom  {
}
