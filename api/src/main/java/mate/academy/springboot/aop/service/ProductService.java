package mate.academy.springboot.aop.service;

import java.util.List;
import mate.academy.springboot.aop.model.Product;

public interface ProductService {
    List<Product> findAll();

    List<Product> getByCategoryId(Long categoryId);

    Product save(Product category);

    Product getTheMostExpensiveByCategoryId(Long categoryId);
}
