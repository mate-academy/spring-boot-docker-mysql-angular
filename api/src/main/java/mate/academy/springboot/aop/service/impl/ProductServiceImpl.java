package mate.academy.springboot.aop.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.springboot.aop.model.Product;
import mate.academy.springboot.aop.repository.ProductRepository;
import mate.academy.springboot.aop.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getTheMostExpensiveByCategoryId(Long categoryId) {
        return productRepository.findTheMostExpensiveByCategoryId(categoryId)
          .orElseThrow();
    }
}
