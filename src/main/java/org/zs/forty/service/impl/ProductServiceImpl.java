package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.common.mapstruct.MainMapper;
import org.zs.forty.mapper.ProductMapper;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.ProductDTO;
import org.zs.forty.model.vo.ProductVO;
import org.zs.forty.model.vo.StoryVO;
import org.zs.forty.service.ProductService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description:
 **/
@Slf4j
@Service
@MappingIgnore
@CacheConfig(cacheNames = "ProductService")
public class ProductServiceImpl implements ProductService {
  @Resource private ProductMapper productMapper;
  @Resource private MainMapper mainMapper;
  
  @Override
  @Cacheable(key = "#category")
  public List<ProductVO> findByCategory(String category, PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.productList2VO(productMapper.selectByCategory(category));
  }
  
  @Override public List<ProductVO> findAll(PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.productList2VO(productMapper.selectList());
  }
  
  @Override
  @Cacheable(key = "#productDTO.id")
  public ProductVO insert(ProductDTO productDTO) {
    return mainMapper.product2VO(productMapper.selectById(productMapper.insert(productDTO)));
  }
  
  @Override
  @CachePut(key = "#productDTO.id")
  public Boolean update(ProductDTO productDTO) {
    return productMapper.update(productDTO) > 0;
  }
  
  @Override
  @CacheEvict(key = "#id")
  public Boolean deleteById(Long id) {
    return productMapper.deleteById(id) > 0;
  }
  
  @Cacheable(key = "#root.methodName")
  @Override public List<ProductVO> sort() {
    return productMapper.selectListSort();
  }
  
  @Cacheable(key = "#id")
  @Override
  public List<ProductVO> sortByStoryLike(Long id) {
    return mainMapper.productList2VO(productMapper.sortByStoryLike(id));
  }
  
  @Cacheable(key = "#id")
  @Override
  public List<ProductVO> sortByStoryView(Long id) {
    return mainMapper.productList2VO(productMapper.sortByStoryView(id));
  }
  
  @Cacheable(key = "#userId")
  @Override
  public List<ProductVO> selectProductByUser(Long userId) {
    return productMapper.selectProductByUser(userId);
  }
  
  @Cacheable(key = "#userId")
  @Override
  public List<StoryVO> selectStoryByUser(Long userId) {
    return productMapper.selectStoryByUser(userId);
  }
  
  @Cacheable(key = "#root.methodName")
  @Override
  public List<ProductVO> selectAll() {
    return productMapper.selectAll();
  }
  
  @Cacheable(key = "#id")
  @Override public ProductVO findById(Long id) {
    return productMapper.selectByIdTwo(id);
  }
  
  @Override public List<ProductVO> findUserProduct(Long userId) {
    return productMapper.selectByUserId(userId);
  }
}