package com.endava.internship.repository;

import com.endava.internship.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the Report
 */
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
