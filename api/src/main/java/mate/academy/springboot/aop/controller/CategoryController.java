package mate.academy.springboot.aop.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.springboot.aop.mapper.CategoryDtoMapper;
import mate.academy.springboot.aop.model.Category;
import mate.academy.springboot.aop.model.dto.CategoryResponseDto;
import mate.academy.springboot.aop.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryDtoMapper categoryDtoMapper;

    @GetMapping
    public List<CategoryResponseDto> getAllCategories() {
        return categoryService.findAll().stream()
                .map(categoryDtoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/inject")
    public String injectCategory() {
        Category category = new Category();
        category.setName("category-name");
        categoryService.save(category);
        return "Success!!";
    }
}
