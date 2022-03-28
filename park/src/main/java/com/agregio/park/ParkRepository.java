package com.agregio.park;

import com.agregio.entity.Park;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkRepository extends JpaRepository<Park, Long>, ParkRepositoryCustom  {
}
