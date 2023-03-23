package mate.academy.springboot.aop.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import mate.academy.springboot.aop.model.Category;
import mate.academy.springboot.aop.model.Product;
import mate.academy.springboot.aop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class ProductServiceImplTest {
  @MockBean
  private ProductRepository productRepository;

  @Autowired
  private ProductServiceImpl productService;

  @Test
  void getTheMostExpensiveByCategoryId_productExists_ok() {
    final String mockProductName = "mockProductName";
    final int mockPrice = 10;
    Category mockCategory = new Category(1L, "category 1");
    Product mockProduct = new Product(1L, mockProductName, BigDecimal.valueOf(mockPrice), mockCategory);
    Mockito.when(productRepository.findTheMostExpensiveByCategoryId(1L))
      .thenReturn(Optional.of(mockProduct));

    Product actualProduct = productService.getTheMostExpensiveByCategoryId(1L);

    assertNotNull(actualProduct);
    assertEquals(mockProduct.getId(), actualProduct.getId());
  }
}