package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.entity.Product;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/21
 * @Description:
 **/
@SpringBootTest
class ProductMapperTest {
  @Resource
  private ProductMapper productMapper;
  
  @Test
  void selectById() {
    Product product = productMapper.selectById(1L);
    System.out.println(product);
    assert product != null;
  }
  
  @Test
  void selectByName() {
    List<Product> product = productMapper.selectByName("商品1");
    assert product != null;
  }
  
  @Test
  void selectByCategory() {
    List<Product> category = productMapper.selectByCategory("分类1");
    assert !category.isEmpty();
  }
  
  @Test
  void selectList() {
    List<Product> products = productMapper.selectList();
    assert !products.isEmpty();
  }
  
  @Test
  void selectByStatus() {
    List<Product> products = productMapper.selectByStatus(0);
    assert !products.isEmpty();
  }
  
  @Test
  void selectByStatusAndCategory() {
    List<Product> products = productMapper.selectByStatusAndCategory(0, "分类1");
    assert !products.isEmpty();
  }
  
  @Test
  void insert() {
  }
  
  @Test
  void update() {
  }
  
  @Test
  void deleteById() {
  }
}