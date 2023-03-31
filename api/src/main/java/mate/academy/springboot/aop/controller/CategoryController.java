package mate.academy.springboot.aop.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.springboot.aop.mapper.CategoryDtoMapper;
import mate.academy.springboot.aop.model.dto.CategoryRequestDto;
import mate.academy.springboot.aop.model.dto.CategoryResponseDto;
import mate.academy.springboot.aop.service.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryDtoMapper categoryDtoMapper;

    @GetMapping
    public List<CategoryResponseDto> getAll() {
        return categoryService.findAll().stream()
                .map(categoryDtoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CategoryResponseDto add(@RequestBody CategoryRequestDto dto) {
        return categoryDtoMapper.toResponseDto(
          categoryService.save(categoryDtoMapper.toModel(dto))
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
