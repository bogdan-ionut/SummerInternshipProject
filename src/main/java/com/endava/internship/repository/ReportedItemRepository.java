package com.endava.internship.repository;

import com.endava.internship.domain.ReportedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for ReportedItem
 */
@Repository
public interface ReportedItemRepository extends JpaRepository<ReportedItem, Long> {

    /**
     * Custom method used for retrieving a list of ReportedItems according to the Category name
     *
     * @param name - Category name
     * @return List of ReportedItem objects
     */
    List<ReportedItem> findByCategoryName(String name);
}
