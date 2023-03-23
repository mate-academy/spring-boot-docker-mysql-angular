package mate.academy.springboot.aop.controller;

import java.math.BigDecimal;
import java.util.List;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import mate.academy.springboot.aop.model.Category;
import mate.academy.springboot.aop.model.Product;
import mate.academy.springboot.aop.service.ProductService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class ProductControllerTest {
    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void findAll_ok() {
        final String mockProductName = "mockProductName";
        final int mockPrice = 10;
        Category mockCategory = new Category(1L, "");
        List<Product> mockProducts = List.of(
                new Product(1L, mockProductName, BigDecimal.valueOf(mockPrice), mockCategory)
        );
        Mockito.when(productService.findAll()).thenReturn(mockProducts);

        RestAssuredMockMvc.when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("size()", Matchers.equalTo(1))
                .body("[0].id", Matchers.equalTo(1))
                .body("[0].name", Matchers.equalTo(mockProductName))
                .body("[0].price", Matchers.equalTo(mockPrice))
                .body("[0].categoryId", Matchers.equalTo(1));
    }

    @Test
    void findExpensiveProduct_exists_ok() {
        final String mockProductName = "mockProductName";
        final int mockPrice = 10;
        Category mockCategory = new Category(1L, "category 1");
        Product mockProduct = new Product(1L, mockProductName, BigDecimal.valueOf(mockPrice), mockCategory);
        Mockito.when(productService.getTheMostExpensiveByCategoryId(1L)).thenReturn(mockProduct);

        RestAssuredMockMvc.when()
          .get("/products/expensive?categoryId=1")
          .then()
          .statusCode(200)
          .body("id", Matchers.equalTo(1))
          .body("name", Matchers.equalTo(mockProductName))
          .body("price", Matchers.equalTo(mockPrice))
          .body("categoryId", Matchers.equalTo(1));
    }
}