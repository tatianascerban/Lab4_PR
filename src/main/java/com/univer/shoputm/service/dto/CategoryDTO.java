package com.univer.shoputm.service.dto;

public class CategoryDTO {
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "CategoryDTO{" +
        "title='" + title + '\'' +
        '}';
  }
}