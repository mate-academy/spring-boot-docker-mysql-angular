package mate.academy.springboot.aop.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import mate.academy.springboot.aop.model.Category;
import mate.academy.springboot.aop.repository.CategoryRepository;
import mate.academy.springboot.aop.service.CategoryService;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        log.info("Trying to get all categories.");
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
