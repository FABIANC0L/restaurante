package com.restauranteApp.controller;
// @author FabianCol

import com.restauranteApp.exception.ExceptionNoFound;
import com.restauranteApp.model.Category;
import com.restauranteApp.service.CategoryService;
import com.restauranteApp.service.ICategoryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(value = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("categories")
    public List<Category> getCategories() {
        return iCategoryService.listCategories();
    }

    @GetMapping("category/{idCategory}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer idCategory) {
        Category category = iCategoryService.findCategoryById(idCategory);
        if (category == null) {
            throw new ExceptionNoFound("La categoria no se ha encontrado: " + idCategory);
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping("category")
    public Category postCategory(@RequestBody Category category) {
        return iCategoryService.saveCategory(category);
    }

    @PutMapping("category/{id}")
    public ResponseEntity<Category> putCategoryById(@PathVariable Integer id, @RequestBody Category categoryObj) {
        Category category = iCategoryService.findCategoryById(id);
        if (category == null) {
            throw new ExceptionNoFound("Categoria no encontrada: " + id);
        }
        category.setNameCategory(categoryObj.getNameCategory());

        Category updatedCategory = iCategoryService.saveCategory(category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("category/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCategoryById(@PathVariable Integer id) {
        Category category = iCategoryService.findCategoryById(id);
        if (category == null) {
            throw new ExceptionNoFound("Categoria no encontrada: " + id);
        }
        iCategoryService.deleteCategory(category);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Categoria eliminada", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
