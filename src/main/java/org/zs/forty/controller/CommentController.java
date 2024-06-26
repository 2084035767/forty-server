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
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.model.dto.CommentDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.CommentVO;
import org.zs.forty.model.vo.ResultVO;
import org.zs.forty.service.CommentService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description: 评论管理
 **/
@Tag(name = "评论管理")
@RequestMapping("/api/comment")
@RestController
public class CommentController {
  @Resource
  private CommentService commentService;
  
  @Operation(summary = "获取故事评论列表")
  @GetMapping("/story/{storyId}")
  public List<CommentVO> CommentStory(@Valid @NotNull @PathVariable Long storyId) {
    return commentService.findCommentByStoryId(storyId);
  }
  
  @Operation(summary = "获取用户评论列表")
  @PostMapping("/user/{fromUid}")
  public PageInfo<CommentVO> CommentUser(@Valid @NotNull @PathVariable Long fromUid,
      @Valid @RequestBody PageDTO pageDTO) {
    return new PageInfo<>(commentService.findCommentByFromUid(fromUid, pageDTO));
  }
  
  @Operation(summary = "添加评论")
  @PostMapping
  public CommentVO AddComment(@Valid @RequestBody CommentDTO commentDTO) {
    return commentService.addComment(commentDTO);
  }
  
  @Operation(summary = "修改评论")
  @PutMapping
  public ResultVO<Object> UpdateComment(@Valid @RequestBody CommentDTO commentDTO) {
    return commentService.updateComment(commentDTO) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "删除评论")
  @DeleteMapping("/{id}")
  public ResultVO<Object> DeleteComment(@Valid @NotNull @PathVariable Long id) {
    return commentService.deleteComment(id) ? ResultVO.success() : ResultVO.error();
  }
}