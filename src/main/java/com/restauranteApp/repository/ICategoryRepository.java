
package com.restauranteApp.repository;

import com.restauranteApp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author FabianCol
 */
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer>{
    
}
