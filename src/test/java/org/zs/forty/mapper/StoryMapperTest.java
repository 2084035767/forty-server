package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.entity.Story;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description:
 **/
@SpringBootTest
class StoryMapperTest {
  @Resource
  private StoryMapper storyMapper;
  
  @Test
  void selectListByUserId() {
    List<Story> stories = storyMapper.selectListByCreateUser(1L);
    assert !stories.isEmpty();
  }
  
  @Test
  void selectList() {
    List<Story> stories = storyMapper.selectList();
    assert !stories.isEmpty();
  }
  
  @Test
  void selectOpenByList() {
    List<Story> stories = storyMapper.selectOpenByList();
    assert !stories.isEmpty();
  }
  
  @Test
  void selectById() {
    Story story = storyMapper.selectById(1L);
    assert story != null;
  }
  
  @Test
  void updateById() {
  }
  
  @Test
  void insert() {
  }
  
  @Test
  void deleteById() {
  }
}