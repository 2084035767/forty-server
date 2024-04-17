package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.entity.Comment;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description:
 **/

@SpringBootTest
class CommentMapperTest {
  @Resource
  private CommentMapper commentMapper;
  
  @Test
  void selectById() {
    Comment comment = commentMapper.selectById(1L);
    assert comment != null;
  }
  
  @Test
  void selectByStoryId() {
    List<Comment> comments = commentMapper.selectByStoryId(1L);
    assert !comments.isEmpty();
  }
  
  @Test
  void selectByFromUid() {
    List<Comment> comments = commentMapper.selectByFromUid(1L);
    assert !comments.isEmpty();
  }
  
  @Test
  void insert() {
    // Long test = commentMapper.insert(
    //     CommentDTO.builder()
    //         .fromUid(1L)
    //         .toUid(2L)
    //         .storyId(1L)
    //         .context("test")
    //         .build());
    // assert test != null;
  }
  
  @Test
  void update() {
    // Long test = (long) commentMapper.update(
    //
    //    CommentDTO.builder()
    //         .id(1L)
    //         .context("test1")
    //         .build());
  }
  
  @Test
  void delete() {
  
  }
}