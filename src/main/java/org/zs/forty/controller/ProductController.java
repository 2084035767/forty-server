package org.zs.forty.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.ProductDTO;
import org.zs.forty.model.vo.ProductVO;
import org.zs.forty.service.ProductService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description: 商品管理
 **/

@Tag(name = "商品管理")
@RequestMapping("/api/product")
@RestController

public class ProductController {
  @Resource private ProductService productService;
  
  @Operation(summary = "获取商品列表")
  @PostMapping("/list")
  public PageInfo<ProductVO> AllProduct(@Valid @RequestBody PageDTO pageDTO) {
    return new PageInfo<>(productService.findAll(pageDTO));
  }
  
  @Operation(summary = "获取商品分类")
  @PostMapping("/{category}/list")
  public PageInfo<ProductVO> ProductCategory(@Valid @NotNull @PathVariable String category,
      @Valid @RequestBody PageDTO pageDTO) {
    return new PageInfo<>(productService.findByCategory(category, pageDTO));
  }
  
  @Operation(summary = "添加商品")
  @PostMapping
  public ProductVO AddProduct(@Valid @RequestBody ProductDTO productDTO) {
    return productService.insert(productDTO);
  }
  
  @Operation(summary = "更新商品")
  @PutMapping
  public Boolean UpdateProduct(@Valid @RequestBody ProductDTO productDTO) {
    return productService.update(productDTO);
  }
  
  @Operation(summary = "删除商品")
  @DeleteMapping
  public Boolean DeleteProduct(@Valid @NotNull @RequestParam Long id) {
    return productService.deleteById(id);
  }
}