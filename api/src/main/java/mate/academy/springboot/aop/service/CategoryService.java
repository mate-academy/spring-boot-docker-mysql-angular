package mate.academy.springboot.aop.service;

import java.util.List;
import mate.academy.springboot.aop.model.Category;

public interface CategoryService {
    List<Category> findAll();

    Category save(Category category);
}
