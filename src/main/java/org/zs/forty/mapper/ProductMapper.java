package org.zs.forty.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.ProductDTO;
import org.zs.forty.model.entity.Product;

import java.util.List;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/14
 * @description:
 **/
@Mapper
public interface ProductMapper {
  
  Product selectById(Long id);
  
  List<Product> selectByName(String productName);
  
  List<Product> selectByCategory(String category);
  
  List<Product> selectList();
  
  List<Product> selectByStatus(int status);
  
  List<Product> selectByStatusAndCategory(int status, String category);
  
  Long insert(ProductDTO productDTO);
  
  int update(ProductDTO productDTO);
  
  int deleteById(Long id);
  List<Product> sortByStoryLike(Long id);
  List<Product> sortByStoryView(Long id);
  List<Product> selectProductByUser(Long userId);
  List<Product> selectStoryByUser(Long userId);
  List<Product> selectAll();
  List<Product> selectStoryByPId(Long id);
}