package com.endava.internship.repository;

import com.endava.internship.domain.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for PoliceStation
 */
public interface PoliceStationRepository extends JpaRepository<PoliceStation, Long> {
}