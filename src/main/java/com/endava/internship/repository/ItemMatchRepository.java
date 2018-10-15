package com.endava.internship.repository;

import com.endava.internship.domain.ItemMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Item Matches
 */
@Repository
public interface ItemMatchRepository extends JpaRepository<ItemMatch, Long> {
}
