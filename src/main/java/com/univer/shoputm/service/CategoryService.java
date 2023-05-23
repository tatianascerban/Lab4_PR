package com.univer.shoputm.service;

import com.univer.shoputm.domain.Product;
import com.univer.shoputm.service.dto.CategoryDTO;

public interface CategoryService {
  void getAllCategories();
  void getCategoryById(Long id);

  void deleteCategoryById(Long id);
  void getCategoryProducts(Long id);

  void createCategoryProduct(Product product, Long categoryId);
  void createCategory(CategoryDTO categoryDTO);

  void searchCategoryByName(String categoryName);

  void editCategoryName(CategoryDTO categoryDTO, Long id);
}
