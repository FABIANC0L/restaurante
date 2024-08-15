
package com.restauranteApp.service;
 // @author FabianCol
import com.restauranteApp.model.Category;
import com.restauranteApp.repository.ICategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private ICategoryRepository iCategoryRepository;
    
    @Override
    public List<Category> listCategories() {
    return iCategoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Integer idCategory) {
        return iCategoryRepository.findById(idCategory).orElse(null);
    }

    @Override
    public Category saveCategory(Category category) {
       return iCategoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Category category) {
        iCategoryRepository.delete(category);
    }

}
