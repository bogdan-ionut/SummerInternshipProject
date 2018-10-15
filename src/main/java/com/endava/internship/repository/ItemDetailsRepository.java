package com.endava.internship.repository;

import com.endava.internship.domain.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Item Details
 */
@Repository
public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Long> {
}
