package org.zs.forty.service;

import java.util.List;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.ProductDTO;
import org.zs.forty.model.vo.ProductVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/2/20
 * @Description:
 **/
public interface ProductService {
  // void findById(Integer id);
  //
  // void findByName(String productName);
  
  List<ProductVO> findByCategory(String category, PageDTO pageDTO);
  
  List<ProductVO> findAll(PageDTO pageDTO);
  
  // List<Product> findAllProduct(Integer pageNum, Integer pageSize);
  
  ProductVO insert(ProductDTO productDTO);
  
  Boolean update(ProductDTO productDTO);
  
  Boolean deleteById(Long id);
  
  // Boolean deleteByUserId(Long createUser);
}