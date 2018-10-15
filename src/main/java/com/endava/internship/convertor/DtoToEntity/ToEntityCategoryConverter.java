package com.endava.internship.convertor.DtoToEntity;

import com.endava.internship.domain.Category;
import com.endava.internship.dto.CategoryDTO;
import org.springframework.stereotype.Component;

/**
 * Class used for converting an Category object to CategoryDTO object
 */
@Component
public class ToEntityCategoryConverter {

    public Category convert(CategoryDTO categoryDTO) {
        if (null == categoryDTO) {
            return null;
        }
        Category categoryEntity = new Category();
        categoryEntity.setCategoryId(categoryDTO.getCategoryId());
        categoryEntity.setName(categoryDTO.getName());
        return categoryEntity;
    }
}