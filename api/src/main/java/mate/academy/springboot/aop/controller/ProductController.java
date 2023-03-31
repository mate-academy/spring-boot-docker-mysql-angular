package mate.academy.springboot.aop.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.springboot.aop.mapper.ProductDtoMapper;
import mate.academy.springboot.aop.model.dto.ProductResponseDto;
import mate.academy.springboot.aop.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductDtoMapper productResponseDtoMapper;

    @GetMapping
    public List<ProductResponseDto> getAllProducts(@RequestParam Long categoryId) {
        return productService.getByCategoryId(categoryId).stream()
                .map(productResponseDtoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/expensive")
    public ProductResponseDto getExpensive(@RequestParam Long categoryId) {
        return productResponseDtoMapper.toResponseDto(
          productService.getTheMostExpensiveByCategoryId(categoryId)
        );
    }
}
