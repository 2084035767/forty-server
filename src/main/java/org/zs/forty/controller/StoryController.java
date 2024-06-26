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
import org.zs.forty.model.dto.StoryDTO;
import org.zs.forty.model.vo.ResultVO;
import org.zs.forty.model.vo.StoryVO;
import org.zs.forty.service.StoryService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description: 故事管理
 **/
@Tag(name = "故事管理")
@RestController
@RequestMapping("/api/story")
public class StoryController {
  @Resource private StoryService storyService;
  
  @Operation(summary = "获取故事列表")
  @PostMapping("/list")
  public PageInfo<StoryVO> AllStory(@Valid @RequestBody PageDTO pageDTO) {
    return new PageInfo<>(storyService.findAllStoryByList(pageDTO));
  }
  
  @Operation(summary = "获取故事列表")
  @GetMapping("/{id}")
  public StoryVO getStory(@Valid @NotNull @PathVariable Long id) {
    return storyService.findById(id);
  }
  
  @Operation(summary = "获取故事列表")
  @GetMapping("user/{userId}")
  public List<StoryVO> getUserStory(@Valid @NotNull @PathVariable Long userId) {
    return storyService.findByCreateUser(userId);
  }
  // @Operation(value = "获取商品故事列表", notes = "获取商品故事列表")
  // @GetMapping("/product/{productId}")
  // public ResultVO ProductStory(@Valid @NotNull @PathVariable Integer productId) {
  //   return ResultVO.success(storyService.findStoryByProductId(productId));
  // }
  
  @Operation(summary = "添加故事")
  @PostMapping
  public StoryVO AddStory(@Valid @RequestBody StoryDTO storyDTO) {
    return storyService.addStory(storyDTO);
  }
  
  @Operation(summary = "删除故事")
  @DeleteMapping
  public ResultVO<Object> DeleteStory(@RequestParam Long createUser,
      @RequestParam Long storyId) {
    return storyService.deleteStory(createUser, storyId) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "更新故事")
  @PutMapping
  public ResultVO<Object> UpdateStory(@Valid @RequestBody StoryDTO storyDTO) {
    return storyService.updateStory(storyDTO) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "获取所有故事")
  @GetMapping
  public List<StoryVO> findAllStoryByOpenList() {
    return storyService.findAllStoryByOpenList();
  }
  
  @Operation(summary = "故事排序")
  @GetMapping("/sort")
  public List<StoryVO> findSort() {
    return storyService.sort();
  }
}