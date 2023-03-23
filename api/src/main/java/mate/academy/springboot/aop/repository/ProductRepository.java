package mate.academy.springboot.aop.repository;

import java.util.Optional;
import mate.academy.springboot.aop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(
            value = "select * from product "
              + "where category_id = :categoryId order by price DESC limit 1",
            nativeQuery = true
    )
    Optional<Product> findTheMostExpensiveByCategoryId(
            @Param("categoryId") Long categoryId
    );
}
