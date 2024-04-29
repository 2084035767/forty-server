package org.zs.forty.service;

import java.util.List;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.ProductDTO;
import org.zs.forty.model.vo.ProductVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description:
 **/
public interface ProductService {
  // void findById(Integer id);
  //
  // void findByName(String productName);
  
  List<ProductVO> findByCategory(String category, PageDTO pageDTO);
  
  List<ProductVO> findAll(PageDTO pageDTO);
  
  //  List<ProductVO> findAllProduct();
  
  ProductVO insert(ProductDTO productDTO);
  
  Boolean update(ProductDTO productDTO);
  
  Boolean deleteById(Long id);
  
  List<ProductVO> sort();
  
  List<ProductVO> sortByStoryLike(Long id);
  
  List<ProductVO> sortByStoryView(Long id);
  
  List<ProductVO> selectProductByUser(Long userId);
  
  List<ProductVO> selectStoryByUser(Long userId);
  
  List<ProductVO> selectAll();
  
  List<ProductVO> selectStoryByPId(Long pId);
  
  // Boolean deleteByUserId(Long createUser);
}