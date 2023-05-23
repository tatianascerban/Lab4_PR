package com.univer.shoputm;
import com.univer.shoputm.domain.Product;
import com.univer.shoputm.service.CategoryService;
import com.univer.shoputm.service.CategoryServiceImpl;
import com.univer.shoputm.service.dto.CategoryDTO;
import java.util.Scanner;

public class Main {
  public static final CategoryService categoryService = new CategoryServiceImpl();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int choice = 0;
    boolean isRunning = true;
    while (isRunning) {
      menu();
      choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1 -> getAllCategories();
        case 2 -> getCategoryById();
        case 3 -> deleteCategoryById();
        case 4 -> getCategoryProducts();
        case 5 -> createCategoryProduct();
        case 6 -> createCategory();
        case 7 -> searchCategoryByName();
        case 8 -> editCategoryName();
        case 9 -> System.exit(0);
        default -> System.out.println("Invalid choice. Please try again.");
      }
      System.out.println();
    }



    categoryService.getAllCategories();
    categoryService.getCategoryById(4L);
    categoryService.deleteCategoryById(4L);
    categoryService.getCategoryProducts(5L);
    categoryService.createCategoryProduct(new Product(0L,"rubin", 25L, 0L),5L);
    CategoryDTO categoryDTO = new CategoryDTO();
    categoryDTO.setTitle("rub");
    categoryService.createCategory(categoryDTO);
    CategoryDTO categoryDTO1 = new CategoryDTO();
    categoryDTO1.setTitle("mamaria");
    categoryService.searchCategoryByName("rub");
    categoryService.editCategoryName(categoryDTO, 7L);
  }

  public static void menu() {
    System.out.println("=== Category Menu ===");
    System.out.println("1. Get all categories");
    System.out.println("2. Get category by ID");
    System.out.println("3. Delete category by ID");
    System.out.println("4. Get category products");
    System.out.println("5. Create category product");
    System.out.println("6. Create category");
    System.out.println("7. Search category by name");
    System.out.println("8. Edit category name");
    System.out.println("9. Exit");
    System.out.print("Enter your choice: ");
  }

  private static void getAllCategories() {
    System.out.println("=== All Categories ===");
    categoryService.getAllCategories();
  }

  private static void getCategoryById() {
    System.out.print("Enter category ID: ");
    Long categoryId = scanner.nextLong();
    scanner.nextLine();

    System.out.println("=== Category by ID ===");
    categoryService.getCategoryById(categoryId);
  }

  private static void deleteCategoryById() {
    System.out.print("Enter category ID to delete: ");
    Long categoryId = scanner.nextLong();
    scanner.nextLine();

    categoryService.deleteCategoryById(categoryId);
  }

  private static void getCategoryProducts() {
    System.out.print("Enter category ID: ");
    Long categoryId = scanner.nextLong();
    scanner.nextLine();

    System.out.println("=== Products of Category ===");
    categoryService.getCategoryProducts(categoryId);
  }

  private static void createCategoryProduct() {
    System.out.print("Enter product name: ");
    String productName = scanner.nextLine();
    System.out.print("Enter product price: ");
    Long productPrice = scanner.nextLong();
    scanner.nextLine();
    System.out.print("Enter category ID: ");
    Long categoryId = scanner.nextLong();
    scanner.nextLine();

    Product product = new Product(0L, productName, productPrice, 0L);
    categoryService.createCategoryProduct(product, categoryId);
  }

  private static void createCategory() {
    System.out.print("Enter category title: ");
    String categoryTitle = scanner.nextLine();

    CategoryDTO categoryDTO = new CategoryDTO();
    categoryDTO.setTitle(categoryTitle);
    categoryService.createCategory(categoryDTO);
    System.out.println("Category created.");
  }

  private static void searchCategoryByName() {
    System.out.print("Enter category name to search: ");
    String categoryName = scanner.nextLine();

    System.out.println("=== Search Results ===");
    categoryService.searchCategoryByName(categoryName);
  }

  private static void editCategoryName() {
    System.out.print("Enter category ID to edit: ");
    Long categoryId = scanner.nextLong();
    scanner.nextLine();
    System.out.print("Enter new category title: ");
    String newCategoryTitle = scanner.nextLine();

    CategoryDTO categoryDTO = new CategoryDTO();
    categoryDTO.setTitle(newCategoryTitle);
    categoryService.editCategoryName(categoryDTO, categoryId);
    System.out.println("Category name updated for ID " + categoryId + ".");
  }
}