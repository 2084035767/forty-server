package org.zs.forty.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
import org.zs.forty.model.vo.ResultVO;
import org.zs.forty.model.vo.StoryVO;
import org.zs.forty.service.ProductService;
import org.zs.forty.service.StoryService;

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
  @Resource private StoryService storyService;
  
  @Operation(summary = "获取商品列表")
  @PostMapping("/list")
  public PageInfo<ProductVO> AllProduct(@Valid @RequestBody PageDTO pageDTO) {
    return new PageInfo<>(productService.findAll(pageDTO));
  }
  
  @Operation(summary = "获取订单商品列表")
  @PostMapping("/user/list/{userId}")
  public List<ProductVO> userProduct(@PathVariable Long userId) {
    return productService.findUserProduct(userId);
  }
  
  @Operation(summary = "id获取商品")
  @GetMapping("/{id}")
  public ProductVO getProduct(@Valid @PathVariable Long id) {
    return productService.findById(id);
  }
  
  @Operation(summary = "获取商品分类")
  @PostMapping("/list/{category}")
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
  public ResultVO<Object> UpdateProduct(@Valid @RequestBody ProductDTO productDTO) {
    return productService.update(productDTO) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "删除商品")
  @DeleteMapping
  public ResultVO<Object> DeleteProduct(@Valid @NotNull @RequestParam Long id) {
    return productService.deleteById(id) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "根据点赞排序")
  @GetMapping("/like/{id}")
  public List<ProductVO> sortByStoryLike(@PathVariable Long id) {
    return productService.sortByStoryLike(id);
  }
  
  @Operation(summary = "根据浏览量排序")
  @GetMapping("/view/{id}")
  public List<ProductVO> sortByStoryView(@PathVariable Long id) {
    return productService.sortByStoryView(id);
  }
  
  @Operation(summary = "根据浏览量排序")
  @GetMapping("/story/{id}")
  public List<StoryVO> getStoryById(@PathVariable Long id) {
    return storyService.selectStoryByPId(id);
  }
  
  @Operation(summary = "根据用户id获取商品")
  @GetMapping("/orderp/{userId}")
  public List<ProductVO> selectOrderByUser(@PathVariable Long userId) {
    return productService.selectProductByUser(userId);
  }
  
  @Operation(summary = "根据用户id获取故事")
  @GetMapping("/orders/{userId}")
  public List<StoryVO> selectStoryByUser(@PathVariable Long userId) {
    return productService.selectStoryByUser(userId);
  }
  
  @Operation(summary = "获取所有商品")
  @GetMapping
  public List<ProductVO> selectAll() {
    return productService.selectAll();
  }
  
  @Operation(summary = "商品排序")
  @GetMapping("/sort")
  public List<ProductVO> selectSort() {
    return productService.sort();
  }
}