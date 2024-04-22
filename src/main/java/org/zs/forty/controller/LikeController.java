package org.zs.forty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.vo.LikeVO;
import org.zs.forty.service.LikeService;

@Tag(name = "点赞管理")
@RestController
@RequestMapping("/api/like")
public class LikeController {
  @Resource private LikeService likeService;
  
  @Operation(summary = "获取点赞列表")
  @PostMapping("/list")
  public LikeVO selectLike(@Valid @PathVariable@NotNull Long likeId ) {
    return likeService.findById(likeId);
  }
  
  @Operation(summary = "添加点赞")
  @PostMapping
  public LikeVO insert(@Valid @RequestBody LikeDTO likeDTO) {
    return likeService.insert(likeDTO);
  }
  
  @Operation(summary = "删除点赞")
  @DeleteMapping
  public Boolean insert(@Valid @RequestBody@PathVariable Long likeId) {
    return likeService.deleteById(likeId);
  }
  
  @Operation(summary = "更新点赞")
  @PutMapping()
  public Boolean update(@Valid @RequestBody LikeDTO likeDTO) {
    return likeService.update(likeDTO);
  }
}