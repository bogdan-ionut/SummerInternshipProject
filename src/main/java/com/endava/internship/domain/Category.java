package com.endava.internship.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * The class used for classifying lost/found items
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;

    @OneToMany(mappedBy = "category")
    private Set<ReportedItem> items;

    public Category() {
    }

    /**
     * Constructor with parameters
     *
     * @param categoryId - category id
     * @param name       - category name
     */
    public Category(Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}