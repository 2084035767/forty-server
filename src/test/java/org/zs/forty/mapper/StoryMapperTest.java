package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.StoryDTO;
import org.zs.forty.model.entity.Story;
import org.zs.forty.model.vo.StoryVO;

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
    List<Story> stories = storyMapper.selectListByCreateUser(3L);
    assert !stories.isEmpty();
  }
  
  @Test
  void selectList() {
    List<Story> stories = storyMapper.selectList();
    assert !stories.isEmpty();
  }
  
  @Test
  void selectOpenByList() {
    List<StoryVO> stories = storyMapper.selectOpenByList();
    assert !stories.isEmpty();
  }
  
  @Test
  void selectById() {
    Story story = storyMapper.selectById(1L);
    assert story != null;
  }
  
  @Test
  void updateById() {
    storyMapper.updateById(
        StoryDTO.builder()
            .id(11L)
            .title("测试标题")
            .context("测试内容")
            .build()
    );
  }
  
  @Test
  void insert() {
    storyMapper.insert(
        StoryDTO.builder()
            .storyLike(1)
            .storyView(2)
            .context("haohaohao")
            .title("good")
            .createUser(9L)
            .isOpen(true)
            .build()
    );
  }
  
  @Test
  void deleteById() {
    storyMapper.deleteById(11L);
  }
  //  @Test
  //  void sortByStory(){
  //    storyMapper.sortByStory();
  //  }
}