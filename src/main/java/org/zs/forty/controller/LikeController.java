package org.zs.forty.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.LikeVO;
import org.zs.forty.service.LikeService;

@Tag(name = "点赞管理")
@RestController
@RequestMapping("/api/like")
public class LikeController {
  @Resource private LikeService relationService;
  
  @Operation(summary = "获取点赞列表")
  @PostMapping("/list")
  public PageInfo<LikeVO> AllLike(
      @Valid @RequestBody PageDTO pageDTO) {
    return new PageInfo<>(relationService.findByLikeId(pageDTO));
  }
  
  @Operation(summary = "添加点赞")
  @PostMapping
  public LikeVO insert(@Valid @RequestBody LikeDTO likeDTO) {
    return relationService.insert(likeDTO);
  }
  
  @Operation(summary = "删除点赞")
  @DeleteMapping
  public Boolean insert(@Valid @RequestBody@PathVariable Long likeId) {
    return relationService.deleteById(likeId);
  }
  
  @Operation(summary = "更新点赞")
  @PutMapping()
  public Boolean update(@Valid @RequestBody LikeDTO likeDTO) {
    return relationService.update(likeDTO);
  }
}