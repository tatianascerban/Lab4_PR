package com.univer.shoputm.domain;

public class Product {
  private Long id;
  private String title;
  private Long price;
  private Long categoryId;

  public Product() {
  }

  public Product(String title, Long price) {
    this.title = title;
    this.price = price;
  }

  public Product(Long id, String title, Long price, Long categoryId) {
    this.id = id;
    this.title = title;
    this.price = price;
    this.categoryId = categoryId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", price=" + price +
        ", categoryId=" + categoryId +
        '}';
  }
}