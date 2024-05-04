package org.zs.forty.mapper;

import java.util.List;
import org.zs.forty.model.dto.ProductDTO;
import org.zs.forty.model.entity.Product;
import org.zs.forty.model.vo.ProductVO;
import org.zs.forty.model.vo.StoryVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/14
 * @description:
 **/

public interface ProductMapper {
  
  Product selectById(Long id);
  
  ProductVO selectByIdTwo(Long id);
  
  List<Product> selectByName(String productName);
  
  List<Product> selectByCategory(String category);
  
  List<Product> selectList();
  
  List<ProductVO> selectListSort();
  
  // List<Product> selectListToWeb();
  
  List<Product> selectByStatus(int status);
  
  List<Product> selectByStatusAndCategory(int status, String category);
  
  Long insert(ProductDTO productDTO);
  
  int update(ProductDTO productDTO);
  
  int deleteById(Long id);
  
  List<Product> sortByStoryLike(Long id);
  
  List<Product> sortByStoryView(Long id);
  
  List<ProductVO> selectProductByUser(Long userId);
  
  List<StoryVO> selectStoryByUser(Long userId);
  
  List<ProductVO> selectAll();
  
  List<ProductVO> selectByUserId(Long userId);
}