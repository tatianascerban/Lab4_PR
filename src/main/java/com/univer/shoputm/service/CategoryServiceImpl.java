package com.univer.shoputm.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.univer.shoputm.domain.Category;
import com.univer.shoputm.domain.Product;
import com.univer.shoputm.service.dto.CategoryDTO;
import com.univer.shoputm.util.RequestServiceUtil;
import com.univer.shoputm.util.Mapper;
import com.univer.shoputm.util.RequestConstants;
import com.univer.shoputm.util.enums.HttpMethod;
import java.io.File;
import java.net.http.HttpRequest;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

  private final RequestServiceUtil categoryServiceUtil;
  private final Mapper mapper;

  public CategoryServiceImpl() {
    this.categoryServiceUtil = RequestServiceUtil.getInstance();
    this.mapper = Mapper.getInstance();
  }

  @Override
  public void getAllCategories() {
    String url = RequestConstants.URL + RequestConstants.CATEGORY_PATH;
    HttpRequest httpRequest = categoryServiceUtil.buildHttpRequest(url, null, HttpMethod.GET);
    String responseBody = categoryServiceUtil.getResponseBodyByHttpRequest(httpRequest);
    List<Category> categoryList = mapper.mapToPojoList(responseBody, new TypeReference<>() {});
    categoryList.forEach(System.out::println);
  }

  @Override
  public void getCategoryById(Long id) {
    String url = RequestConstants.URL + RequestConstants.CATEGORY_PATH + RequestConstants.SEPARATOR + id;
    HttpRequest httpRequest = categoryServiceUtil.buildHttpRequest(url, null, HttpMethod.GET);
    String responseBody = categoryServiceUtil.getResponseBodyByHttpRequest(httpRequest);
    List<Category> categoryList = mapper.mapToPojoList(responseBody, new TypeReference<>() {
    });
    categoryList.forEach(System.out::println);
  }

  @Override
  public void deleteCategoryById(Long id) {
    String url = RequestConstants.URL + RequestConstants.CATEGORY_PATH + RequestConstants.SEPARATOR + id;
    HttpRequest httpRequest = categoryServiceUtil.buildHttpRequest(url, null, HttpMethod.DELETE);
    String responseBody = categoryServiceUtil.getResponseBodyByHttpRequest(httpRequest);
    System.out.println(responseBody);
  }

  @Override
  public void getCategoryProducts(Long id) {
    String url = RequestConstants.URL + RequestConstants.CATEGORY_PATH + RequestConstants.SEPARATOR + id
        + RequestConstants.PRODUCTS;
    HttpRequest httpRequest = categoryServiceUtil.buildHttpRequest(url, null, HttpMethod.GET);
    String responseBody = categoryServiceUtil.getResponseBodyByHttpRequest(httpRequest);
    System.out.println(responseBody);
  }

  @Override
  public void createCategoryProduct(Product product, Long categoryId) {
    String url = RequestConstants.URL + RequestConstants.CATEGORY_PATH + RequestConstants.SEPARATOR + categoryId
        + RequestConstants.PRODUCTS;
    HttpRequest httpRequest = categoryServiceUtil.buildHttpRequest(url, product, HttpMethod.POST);
    String responseBody = categoryServiceUtil.getResponseBodyByHttpRequest(httpRequest);
    System.out.println(responseBody);
  }

  @Override
  public void createCategory(CategoryDTO categoryDTO) {
    String url = RequestConstants.URL + RequestConstants.CATEGORY_PATH;
    HttpRequest httpRequest = categoryServiceUtil.buildHttpRequest(url, categoryDTO,
        HttpMethod.POST);
    String responseBody = categoryServiceUtil.getResponseBodyByHttpRequest(httpRequest);
    System.out.println(responseBody);
  }

  @Override
  public void searchCategoryByName(String categoryName) {
    String url = RequestConstants.URL + RequestConstants.CATEGORY_PATH + RequestConstants.SEARCH
        + RequestConstants.REQUEST_PARAM_CATEGORY_NAME + categoryName;
    HttpRequest httpRequest = categoryServiceUtil.buildHttpRequest(url, null, HttpMethod.GET);
    String responseBody = categoryServiceUtil.getResponseBodyByHttpRequest(httpRequest);
    System.out.println(responseBody);
  }

  @Override
  public void editCategoryName(CategoryDTO categoryDTO, Long id) {
    String url = RequestConstants.URL + RequestConstants.CATEGORY_PUT + RequestConstants.SEPARATOR + id;
    HttpRequest httpRequest = categoryServiceUtil.buildHttpRequest(url, categoryDTO,
        HttpMethod.PUT);
    String responseBody = categoryServiceUtil.getResponseBodyByHttpRequest(httpRequest);
    System.out.println(responseBody);
  }


}
