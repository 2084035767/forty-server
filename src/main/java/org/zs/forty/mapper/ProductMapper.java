package org.zs.forty.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.ProductDTO;
import org.zs.forty.model.entity.Product;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/1/14
 * @Description:
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
}