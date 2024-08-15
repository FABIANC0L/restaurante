
package com.restauranteApp.service;

import com.restauranteApp.model.Category;
import java.util.List;

/**
 *
 * @author FabianCol
 */
public interface ICategoryService {

    public List<Category> listCategories();
    
    public Category findCategoryById(Integer idCategory);
    
    public Category saveCategory(Category category);
    
    public void deleteCategory(Category category);
    
}
