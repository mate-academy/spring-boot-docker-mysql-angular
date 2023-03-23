package mate.academy.springboot.aop.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.springboot.aop.mapper.ProductDtoMapper;
import mate.academy.springboot.aop.model.Product;
import mate.academy.springboot.aop.model.dto.ProductResponseDto;
import mate.academy.springboot.aop.service.CategoryService;
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
    private final CategoryService categoryService;

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.findAll().stream()
                .map(productResponseDtoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/expensive")
    public ProductResponseDto getExpensive(@RequestParam Long categoryId) {
        return productResponseDtoMapper.toResponseDto(
          productService.getTheMostExpensiveByCategoryId(categoryId)
        );
    }

    @GetMapping("/inject")
    public String injectProduct() {
        Product product = new Product();
        product.setCategory(categoryService.findAll().get(0));
        product.setPrice(BigDecimal.valueOf(10));
        product.setName("name");
        productService.save(product);
        return "Success!!";
    }
}
