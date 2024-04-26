package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.ProductMapper;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.ProductDTO;
import org.zs.forty.model.vo.ProductVO;
import org.zs.forty.service.ProductService;

import java.util.List;

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
public class ProductServiceImpl implements ProductService {
  @Resource private ProductMapper productMapper;
  @Resource private MainMapper mainMapper;
  
  @Override
  public List<ProductVO> findByCategory(String category, PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.productList2VO(productMapper.selectByCategory(category));
  }
  
  @Override public List<ProductVO> findAll(PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.productList2VO(productMapper.selectList());
  }
  
  @Override public ProductVO insert(ProductDTO productDTO) {
    return mainMapper.product2VO(productMapper.selectById(productMapper.insert(productDTO)));
  }
  
  @Override public Boolean update(ProductDTO productDTO) {
    return productMapper.update(productDTO) > 0;
  }
  
  @Override public Boolean deleteById(Long id) {
    return productMapper.deleteById(id) > 0;
  }

  @Override
  public List<ProductVO> sortByStroyLike(Long id) {
    return mainMapper.productList2VO(productMapper.sortByStoryLike(id));
  }

  @Override
  public List<ProductVO> sortByStroyView(Long id) {
    return mainMapper.productList2VO(productMapper.sortByStoryView(id));
  }
}