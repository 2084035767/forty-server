package org.zs.forty.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.vo.LikeVO;
import org.zs.forty.model.vo.ResultVO;
import org.zs.forty.service.LikeService;

@Tag(name = "点赞管理")
@RestController
@RequestMapping("/api/like")
public class LikeController {
  @Resource private LikeService likeService;
  
  @Operation(summary = "获取点赞列表")
  @PostMapping("/{likeId}/list")
  public LikeVO selectLike(@Valid @PathVariable @NotNull Long likeId) {
    return likeService.findById(likeId);
  }
  
  @Operation(summary = "添加点赞")
  @PostMapping
  public LikeVO insert(@Valid @RequestBody LikeDTO likeDTO) {
    return likeService.insert(likeDTO);
  }
  
  @Operation(summary = "删除点赞")
  @DeleteMapping("/{likeId}")
  public ResultVO<Object> insert(@Valid @NotNull @PathVariable Long likeId) {
    return likeService.deleteById(likeId) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "更新点赞")
  @PutMapping()
  public ResultVO<Object> update(@Valid @RequestBody LikeDTO likeDTO) {
    return likeService.update(likeDTO) ? ResultVO.success() : ResultVO.error();
  }
}