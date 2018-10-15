package com.endava.internship.convertor.EntityToDto;

import com.endava.internship.domain.Category;
import com.endava.internship.dto.CategoryDTO;
import org.springframework.stereotype.Component;

/**
 * Class used for converting an CategoryDTO object to Category object
 */
@Component
public class ToDtoCategoryConverter {

    public CategoryDTO convert(Category category) {
        if (null == category) {
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}