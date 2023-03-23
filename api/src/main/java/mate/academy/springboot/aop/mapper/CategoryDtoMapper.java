package mate.academy.springboot.aop.mapper;

import mate.academy.springboot.aop.model.Category;
import mate.academy.springboot.aop.model.dto.CategoryResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoMapper {
    public CategoryResponseDto toResponseDto(Category category) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
}
