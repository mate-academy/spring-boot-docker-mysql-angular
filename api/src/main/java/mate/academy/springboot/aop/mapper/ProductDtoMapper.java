package mate.academy.springboot.aop.mapper;

import mate.academy.springboot.aop.model.Product;
import mate.academy.springboot.aop.model.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {
    public ProductResponseDto toResponseDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setCategoryId(product.getCategory().getId());
        return dto;
    }
}
