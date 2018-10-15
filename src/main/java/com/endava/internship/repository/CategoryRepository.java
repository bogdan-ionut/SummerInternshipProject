package com.endava.internship.repository;

import com.endava.internship.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Category
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
